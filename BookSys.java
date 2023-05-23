import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookSys {
	public static ArrayList<Book> books = new ArrayList<Book>();
	public static ArrayList<Borrower> borrowers = new ArrayList<Borrower>();
	
	public void readBooksTxt(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		String bookType, bookName, bookAuthor, location, format, isBorrowed, dateBorrowed;
		String courseName, language, level, genre, award, subject;
		int bookId, edition, volume;
		String[] bookAll;
		Book book;
		try {
			scan = new Scanner(file);
			while (scan.hasNext()) {
				bookAll = scan.nextLine().split("\t");
				bookType = bookAll[0];
				bookId = Integer.parseInt(bookAll[1]);
				bookName = bookAll[2];
				bookAuthor = bookAll[3];
				location = bookAll[4];
				format = bookAll[5];
				isBorrowed = bookAll[6];
				dateBorrowed = bookAll[7];
				if (bookType.equalsIgnoreCase("Encyclopedia")) {
					subject = bookAll[8];
					volume = Integer.parseInt(bookAll[9]);
					book = new Encyclopedia(bookId, bookName, bookAuthor, location, format, isBorrowed, dateBorrowed, subject, volume);
					((Encyclopedia)book).read();
					((Encyclopedia)book).findLocation(book.bookName);
				}
				else if (bookType.equalsIgnoreCase("Art Books")) {
					genre = bookAll[8];
					award = bookAll[9];
					book = new ArtBook(bookId, bookName, bookAuthor, location, format, isBorrowed, dateBorrowed, genre, award);
					((ArtBook)book).read();
					((ArtBook)book).findLocation(book.bookName);
				}
				else if (bookType.equalsIgnoreCase("Course Books")) {	
					courseName = bookAll[8];
					edition = Integer.parseInt(bookAll[9]);
					book = new CourseBook(bookId, bookName, bookAuthor, location, format, isBorrowed, dateBorrowed, courseName, edition);
					((CourseBook)book).read();
					((CourseBook)book).findLocation(book.bookName);
				}
				else if (bookType.equalsIgnoreCase("Dictionaries")) {
					language = bookAll[8];
					level = bookAll[9];
					book = new Dictionary(bookId, bookName, bookAuthor, location, format, isBorrowed, dateBorrowed, language, level);
					((Dictionary)book).read();
					((Dictionary)book).findLocation(book.bookName);
				}
				else
					book = new Dictionary(bookId, bookName, bookAuthor, location, format, isBorrowed, dateBorrowed, "", "");
				//bk = new Book(bookId, bookName, bookAuthor, location, format, isBorrowed, dateBorrowed);
				books.add(book);
			}
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public void readBorrowersTxt(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		String borrowerName;
		int borrowerId;
		ArrayList<Integer> keptBooks = new ArrayList<Integer>();
		String[] borrowerAll;
		Borrower borrower;
		try {
			scan = new Scanner(file);
			while (scan.hasNext()) {
				borrowerAll = scan.nextLine().split("\t");
				borrowerId = Integer.parseInt(borrowerAll[0]);
				borrowerName = borrowerAll[1];
				for (int i=2;i<borrowerAll.length; i++) {
					keptBooks.add(Integer.parseInt(borrowerAll[i]));
				}
				borrower = new Borrower(borrowerId, borrowerName, keptBooks);
				borrowers.add(borrower);
			}
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public static Book searchBook(String bookName) {
		Book searchedBook = null;
		for (Book book:books) {
			if (book.bookName.equalsIgnoreCase(bookName))
				searchedBook = book;
		}
		return searchedBook;
	}
	
	public static void addBook() {
		int numBook;
		String type;
		Book addedBook;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of book you want to add = ");
		numBook = Integer.parseInt(scanner.nextLine());
		for (int i=0; i<numBook; i++) {
			System.out.println("Enter the type of the book you wan to add (Encyclopedia, ArtBook, CourseBook, Dictionary) = ");
			type = scanner.nextLine();
			if (type.equalsIgnoreCase("Encyclopedia")) {
				addedBook = new Encyclopedia();
				((Encyclopedia)addedBook).getInput();
				((Encyclopedia)addedBook).read();
				((Encyclopedia)addedBook).findLocation(addedBook.bookName);
			}
			else if (type.equalsIgnoreCase("ArtBook")) {
				addedBook = new ArtBook();
				((ArtBook)addedBook).getInput();
				((ArtBook)addedBook).read();
				((ArtBook)addedBook).findLocation(addedBook.bookName);
			}
			else if (type.equalsIgnoreCase("CourseBook")) {
				addedBook = new CourseBook();
				((CourseBook)addedBook).getInput();
				((CourseBook)addedBook).read();
				((CourseBook)addedBook).findLocation(addedBook.bookName);
			}
			else {
				addedBook = new Dictionary();
				((Dictionary)addedBook).getInput();
				((Dictionary)addedBook).read();
				((Dictionary)addedBook).findLocation(addedBook.bookName);
			}
			
			if (searchBook(addedBook.bookName) == null)
				books.add(addedBook);
		}
	}
	
	public static void display() {
		for (Book bk: books) {
			if (bk instanceof Encyclopedia)
				System.out.println("\n"+((Encyclopedia)bk).toString());
			else if (bk instanceof ArtBook)
				System.out.println("\n"+((ArtBook)bk).toString());
			else if (bk instanceof CourseBook)
				System.out.println("\n"+((CourseBook)bk).toString());
			else
				System.out.println("\n"+((Dictionary)bk).toString());
		}
	}
}

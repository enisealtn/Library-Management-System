//Update UML: add the methods readBooksTxt, readBorrowersTxt; update the remove method from void to boolean
//Complete the CalculateFee method - how do we calculate?

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookSys {
	public static ArrayList<Book> books = new ArrayList<Book>();
	public static ArrayList<Borrower> borrowers = new ArrayList<Borrower>();
	//public static ArrayList<Book> keptBooks = new ArrayList<Book>(); // Updated variable declaration
	
	public static void readBooksTxt(String fileName) {
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
	
	public static void readBorrowersTxt(String fileName) {
	    File file = new File(fileName);
	    Scanner scan;
	    String borrowerName;
	    int borrowerId;
	    String[] borrowerAll;
	    Borrower borrower;
	    try {
	        scan = new Scanner(file);
	        while (scan.hasNext()) {
	            borrowerAll = scan.nextLine().split("\t");
	            borrowerId = Integer.parseInt(borrowerAll[0]);
	            borrowerName = borrowerAll[1];
	            
	            ArrayList<Book> keptBooks = new ArrayList<Book>(); // Create a new ArrayList for each borrower
	            
	            for (int i = 2; i < borrowerAll.length; i++) {
	                int bookId = Integer.parseInt(borrowerAll[i]);
	                Book book = searchBookById(bookId);
	                if (book != null) {
	                    keptBooks.add(book);
	                }
	            }
	            
	            borrower = new Borrower(borrowerId, borrowerName, keptBooks);
	            borrowers.add(borrower);
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println(e);
	    }
	}

	
	private static Book searchBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
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
		System.out.print("\nEnter the number of book you want to add = ");
		numBook = Integer.parseInt(scanner.nextLine());
		for (int i=0; i<numBook; i++) {
			System.out.print("Enter the type of the book you wan to add ('E' for Encyclopedia, 'A' for ArtBook, 'C' for CourseBook, 'D' for Dictionary) = ");
			type = scanner.nextLine();
			if (type.equalsIgnoreCase("E")) {
				addedBook = new Encyclopedia();
				((Encyclopedia)addedBook).getInput();
				((Encyclopedia)addedBook).read();
				((Encyclopedia)addedBook).findLocation(addedBook.bookName);
				((Encyclopedia)addedBook).setIsBorrowed("No");
			}
			else if (type.equalsIgnoreCase("A")) {
				addedBook = new ArtBook();
				((ArtBook)addedBook).getInput();
				((ArtBook)addedBook).read();
				((ArtBook)addedBook).findLocation(addedBook.bookName);
			}
			else if (type.equalsIgnoreCase("C")) {
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
	
	public static boolean remove (String bookName){
		boolean removed = false;
		for (int i = 0; i < books.size(); i++) {
		    if (books.get(i).getBookName().equalsIgnoreCase(bookName)) {
			books.remove(i);
			removed = true;
			break;
		    }
		}
		System.out.println("The book is removed from the available list!");
		return removed;
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
	
	public static void displayBorrowers() {
		for (Borrower borrower: borrowers) {
			System.out.println(borrower);
		}
	}
	
	public static double calculateFee(String bookName){
		Borrower bw=new Borrower();
		if(bw.isOverdue(searchBook(bookName))<5){
			return 0;
		} else if(bw.isOverdue(searchBook(bookName))<10){
			return bw.isOverdue(searchBook(bookName))*2.0;
		} else{
			return bw.isOverdue(searchBook(bookName))*3.0;
		}
	}
	
	public static void borrowOrReturn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to borrow or return a book? (Borrow/Return): ");
        String option = scanner.nextLine();
        if (option.equalsIgnoreCase("Borrow")) {
            System.out.print("Are you enrolled? (Yes/No): ");
            String enrolledOption = scanner.nextLine();
            if (enrolledOption.equalsIgnoreCase("Yes")) {
                // Borrower is enrolled
                System.out.print("Enter your borrower ID: ");
                int borrowerId = Integer.parseInt(scanner.nextLine());
                Borrower borrower = findBorrowerById(borrowerId);
                if (borrower != null) {
                    System.out.print("Enter the name of the book you want to borrow: ");
                    String bookName = scanner.nextLine();
                    Book book = searchBook(bookName);
                    if (book != null) {
                        if (book.getIsBorrowed().equalsIgnoreCase("no")) {
                            borrower.borrowBook(book);
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Sorry, the book is already borrowed.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                } else {
                    System.out.println("Borrower not found.");
                }
            } else {
                // Borrower is not enrolled
                enrollBorrower();
                System.out.print("Enter your borrower ID: ");
                int borrowerId = Integer.parseInt(scanner.nextLine());
                Borrower borrower = findBorrowerById(borrowerId);
                if (borrower != null) {
                    System.out.print("Enter the name of the book you want to borrow: ");
                    String bookName = scanner.nextLine();
                    Book book = searchBook(bookName);
                    if (book != null) {
                        if (book.getIsBorrowed().equalsIgnoreCase("no")) {
                            borrower.borrowBook(book);
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Sorry, the book is already borrowed.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                } else {
                    System.out.println("Borrower not found.");
                }
            }
        } else if (option.equalsIgnoreCase("Return")) {
            System.out.print("Enter your borrower ID: ");
            int borrowerId = Integer.parseInt(scanner.nextLine());
            Borrower borrower = findBorrowerById(borrowerId);
            if (borrower != null) {
                System.out.print("Enter the name of the book you want to return: ");
                String bookName = scanner.nextLine();
                boolean returned = borrower.returnBook(bookName);
                if (returned) {
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("You do not have the specified book borrowed.");
                }
            } else {
                System.out.println("Borrower not found.");
            }
        } else {
            System.out.println("Invalid option.");
        }
    }
	
	
	
	private static Borrower findBorrowerById(int borrowerId) {
        for (Borrower borrower : borrowers) {
            if (borrower.getBorrowerId() == borrowerId) {
                return borrower;
            }
        }
        return null;
    }

    private static void enrollBorrower() {
        Scanner scanner = new Scanner(System.in);
        int borrowerId = generateBorrowerId();
        System.out.print("Enter your name: ");
        String borrowerName = scanner.nextLine();
        Borrower borrower = new Borrower(borrowerId, borrowerName);
        borrowers.add(borrower);
        System.out.println("Borrower enrolled successfully.");
        System.out.println("Your id is:" + borrowerId);
    }
	
	private static int generateBorrowerId() {
        int maxId = 103;
        for (Borrower borrower : borrowers) {
            if (borrower.getBorrowerId() > maxId) {
                maxId = borrower.getBorrowerId();
            }
        }
        return maxId + 1;
    }
	

}




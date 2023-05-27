import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, bookName;
		/*Borrower br = new Borrower();
		CourseBook bk = new CourseBook();
		bk.dateBorrowed = "05/18/2023";
		
		int days = br.isOverdue(bk);*/
		BookSys.readBooksTxt("book_names.txt");
		System.out.println("ok");
		BookSys.readBorrowersTxt("borrowers.txt");
		System.out.println("ok2");
		
		BookSys.addBook();
		
		System.out.print("Do you want to remove a book: ");
		answer = scanner.nextLine();
		if(answer.equalsIgnoreCase("yes")) {
			System.out.print("Enter the name of the book: ");
			bookName = scanner.nextLine();
			BookSys.remove(bookName);
		}
		
		System.out.print("Do you want to search a book: ");
		answer = scanner.nextLine();
		if(answer.equalsIgnoreCase("yes")) {
			System.out.print("Enter the name of the book: ");
			bookName = scanner.nextLine();
			if(bookName != null) {
				System.out.println("Here is the information of the book you searched:");
				System.out.println(BookSys.searchBook(bookName));
			}
			
		}
		BookSys.borrowOrReturn();
		BookSys.display();
	}

}

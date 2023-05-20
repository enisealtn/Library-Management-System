
public class BookMain {

	public static void main(String[] args) {
		/*Borrower br = new Borrower();
		CourseBook bk = new CourseBook();
		bk.dateBorrowed = "05/18/2023";
		
		int days = br.isOverdue(bk);*/
		BookSys booksys = new BookSys();
		booksys.readBooksTxt("book_names.txt");
		System.out.println("ok");
		booksys.readBorrowersTxt("borrowers.txt");
		System.out.println("ok2");
		//booksys.addBook();
		booksys.display();
	}

}

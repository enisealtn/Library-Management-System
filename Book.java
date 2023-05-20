import java.util.Scanner;

public abstract class Book implements Readable{
	protected int bookId;
	protected String bookName;
	protected String author;
	//protected String library; //What is the purpose of this variable?
	protected String location;
	protected String format;
	protected String isBorrowed;
	protected String dateBorrowed; //"mm/dd/yyyy"
	public Book() {
		
	}
	
	public Book(int bookId, String bookName, String author, String location, String format, String isBorrowed, String dateBorrowed) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.location = location;
		this.format = format;
		this.isBorrowed = isBorrowed;
		this.dateBorrowed = dateBorrowed;
	}
	
	//Getters and setters can be adjusted for the purpose
	
	public String getLocation() {
		return location;}
	
	public String getFormat() {
		return format;}

	public void setLocation(String location) {
		this.location = location;}
	
	public void setFormat(String format) {
		this.format = format;}
	
	public void getInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the book ID = ");
		bookId = Integer.parseInt(scan.nextLine());
		System.out.println("Enter the book name = ");
		bookName = scan.nextLine();
		System.out.println("Enter the author of the book = ");
		author = scan.nextLine();
		//System.out.println("Enter the library name = ");
		//library = scan.nextLine();
	}

	public abstract void findLocation(String bookName);
	
	public String toString() {
		return "\nBook Id = " + bookId +
				"\nBook Name = " + bookName +
				"\nAuthor of the Book = " + author +
				//"\nLibrary Name = " + library + 
				"\nLocation of the book in the library = " + location + 
				"\nFormat of the book = " + format + 
				"\nBorrewed = " + isBorrowed +
				"\nDate of borrowed = " + dateBorrowed;}
}

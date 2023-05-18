import java.util.Scanner;

public abstract class Book implements Readable{
	protected int bookId;
	protected String bookName;
	protected String author;
	protected String library; //What is the purpose of this variable?
	protected String location;
	protected String format;
	public Book() {
		
	}
	
	/*public Book(int bookId, String bookName, String author, String library, String location, String format) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.library = library;
		this.location = location;
		this.format = format;
	}*/
	
	//Getters and setters can be adjusted for the purpose
	public int getBookId() {
		return bookId;}

	public String getBookName() {
		return bookName;}

	public String getAuthor() {
		return author;}

	public String getLibrary() {
		return library;}

	public String getLocation() {
		return location;}
	
	public String getFormat() {
		return format;}

	public void setBookId(int bookId) {
		this.bookId = bookId;}

	public void setBookName(String bookName) {
		this.bookName = bookName;}

	public void setAuthor(String author) {
		this.author = author;}

	public void setLibrary(String library) {
		this.library = library;}

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
		System.out.println("Enter the library name = ");
		library = scan.nextLine();
	}

	public abstract void findLocation(String bookName);
	
	public String toString() {
		return "\nBook Id = " + bookId +
				"\nBook Name = " + bookName +
				"\nAuthor of the Book = " + author +
				"\nLibrary Name = " + library + 
				"\nLocation of the book in the library = " + location + 
				"\nFormat of the book = " + format;}
}

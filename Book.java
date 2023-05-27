import java.util.Scanner;

public abstract class Book implements Readable {
    protected int bookId;
    protected String bookName;
    protected String author;
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

    // Getters and setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(String isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public String getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(String dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public void getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the book ID = ");
        bookId = Integer.parseInt(scan.nextLine());
        System.out.print("Enter the book name = ");
        bookName = scan.nextLine();
        System.out.print("Enter the author of the book = ");
        author = scan.nextLine();
    }

    public abstract void findLocation(String bookName);

    public String toString() {
        return "\nBook Id = " + bookId +
                "\nBook Name = " + bookName +
                "\nAuthor of the Book = " + author +
                "\nLocation of the book in the library = " + location +
                "\nFormat of the book = " + format +
                "\nBorrowed = " + isBorrowed +
                "\nDate of borrowed = " + dateBorrowed;
    }
}

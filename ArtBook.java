import java.util.Scanner;

public class ArtBook extends Book {
    private String genre;
    private String award;

    public ArtBook() {

    }

    public ArtBook(int bookId, String bookName, String author, String location, String format, String isBorrowed, String dateBorrowed, String genre, String award) {
        super(bookId, bookName, author, location, format, isBorrowed, dateBorrowed);
        this.genre = genre;
        this.award = award;
    }

    @Override
    public void getInput() {
        Scanner scan = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter the genre of the book: ");
        genre = scan.nextLine();
        System.out.print("Does this book have any awards (true/false)? ");
        award = scan.nextLine();
        System.out.print("Enter the format of the encyclopedia: ");
        format = scan.nextLine();
    }

    @Override
    public void read() {
        if (format.equalsIgnoreCase("printed")) {
        	super.setFormat("Readable");
        } else if (format.equalsIgnoreCase("mp3")) {
        	super.setFormat("Not Readable");
        } else {
        	super.setFormat("Invalid Format");
        }
    }

    @Override
    public void findLocation(String bookName) {
        super.setLocation("ART-" + bookName.toUpperCase().replace(" ", ""));
    }

    @Override
    public String toString() {
        String readableStatus = super.getFormat().equals("Readable") ? "Readable" : "Not Readable";
        return super.toString() +
                "\nGenre of the book: " + genre +
                "\nAward situation: " + award +
                "\nReadability: " + readableStatus;
    }
}

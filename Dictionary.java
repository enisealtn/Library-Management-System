import java.util.Scanner;

public class Dictionary extends Book {
    private String language;
    private String level;

    public Dictionary() {

    }

    public Dictionary(int bookId, String bookName, String author, String location, String format, String isBorrowed, String dateBorrowed, String language, String level) {
        super(bookId, bookName, author, location, format, isBorrowed, dateBorrowed);
        this.language = language;
        this.level = level;
    }

    public void getInput() {
        Scanner scan = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter the language: ");
        language = scan.nextLine();
        System.out.print("Enter the level of dictionary: ");
        level = scan.nextLine();
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
        super.setLocation("DIC-" + bookName.toUpperCase().replace(" ", ""));
    }

    @Override
    public String toString() {
        String readableStatus = super.getFormat().equals("Readable") ? "Readable" : "Not Readable";
        return super.toString() +
                "\nLanguage of the dictionary: " + language +
                "\nLevel of the dictionary: " + level +
                "\nReadability: " + readableStatus;
    }
}

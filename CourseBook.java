import java.util.Scanner;

public class CourseBook extends Book {
    private String courseName;
    private int edition;

    public CourseBook() {

    }

    public CourseBook(int bookId, String bookName, String author, String location, String format, String isBorrowed, String dateBorrowed, String courseName, int edition) {
        super(bookId, bookName, author, location, format, isBorrowed, dateBorrowed);
        this.courseName = courseName;
        this.edition = edition;
    }

    public void getInput() {
        Scanner scan = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter the course name: ");
        courseName = scan.nextLine();
        System.out.print("Enter the edition of the book: ");
        edition = Integer.parseInt(scan.nextLine());
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
        super.setLocation("CRS-" + bookName.toUpperCase().replace(" ", ""));
    }

    @Override
    public String toString() {
        String readableStatus = super.getFormat().equals("Readable") ? "Readable" : "Not Readable";
        return super.toString() +
                "\nCourse Name: " + courseName +
                "\nEdition of the book: " + edition +
                "\nReadability: " + readableStatus;
    }
}

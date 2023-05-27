import java.util.Scanner;

public class Encyclopedia extends Book {
    private String subject;
    private int volume;

    public Encyclopedia() {

    }

    public Encyclopedia(int bookId, String bookName, String author, String location, String format, String isBorrowed, String dateBorrowed, String subject, int volume) {
        super(bookId, bookName, author, location, format, isBorrowed, dateBorrowed);
        this.subject = subject;
        this.volume = volume;
    }

    public void getInput() {
        Scanner scan = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter the subject of the encyclopedia: ");
        subject = scan.nextLine();
        System.out.print("Enter the volume of the encyclopedia: ");
        volume = Integer.parseInt(scan.nextLine());
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
        super.setLocation("ENC-" + bookName.toUpperCase().replace(" ", ""));
    }

    @Override
    public String toString() {
        String readableStatus = super.getFormat().equals("Readable") ? "Readable" : "Not Readable";
        return super.toString() +
                "\nSubject of the Encyclopedia: " + subject +
                "\nVolume of the Encyclopedia: " + volume +
                "\nReadability: " + readableStatus;
    }
}

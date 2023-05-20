import java.util.Scanner;

public class Encyclopedia extends Book{
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
		System.out.println("Enter the subject of enclopedia = ");
		subject = scan.nextLine();
		System.out.println("Enter the volume of enclopedia = ");
		volume = Integer.parseInt(scan.nextLine());
	}
	
	@Override
	public void read() {
		super.setFormat("Readable");
	}

	@Override
	public void findLocation(String bookName) {
		super.setLocation("ENC-"+ bookName.toUpperCase().replace(" ", ""));
	}
	
	public String toString() {
		return super.toString() + 
				"\nSubject of the Enclopedia = " + subject +
				"\nVolume of the Enclopedia = "+ volume;
	}
}

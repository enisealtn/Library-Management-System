import java.util.Scanner;

public class Enclopedia extends Book{
	private String subject;
	private int volume;
	
	public Enclopedia() {
		
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
		super.setLocation("ENC-"+ bookName.toUpperCase().split("\\s"));
	}
	
	public String toString() {
		return super.toString() + 
				"\nSubject of the Enclopedia = " + subject +
				"\nVolume of the Enclopedia = "+ volume;
	}
}

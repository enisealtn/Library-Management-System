import java.util.Scanner;

public class Dictionary extends Book{
	private String language;
	private int level;
	
	public Dictionary() {
		
	}

	public void getInput() {
		Scanner scan = new Scanner(System.in);
		super.getInput();
		System.out.println("Enter the language = ");
		language = scan.nextLine();
		System.out.println("Enter the level of dictionary = ");
		level = Integer.parseInt(scan.nextLine());
	}
	
	@Override
	public void read() {
		super.setFormat("Not Readable");
	}

	@Override
	public void findLocation(String bookName) {
		super.setLocation("DIC-"+ bookName.toUpperCase().split("\\s"));		
	}
	
	public String toString() {
		return super.toString() + 
				"\nLanguage of the dictionary = " + language +
				"\nLevel of the dictionary = "+ level;
	}
}

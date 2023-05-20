import java.util.Scanner;

public class Dictionary extends Book{
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
		System.out.println("Enter the language = ");
		language = scan.nextLine();
		System.out.println("Enter the level of dictionary = ");
		level = scan.nextLine();
	}
	
	@Override
	public void read() {
		super.setFormat("Not Readable");
	}

	@Override
	public void findLocation(String bookName) {
		super.setLocation("DIC-"+ bookName.toUpperCase().replace(" ", ""));	
	}
	
	public String toString() {
		return super.toString() + 
				"\nLanguage of the dictionary = " + language +
				"\nLevel of the dictionary = "+ level;
	}
}

import java.util.Scanner;

public class ArtBook extends Book{
	private String genre;
	private boolean award;
	
	public ArtBook() {
		
	}
	
	public void getInput() {
		Scanner scan = new Scanner(System.in);
		super.getInput();
		System.out.println("Enter the genre of the book = ");
		genre = scan.nextLine();
		System.out.println("Has this book any award (true/false)?");
		award = scan.nextBoolean();
	}
	
	@Override
	public void read() {
		super.setFormat("Not Readable");
		
	}
	@Override
	public void findLocation(String bookName) {
		super.setLocation("ART-"+ bookName.toUpperCase().split("\\s"));		
	}
	
	public String toString() {
		String str;
		str = super.toString() + 
				"\nGenre of the book = " + genre + 
				"\nAward situation = ";
		if (award)
			str += "yes";
		else
			str += "no";
		return str;
	}
}

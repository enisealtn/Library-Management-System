import java.util.Scanner;

public class ArtBook extends Book{
	private String genre;
	private String award;
	
	public ArtBook() {
		
	}
	
	public ArtBook(int bookId, String bookName, String author, String location, String format, String isBorrowed, String dateBorrowed, String genre, String award) {
		super(bookId, bookName, author, location, format, isBorrowed, dateBorrowed);
		this.genre = genre;
		this.award = award;
	}
	
	public void getInput() {
		Scanner scan = new Scanner(System.in);
		super.getInput();
		System.out.println("Enter the genre of the book = ");
		genre = scan.nextLine();
		System.out.println("Has this book any award (true/false)?");
		award = scan.nextLine();
	}
	
	@Override
	public void read() {
		super.setFormat("Not Readable");
	}
	
	@Override
	public void findLocation(String bookName) {
		super.setLocation("ART-"+ bookName.toUpperCase().replace(" ", ""));		
	}
	
	public String toString() {
		String str;
		str = super.toString() + 
				"\nGenre of the book = " + genre + 
				"\nAward situation = " + award;
		/*if (award)
			str += "yes";
		else
			str += "no";*/
		return str;
	}
}

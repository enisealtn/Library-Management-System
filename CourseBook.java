import java.util.Scanner;

public class CourseBook extends Book{
	private String courseName;
	private int edition;
	
	public CourseBook() {
		
	}

	public void getInput() {
		Scanner scan = new Scanner(System.in);
		super.getInput();
		System.out.println("Enter the course name = ");
		courseName = scan.nextLine();
		System.out.println("Enter the edition of the book = ");
		edition = Integer.parseInt(scan.nextLine());
	}
	
	@Override
	public void read() {
		super.setFormat("Readable");
	}

	@Override
	public void findLocation(String bookName) {
		super.setLocation("CRS-"+ bookName.toUpperCase().split("\\s"));		
	}
	
	public String toString() {
		return super.toString() + 
				"\nCourse Name = " + courseName +
				"\nEdition of the book = "+ edition;
	}
	
}

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Borrower {
	private int borrowerId;
	private String borrowerType;
	private ArrayList<Book> keptBook = new ArrayList<Book>();
	
	
	public int isOverdue(Book bk) {
		int daysDifference = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			LocalDate now = LocalDate.now();
			Date dateBefore = sdf.parse(bk.dateBorrowed);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        String date = now.format(formatter);
			Date dateAfter = sdf.parse(date);
		    long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
		    long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
		    daysDifference = (int)daysDiff;
		    System.out.println("The number of days between dates: " + daysDiff);
		}catch(Exception e){
			e.printStackTrace();
		}
		return daysDifference;
	}
	
	public String display() {
		String str =  "\nBorrower Id = " + borrowerId + 
				"\nBorrower Type = " + borrowerType + "\nBorrowed Books = ";
		for (Book bk: keptBook) {
			str += "\n" + bk.toString();
		}
		return str;
	}
}

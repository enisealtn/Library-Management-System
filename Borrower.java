import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Borrower {
    private int borrowerId;
    private String borrowerName;
    private ArrayList<Book> keptBook;

    public Borrower() {
    }

    public Borrower(int borrowerId, String borrowerName) {
        this.borrowerId = borrowerId;
        this.borrowerName = borrowerName;
        this.keptBook = new ArrayList<>();
    }
    
    public Borrower(int borrowerId, String borrowerName, ArrayList<Book> keptBooks) {
        this.borrowerId = borrowerId;
        this.borrowerName = borrowerName;
        this.keptBook = keptBook;
    }
    
    public boolean returnBook(String bookName) {
        for (int i = 0; i < keptBook.size(); i++) {
            if (keptBook.get(i).getBookName().equalsIgnoreCase(bookName)) {
            	keptBook.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public ArrayList<Book> getKeptBook() {
        return keptBook;
    }

    public void borrowBook(Book book) {
        keptBook.add(book);
        book.setIsBorrowed("Yes");
        //book.setDateBorrowed("mm/dd/yyyy");
        System.out.println("Book with ID " + book.getBookId() + " has been borrowed by " + borrowerName);
    }

    public void returnBook(Book book) {
        keptBook.remove(book);
        book.setIsBorrowed("No");
        book.setDateBorrowed("");
        System.out.println("Book with ID " + book.getBookId() + " has been returned by " + borrowerName);
    }

    public int isOverdue(Book book) {
        int daysDifference = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            LocalDate now = LocalDate.now();
            Date dateBefore = sdf.parse(book.getDateBorrowed());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String date = now.format(formatter);
            Date dateAfter = sdf.parse(date);
            long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
            long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
            daysDifference = (int) daysDiff;
            System.out.println("The number of days between dates: " + daysDiff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daysDifference;
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("Borrower ID: ").append(borrowerId).append("\n");
        sb.append("Borrower Name: ").append(borrowerName).append("\n");
        sb.append("Kept Books: \n");
        for (Book book : keptBook) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }
}

import java.util.ArrayList;
import java.util.List;

public class RepositoryBookForLoan {

    public List<BookForLoan> getAllBookForLoan() {
        List<BookForLoan> bookList = new ArrayList<>();
        
        bookList.add(new Comic("Comic-001", "Uzumaki Naruto", "Masashi Kishimoto", 55000, 10, "Shounen"));
        bookList.add(new Comic("Comic-002", "The Worst Client", "Masashi Kishimoto", 35000, 20, "Shounen"));
        bookList.add(new Comic("Comic-003", "For the Sake of Dreams...!!", "Masashi Kishimoto", 35000, 15, "Shounen"));
        bookList.add(new Comic("Comic-004", "Hunter X Hunter: The Day of Departure", "Yoshihiro Togashi", 50000, 15, "Fantasy"));
        bookList.add(new Comic("Comic-005", "Hunter X Hunter: A Struggle in the Mist", "Yoshihiro Togashi", 80000, 25, "Fantasy"));
        
        bookList.add(new Novel("Novel-001", "Harry Potter and the Philosopher's Stone", "J.K. Rowling", 150000, 10, true));
        bookList.add(new Novel("Novel-002", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 150000, 10, true));
        bookList.add(new Novel("Novel-003", "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 200000, 15, true));
        bookList.add(new Novel("Novel-004", "Ayah Aku Berbeda", "Tere Liye", 35000, 15, false));
        bookList.add(new Novel("Novel-005", "Madre", "Dee Lestari", 80000, 10, false));

        return bookList;
    }

    public void displayBookList(List<BookForLoan> books) {
    	System.out.println(" ---------------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-40s | %-20s | %-10s |\n", "Book ID", "Title", "Author", "Stock");
        System.out.println("|--------------|------------------------------------------|----------------------|------------|");

        for (BookForLoan book : books) {
            System.out.printf("| %-12s | %-40s | %-20s | %-10d |\n",
                    book.getBookID(), book.getTitle(), book.getAuthor(), book.getStock());
        }

        System.out.println("|--------------|------------------------------------------|----------------------|------------|");
    }


    public void listAllBooks() {
        List<BookForLoan> allBooks = getAllBookForLoan();
        displayBookList(allBooks);
    }

    public BookForLoan getTitles(String bookID) {
        for (BookForLoan book : getAllBookForLoan()) {
            if (book.getBookID().equals(bookID)) {
                return book;
            }
        }
        return null;
    }

}
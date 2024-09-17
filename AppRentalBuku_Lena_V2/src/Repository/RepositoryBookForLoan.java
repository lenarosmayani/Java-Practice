package Repository;

import java.util.ArrayList;
import java.util.List;

import Entity.BookForLoan;
import Entity.Comic;
import Entity.Novel;

public class RepositoryBookForLoan {
	private static RepositoryBookForLoan instance;
    private List<BookForLoan> allBooks;

    public RepositoryBookForLoan() {
        allBooks = getAllBookForLoan();
    }

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

    public List<BookForLoan> getAllBooks() {
        return new ArrayList<>(allBooks);
    }

    public BookForLoan getBookByID(String bookID) {
        String cleanedBookID = bookID.replaceAll("\\s", "");

        for (BookForLoan book : allBooks) {
            if (book.getBookID().equalsIgnoreCase(cleanedBookID)) {
                return book;
            }
        }
        return null;
    }
    
    public static RepositoryBookForLoan getInstance() {
        if (instance == null) {
            instance = new RepositoryBookForLoan();
        }
        return instance;
    }

    public void updateStock(String bookID, int newStock) {
        BookForLoan bookToUpdate = getBookByID(bookID);

        if (bookToUpdate != null) {
            bookToUpdate.setStock(newStock);
        }
    }
}

package Main;

import Entity.BookForLoan;
import Entity.LoanBookOrder;
import Entity.Member;
import Repository.DisplayRepository;
import Repository.RepositoryBookForLoan;
import Repository.RepositoryLoanOrder;
import Repository.RepositoryMember;

import java.util.List;

public class LibraryManager {
    private final RepositoryMember repositoryMember;
    private final RepositoryBookForLoan repositoryBookForLoan;
    private final RepositoryLoanOrder repositoryLoanOrder;
    private final DisplayRepository displayRepository;
    private final ConsoleUser consoleUI;

    public LibraryManager(ConsoleUser consoleUI) {
        this.repositoryMember = new RepositoryMember();
        this.repositoryBookForLoan = RepositoryBookForLoan.getInstance();
        this.repositoryLoanOrder = new RepositoryLoanOrder();
        this.displayRepository = new DisplayRepository();
        this.consoleUI = consoleUI;
    }

    public void start() {
        List<BookForLoan> booksForLoan = repositoryBookForLoan.getAllBookForLoan();
        int userChoice;

        do {
            consoleUI.displayMenu();
            userChoice = consoleUI.getUserChoice();
            System.out.println();

            switch (userChoice) {
                case 1:
                    listAllBooks(booksForLoan);
                    break;
                case 2:
                    loanBook(booksForLoan);
                    break;
                case 3:
                    returnBook(booksForLoan);
                    break;
                case 4:
                    listLoanOrders();
                    break;
                case 5:
                    consoleUI.showMessage("Keluar dari aplikasi. Selamat tinggal!");
                    break;
                default:
                    consoleUI.showMessage("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (userChoice != 5);
    }

    private void listAllBooks(List<BookForLoan> booksForLoan) {
        displayRepository.displayBookList(booksForLoan);
    }

    private void loanBook(List<BookForLoan> booksForLoan) {
        consoleUI.showMessage("Silahkan isi Data Peminjaman Buku.");
        System.out.println();

        Member selectedMember = repositoryMember.getSelectedMember(consoleUI);

        if (selectedMember == null) {
            consoleUI.showMessage("Peminjaman dibatalkan.");
            return;
        }

        displayRepository.displayBookList(booksForLoan);

        BookForLoan selectedBook = getSelectedBook();

        if (selectedBook == null || selectedBook.getStock() == 0) {
            consoleUI.showMessage("Buku tidak tersedia untuk dipinjam. Peminjaman dibatalkan.");
            return;
        }

        int loanDuration = consoleUI.promptLoanDuration();

        LoanBookOrder loanOrder = new LoanBookOrder(selectedMember, selectedBook, loanDuration);
        repositoryLoanOrder.addLoanOrder(loanOrder);

        selectedBook.decreaseStock();
        repositoryBookForLoan.updateStock(selectedBook.getBookID(), selectedBook.getStock());

        consoleUI.showMessage("Peminjaman berhasil!");
        consoleUI.showMessage(String.format("Biaya sewa buku Anda adalah %.1f", loanOrder.getLoanFee()));

        updateBookForLoanList(booksForLoan, selectedBook);
    }

    private void returnBook(List<BookForLoan> booksForLoan) {
        consoleUI.showMessage("Silahkan isi Data Pengembalian Buku.");
        System.out.println();

        displayRepository.displayLoanOrders(repositoryLoanOrder.getAllLoanOrders());

        String loanID = consoleUI.promptReturnBookID();
        LoanBookOrder returnedBookOrder = repositoryLoanOrder.findLoanOrder(loanID);

        if (returnedBookOrder != null) {
            BookForLoan returnedBook = returnedBookOrder.getLoanBook();
            returnedBook.increaseStock();

            repositoryLoanOrder.removeLoanOrder(returnedBookOrder);
            repositoryBookForLoan.updateStock(returnedBook.getBookID(), returnedBook.getStock());

            consoleUI.showMessage("Pengembalian berhasil!");

            updateBookForLoanList(booksForLoan, returnedBook);
        } else {
            consoleUI.showMessage("Loan ID tidak valid. Pengembalian dibatalkan.");
        }
    }

    private void updateBookForLoanList(List<BookForLoan> booksForLoan, BookForLoan updatedBook) {
        String updatedBookID = updatedBook.getBookID();
        for (int i = 0; i < booksForLoan.size(); i++) {
            BookForLoan book = booksForLoan.get(i);
            if (book.getBookID().equals(updatedBookID)) {
                booksForLoan.set(i, updatedBook);
                return;
            }
        }
        consoleUI.showMessage("Error: Book not found in the list.");
    }

    
    private BookForLoan getSelectedBook() {
        String bookID = consoleUI.promptBookID();
        return repositoryBookForLoan.getBookByID(bookID);
    }

    
    private void listLoanOrders() {
        consoleUI.showMessage("Daftar Pesanan Peminjaman:");
        displayRepository.displayLoanOrders(repositoryLoanOrder.getAllLoanOrders());
    }
}

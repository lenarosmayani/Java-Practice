
import Entity.BookForLoan;
import Entity.Comic;
import Entity.Novel;

import java.util.Scanner;

public class RentalMainApp {
	private static RepositoryMember repositoryMember = new RepositoryMember();
	private static RepositoryBookForLoan repositoryBookForLoan = new RepositoryBookForLoan();
	private static RepositoryLoanOrder repositoryLoanOrder = new RepositoryLoanOrder();
	private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	
        mainMenu();
    }

    public static void mainMenu() {
        int pilihAngka;
        do {
            displayMenu();
            System.out.print("Masukkan pilihan Anda: ");
            pilihAngka = Integer.valueOf(scanner.nextLine());
            System.out.println();

            switch (pilihAngka) {
                case 1:
                    listAllBooks();
                    break;
                case 2:
                    loanBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    listLoanOrders();
                    break;
                case 5:
                    System.out.println("Keluar dari aplikasi. Selamat tinggal!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihAngka != 5);
		
	}


	private static void displayMenu() {
		System.out.println();
        System.out.println("=================================| Main Menu |==================================");
        System.out.println("1. Daftar Semua Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Kembalikan Buku");
        System.out.println("4. Daftar Pesanan Pinjaman");
        System.out.println("5. Keluar");
        System.out.println("================================================================================");
    }

    private static void listAllBooks() {
        repositoryBookForLoan.displayBookList(repositoryBookForLoan.getAllBookForLoan());
    }
    
    private static void loanBook() {
        System.out.println("Silahkan isi Data Peminjaman Buku.");
        System.out.println();

        Member selectedMember;

        do {
            repositoryMember.displayMemberList(repositoryMember.getAllMember());

            System.out.print("Masukkan ID Member: ");
            String memberID = scanner.nextLine();
            scanner.nextLine();

            selectedMember = repositoryMember.getMemberNameByID(memberID);

            if (selectedMember == null) {
                System.out.print("Member not found. Apakah Anda ingin menambahkan data member baru? (y/n): ");
                String addNewMemberChoice = scanner.nextLine().toLowerCase();

                if (addNewMemberChoice.equals("y")) {
                    repositoryMember.addNewMember();
                } else {
                    System.out.println("Peminjaman dibatalkan.");
                    return;
                }
            } else {
                String memberName = selectedMember.getMemberName();
                System.out.println("Selected Member: " + memberName);
            }
        } while (selectedMember == null);



        repositoryBookForLoan.displayBookList(repositoryBookForLoan.getAllBookForLoan());

    
        System.out.print("Masukkan ID Buku yang ingin dipinjam: ");
        String bookID = scanner.nextLine();

        BookForLoan selectedBook = repositoryBookForLoan.getTitles(bookID);
        if (selectedBook == null || selectedBook.getStock() == 0) {
            System.out.println("Buku dengan ID " + bookID + " tidak tersedia untuk dipinjam.");
            System.out.println("Peminjaman dibatalkan.");
            return;
        }

        System.out.print("Masukkan durasi peminjaman (dalam hari): ");
        int loanDuration = Integer.valueOf(scanner.nextLine());

        LoanBookOrder loanOrder = new LoanBookOrder(selectedMember, selectedBook, loanDuration);
        repositoryLoanOrder.addLoanOrder(loanOrder);

        selectedBook.decreaseStock();

        System.out.println("Peminjaman berhasil!");
    }

    	private static void returnBook() {
        System.out.println("Silahkan isi Data Pengembalian Buku.");
        System.out.println();

        repositoryLoanOrder.displayLoanOrders();

        System.out.print("Masukkan Loan ID untuk pengembalian: ");
        String loanID = scanner.nextLine();

        LoanBookOrder returnedBookOrder = repositoryLoanOrder.findLoanOrder(loanID);

        if (returnedBookOrder == null) {
            System.out.println("Loan ID tidak valid. Pengembalian dibatalkan.");
            return;
        }

        returnedBookOrder.getLoanBook().increaseStock();

        // Remove the returned book order from the list
        repositoryLoanOrder.removeLoanOrder(returnedBookOrder);

        System.out.println("Pengembalian berhasil!");
    }

    private static void listLoanOrders() {
        System.out.println("Daftar Semua Pesanan Peminjaman Buku:");
        repositoryLoanOrder.displayLoanOrders();
    }
}



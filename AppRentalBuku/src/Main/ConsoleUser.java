package Main;

import java.util.Scanner;
import ValidasiInput.AlphaNumericInputValidator;
import ValidasiInput.InputValidator;
import ValidasiInput.NumericInputValidator;

public class ConsoleUser {
    private final Scanner scanner;
    private final AlphaNumericInputValidator alphaNumericInputValidator;
    private final NumericInputValidator numericInputValidator;

    public ConsoleUser() {
        this.scanner = new Scanner(System.in);
        this.alphaNumericInputValidator = new AlphaNumericInputValidator();
        this.numericInputValidator = new NumericInputValidator();
    }
    
    public void displayMenu() {
        System.out.println();
        System.out.println("=================================| Main Menu |==================================");
        System.out.println("1. Daftar Semua Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Kembalikan Buku");
        System.out.println("4. Daftar Pesanan Pinjaman");
        System.out.println("5. Keluar");
        System.out.println("================================================================================");
    }

    public int getUserChoice() {
        while (true) {
            String userInput = getUserInput("Masukkan pilihan Anda: ");

            if (numericInputValidator.validateInput(userInput)) {
                int choice = Integer.parseInt(userInput);
                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    showMessage("Pilihan tidak valid. Silakan coba lagi.");
                }
            } else {
                showMessage("Input yang anda masukkan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    public String getUserInput(String prompt, InputValidator inputValidator) {
        while (true) {
            String userInput = getUserInput(prompt);

            if (inputValidator.validateInput(userInput)) {
                return userInput;
            } else {
                showMessage("Input yang anda masukkan tidak valid. Silakan coba lagi.");
            }
        }
    }


    public void showMessage(String message) {
        System.out.println(message);
    }

    public String promptMemberID() {
        while (true) {
            String input = getUserInput("Masukkan ID Member (isi 0 jika tidak ada): ");
            if (alphaNumericInputValidator.validateInput(input)) {
                return input;
            } else {
                showMessage("Input yang anda masukkan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public boolean promptAddNewMember() {
        String choice = getUserInput("Member not found. Apakah Anda ingin menambahkan data member baru? (y/n): ").toLowerCase();
        return choice.equals("y");
    }

    public String promptBookID() {
        while (true) {
            String input = getUserInput("Masukkan ID Buku yang ingin dipinjam: ");
            if (alphaNumericInputValidator.validateInput(input)) {
                return input;
            } else {
                showMessage("Input yang anda masukkan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public int promptLoanDuration() {
        while (true) {
            String input = getUserInput("Masukkan durasi peminjaman (dalam hari): ");
            if (numericInputValidator.validateInput(input)) {
                return Integer.parseInt(input);
            } else {
                showMessage("Input yang anda masukkan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public String promptReturnBookID() {
        while (true) {
            String input = getUserInput("Masukkan Loan ID untuk pengembalian: ");
            if (alphaNumericInputValidator.validateInput(input)) {
                return input;
            } else {
                showMessage("Input yang anda masukkan tidak valid. Silakan coba lagi.");
            }
        }
    }
}

package main;

import java.util.Scanner;
import ValidasiInput.AlphaNumericInputValidator;
import ValidasiInput.InputValidator;
import ValidasiInput.NumericInputValidator;
import displaysetting.DisplayOut;

	public class ConsoleUser {
		
	    private final Scanner scanner;
	    private final AlphaNumericInputValidator alphaNumericInputValidator;
	    private final NumericInputValidator numericInputValidator;

	    public ConsoleUser() {
	        this.scanner = new Scanner(System.in);
	        this.alphaNumericInputValidator = new AlphaNumericInputValidator();
	        this.numericInputValidator = new NumericInputValidator();
	    }

	    public int getUserChoice() {
	        while (true) {
	            String userInput = getUserInput("Masukkan pilihan Anda: ");
	            System.out.println();
	            
	            if (numericInputValidator.validateInput(userInput)) {
	                int choice = Integer.parseInt(userInput);
	                if (choice >= 0 && choice <= 6) {
	                    return choice;
	                } else {
	                    showMessage("Masukkan tidak valid. Silakan coba lagi.");
	                }
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

    public String promptEmployeeID() {
        while (true) {
            String input = getUserInput("Masukkan EmployeeID : ");
            if (alphaNumericInputValidator.validateInput(input)) {
                return input;
            } else {
                showMessage("Input yang anda masukkan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public int promptAge() {
        while (true) {
            String input = getUserInput("Masukkan Umur : ");
            if (numericInputValidator.validateInput(input)) {
                return Integer.parseInt(input);
            } else {
                showMessage("Input yang anda masukkan tidak valid. Silakan coba lagi.");
            }
        }
    }

	public void promptBack() {
		int choice = getUserChoice();

        switch (choice) {
            case 0:
                DisplayOut.displayMenu();
                break;
            default:
                System.out.println("Inputan tidak valid. Silakan coba lagi.");
                break;
        }
		
	}
}
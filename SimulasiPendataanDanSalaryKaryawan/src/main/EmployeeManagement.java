package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ValidasiInput.InputValidator;
import calculation.SalaryAllowanceCalculator;
import displaysetting.DisplayOut;
import entity.Employee;
import interfacepackage.IPosition;
import repository.RepositoryKaryawan;

public class EmployeeManagement implements IPosition{

    private final RepositoryKaryawan repositoryKaryawan;
    private final DisplayOut displayOut;
    private final ConsoleUser consoleUser;
    private final SalaryAllowanceCalculator calculator;

    public EmployeeManagement(ConsoleUser consoleUser, Employee employee) {
        this.calculator = new SalaryAllowanceCalculator(employee);
        this.repositoryKaryawan = new RepositoryKaryawan();
        this.displayOut = new DisplayOut(calculator);
        this.consoleUser = consoleUser;
    }

    public void start() {
        List<Employee> employeesList = repositoryKaryawan.getAllKaryawan();
        int choice;

        DisplayOut.displayMenu();

        do {
            choice = consoleUser.getUserChoice();
            switch (choice) {
                case 1:
                    addEmployee(consoleUser, employeesList);
                    break;
                case 2:
                    editEmployee(employeesList);
                    break;
                case 3:
                    displayEmployeeData(employeesList);
                    break;
                case 4:
                    displayPayrollData(employeesList);
                    break;
                case 5:
                    deleteEmployee(employeesList);
                    break;
                case 6:
                    searchEmployee(employeesList);
                    break;
                case 0:
                    System.out.println("Terima kasih, sampai jumpa!");
                    break;
                default:
                    System.out.println("Inputan tidak valid. Silakan pilih lagi.");
                    break;
            }
        } while (choice != 0);
    }

    private void addEmployee(ConsoleUser consoleUser, List<Employee> employeesList) {
        String newEmployeeName = consoleUser.getUserInput("Masukkan Nama : ", InputValidator.getStringValidator());
        String newEmployeeAddress = consoleUser.getUserInput("Masukkan Alamat : ", InputValidator.getStringValidator());
        int newEmployeeAge = consoleUser.promptAge();
        String newJobDesc = consoleUser.getUserInput("Masukkan Job Desc : ", InputValidator.getStringValidator());
        String newPlacement = consoleUser.getUserInput("Masukkan Kota Penempatan : ", InputValidator.getStringValidator());

        String newEmployeeID = generateUniqueEmployeeID(newJobDesc, employeesList);

        Employee newEmployee = new Employee(newEmployeeID, newEmployeeName, newEmployeeAddress,
                newEmployeeAge, newJobDesc, newPlacement);

        employeesList.add(newEmployee);
        consoleUser.showMessage(newEmployeeName + " berhasil ditambahkan dengan EmployeeID: " + newEmployeeID);
    }

	    private String generateUniqueEmployeeID(String newJobDesc, List<Employee> employeesList) {
	        int positionIndex = indexByJobTitle(newJobDesc);
	        int employeeCounter = 0;
	        String[] EMPLOYEE_ID_PREFIX = {"Emp-", "Prog-", "PL-", "AL-"};
	        String newEmployeeID;
	
	        do {
	            employeeCounter++;
	            if (positionIndex < EMPLOYEE_ID_PREFIX.length) {
	                newEmployeeID = EMPLOYEE_ID_PREFIX[positionIndex] + String.format("%03d", employeeCounter);
	            } else {
	                newEmployeeID = "Emp-" + String.format("%03d", employeeCounter);
	            }
	        } while (isEmployeeIDExists(newEmployeeID, employeesList));
	
	        return newEmployeeID;
	    }
	
	    private int indexByJobTitle(String targetJobDesc) {
	        for (int i = 0; i < POSITION.length; i++) {
	            for (int j = 0; j < JOB_DESC[i].length; j++) {
	                if (JOB_DESC[i][j].equalsIgnoreCase(targetJobDesc)) {
	                    return i;
	                }
	            }
	        }
	        return -1;
	    }


		private boolean isEmployeeIDExists(String newEmployeeID,  List<Employee> employeesList) {
	        for (Employee employee : employeesList) {
	            if (employee.getEmployeeID().equalsIgnoreCase(newEmployeeID)) {
	                return true;
	            }
	        }
	        return false;
	    }


    private void editEmployee(List<Employee> employeesList) {
        System.out.println("Masukkan Employee ID yang ingin diedit placement-nya: ");
        String employeeIDToEdit = consoleUser.getUserInput("Employee ID: ", InputValidator.getAlphaNumericValidator()).replaceAll("\\s", "");

        Employee employeeToEdit = findEmployeeByID(employeeIDToEdit);

        if (employeeToEdit != null) {
            displayOut.displayEmployeeData(Collections.singletonList(employeeToEdit));

            String newPlacement = consoleUser.getUserInput("Masukkan Kota Penempatan Baru: ", InputValidator.getStringValidator());

            updatePlacement(employeeToEdit, newPlacement);

            System.out.println("Placement Employee berhasil diperbarui.");
        	} else {
            System.out.println("Employee dengan ID " + employeeIDToEdit + " tidak ditemukan.");
        	}
	    }
	
	    private void updatePlacement(Employee employee, String newPlacement) {
	        employee.setPlacement(newPlacement);
	    }
	
	    private Employee findEmployeeByID(String employeeID) {
	        List<Employee> employeesList = repositoryKaryawan.getAllKaryawan();
	        for (Employee employee : employeesList) {
	            if (employee != null && employee.getEmployeeID().equalsIgnoreCase(employeeID)) {
	                return employee;
	            }
	        }
	        return null;
	    }

    private void displayEmployeeData(List<Employee> employeesList) {
        displayOut.displayEmployeeData(employeesList);
        consoleUser.promptBack();
    }

    private void displayPayrollData(List<Employee> employeesList) {
        displayOut.displayPayrollData(employeesList);
        consoleUser.promptBack();
    }

    private void deleteEmployee(List<Employee> employeesList) {
        boolean validEmployeeID;

        do {
            displayOut.displayEmployeeData(employeesList);

            String employeeIDToDelete = consoleUser.getUserInput("Masukkan Employee ID yang akan dihapus: ", InputValidator.getAlphaNumericValidator()).replaceAll("\\s", "");

            Iterator<Employee> iterator = employeesList.iterator();
            boolean found = false;

            while (iterator.hasNext()) {
                Employee employee = iterator.next();
                if (employee != null && employee.getEmployeeID().equalsIgnoreCase(employeeIDToDelete)) {
                    iterator.remove();
                    found = true;
                    System.out.println("Employee dengan ID " + employeeIDToDelete + " berhasil dihapus.");
                    validEmployeeID = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee dengan ID " + employeeIDToDelete + " tidak ditemukan. Silakan coba lagi.");
                validEmployeeID = false;
            } else {
                validEmployeeID = true;
            }
        } while (!validEmployeeID);

        DisplayOut.displayMenu();
    }

    private void searchEmployee(List<Employee> employeesList) {
        displayOut.displaySearchingMenu();
        int searchChoice = consoleUser.getUserChoice();

        switch (searchChoice) {
            case 1:
                searchByPlacement(employeesList);
                break;
            case 0:
                System.out.println("Kembali ke Main Menu.");
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                break;
        }
    }

    private void searchByPlacement(List<Employee> employeesList) {
        boolean validInput;
        do {
            validInput = true;

            String placementToSearch = consoleUser.getUserInput("Masukkan kota penempatan yang ingin dicari: ", InputValidator.getStringValidator());

            List<Employee> searchResults = searchEmployeesByPlacement(employeesList, placementToSearch);

            if (!searchResults.isEmpty()) {
                displayOut.displayEmployeeData(searchResults);
                consoleUser.promptBack();
            } else {
                System.out.println("Tidak ada karyawan dengan penempatan " + placementToSearch);
                validInput = false;
            }
        } while (!validInput);
    }

    private static List<Employee> searchEmployeesByPlacement(List<Employee> employeesList, String placementToSearch) {
        List<Employee> searchResults = new ArrayList<>();

        for (Employee employee : employeesList) {
            if (employee != null && employee.getPlacement().equalsIgnoreCase(placementToSearch)) {
                searchResults.add(employee);
            }
        }

        return searchResults;
    }
}

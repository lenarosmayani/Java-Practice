package displaysetting;

import calculation.SalaryAllowanceCalculator;
import entity.Employee;
import interfacepackage.IDisplay;

import java.util.List;

public class DisplayOut implements IDisplay {

    private SalaryAllowanceCalculator calculator;

    public DisplayOut(SalaryAllowanceCalculator calculator) {
        this.calculator = calculator;
    }

    public static void displayMenu() {
        System.out.println("=================================| Main Menu |==================================");
        System.out.println("Selamat Datang di Aplikasi Pendataan Karyawan PT. Secret Semut 79");
        System.out.println();
        System.out.println("1. Add Employee");
        System.out.println("2. Edit Employee");
        System.out.println("3. Data Employee");
        System.out.println("4. Data Payroll");
        System.out.println("5. Delete Employee");
        System.out.println("6. Searching");
        System.out.println("0. Exit");
        System.out.println("================================================================================");
    }

    public void displaySearchingMenu() {
        System.out.println("=====================================");
        System.out.println("           Menu Searching            ");
        System.out.println("=====================================");
        System.out.println("1. Search By Placement");
        System.out.println("0. Back To Main Menu");
        System.out.println("=====================================");
    }
	
	public void displayEmployeeData(List<Employee> employeesList) {
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------");
	    System.out.println("No\t| Employee Id\t| Name\t| Address\t| Age\t| Job Desc\t\t| Placement");
	    System.out.println("----------------------------------------------------------------------------------------------");

	    int count = 1;
	    for (Employee employee : employeesList) {
	        System.out.printf("%d\t| %-13s\t| %-5s\t| %-8s\t| %-4d\t| %-15s\t| %-8s%n",
	                count,
	                employee.getEmployeeID(),
	                employee.getName(),
	                employee.getAddress(),
	                employee.getAge(),
	                employee.getJobDesc(),
	                employee.getPlacement());
	        count++;
	    }

	    System.out.println("----------------------------------------------------------------------------------------------");
	    System.out.println("0\t| Kembali Ke Main Menu");
	}
	
	public void displayPayrollData(List<Employee> employeesList) {
        double totalPayroll = 0;

        System.out.println("=======================================================================");
        System.out.println("                        Data Payroll Karyawan                          ");
        System.out.println("=======================================================================");
        System.out.printf("%-15s %-15s %-20s %-15s %-15s %-15s%n",
                "Employee ID", "Name", "Job Desc", "Placement", "Allowance", "Salary");
        System.out.println("-----------------------------------------------------------------------");

        for (Employee employee : employeesList) {
            double salary = calculator.calculateSalary();
            double allowance = calculator.calculateAllowance();

            totalPayroll += (allowance + salary);

            System.out.printf("%-15s %-15s %-20s %-15s %-15.2f %-15.2f%n",
                    employee.getEmployeeID(),
                    employee.getName(),
                    employee.getJobDesc(),
                    employee.getPlacement(),
                    allowance,
                    salary);
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        System.out.println("=======================================================================");
    }
}
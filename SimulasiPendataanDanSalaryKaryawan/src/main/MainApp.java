package main;

import entity.Employee;

public class MainApp {

    public static void main(String[] args) {
        ConsoleUser consoleUser = new ConsoleUser();
        Employee employee = new Employee();
        EmployeeManagement employeeManagement = new EmployeeManagement(consoleUser, employee);

        employeeManagement.start();
    }
}

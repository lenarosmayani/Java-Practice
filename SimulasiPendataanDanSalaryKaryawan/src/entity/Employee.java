package entity;

import calculation.SalaryAllowanceCalculator;
public class Employee extends Person {
    private String employeeID;
    private String jobDesc;
    private String placement;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeID, String name, String address, int age, String jobDesc, String placement) {
        super(name, address, age);
        this.employeeID = employeeID;
        this.jobDesc = jobDesc;
        this.placement = placement;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculateSalary() {
        SalaryAllowanceCalculator calculator = new SalaryAllowanceCalculator(this);
        return calculator.calculateSalary();
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", employeeID=" + employeeID +
                ", jobDesc='" + jobDesc + '\'' +
                ", placement='" + placement + '\'' +
                ", salary='" + calculateSalary() + '\'' +
                '}';
    }
}

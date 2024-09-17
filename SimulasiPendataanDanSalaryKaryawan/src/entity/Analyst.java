package entity;

import calculation.SalaryAllowanceCalculator;

public class Analyst extends Employee {
    private static double allowance;
	private static Employee employee;

    public Analyst(String employeeID, String name, String address, int age, String jobDesc, String placement) {
        super(employeeID, name, address, age, jobDesc, placement);
    }
    
    public static double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		Analyst.allowance = allowance;
	}

    public static double calculateAllowance() {
        SalaryAllowanceCalculator calculator = new SalaryAllowanceCalculator(employee);
        return calculator.calculateAllowance();
    }

    @Override
    public String toString() {
        return "Analyst{" +
                super.toString() +
                ", allowance='" + calculateAllowance() + '\'' +'}';
    }

	
}

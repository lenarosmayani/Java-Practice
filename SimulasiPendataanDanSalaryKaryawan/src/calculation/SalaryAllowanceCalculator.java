package calculation;

import entity.Analyst;
import entity.Employee;
import entity.Programmer;
import entity.ProjectLeader;
import interfacepackage.IAllowance;
import interfacepackage.IPlacement;
import interfacepackage.IPosition;
import interfacepackage.ISalaryCalculation;

public class SalaryAllowanceCalculator implements IPosition, ISalaryCalculation, IAllowance, IPlacement {
    private Employee employee;

    public SalaryAllowanceCalculator(Employee employee) {
        this.employee = employee;
    }

    public double calculateSalary() {
        double cityUMK = getUMK(employee.getPlacement());
        int index = indexByJobTitle(employee);
        if (index < SALARY_MULTIPLIERS_BY_POSITION.length) {
            return SALARY_MULTIPLIERS_BY_POSITION[index] * cityUMK;
        } else {
            System.err.println("Invalid job title index: " + index);
            return 0.0;  // or some default value
        }
    }


    public double calculateAllowance() {
        double salary = calculateSalary();
        if (employee instanceof Programmer) {
            Programmer programmer = (Programmer) employee;
            if (programmer.getExperiences() > 4) {
                return calculateProgrammerAllowance(salary);
            } else {
                return calculateProgrammerAllowance2(salary);
            }
        } else if (employee instanceof ProjectLeader) {
            ProjectLeader projectLeader = (ProjectLeader) employee;
            if (projectLeader.getTotalProject() >= 2) {
                return calculateProjectLeaderAllowance(salary);
            } else {
                return calculateProjectLeaderAllowance2(salary);
            }
        } else if (employee instanceof Analyst) {
                return calculateAnalystAllowance(salary);
        } else {
            return 0.0;
        }
    }

    private double calculateProgrammerAllowance(double salary) {
        return PROGRAMMER_ALLOWANCE[0] * salary;
    }

    private double calculateProgrammerAllowance2(double salary) {
        return PROGRAMMER_ALLOWANCE[1] * salary;
    }

    private double calculateProjectLeaderAllowance(double salary) {
        return PROJECT_LEADER_ALLOWANCE[0] * salary;
    }

    private double calculateProjectLeaderAllowance2(double salary) {
        return PROJECT_LEADER_ALLOWANCE[1] * salary;
    }

    private double calculateAnalystAllowance(double salary) {
        return ANALYST_ALLOWANCE * salary;
    }

    public int indexByJobTitle(Employee employee) {
        String targetJobDesc = employee.getJobDesc();
        for (int i = 0; i < POSITION.length; i++) {
            for (int j = 0; j < JOB_DESC[i].length; j++) {
                if (JOB_DESC[i][j].equalsIgnoreCase(targetJobDesc)) {
                    return i;
                }
            }
        }
        return -1;
    }

    
    public String getJobTitle() {
        int indexJobTitle = indexByJobTitle(employee);
        if (indexJobTitle != -1) {
            return POSITION[indexJobTitle];
        }
        return null;
    }
}


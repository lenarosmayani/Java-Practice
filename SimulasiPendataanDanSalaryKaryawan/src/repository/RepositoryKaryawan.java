package repository;

import java.util.ArrayList;
import java.util.List;

import entity.Analyst;
import entity.Employee;
import entity.Programmer;
import entity.ProjectLeader;

public class RepositoryKaryawan {
    private List<Employee> allKaryawan;

    public RepositoryKaryawan() {
        allKaryawan = new ArrayList<>();
        populateData();
    }

    private void populateData() {
        allKaryawan.add(new Employee("Emp-001", "Susi", "Bandung", 27, "Admin", "Jakarta"));
        allKaryawan.add(new Employee("Emp-002", "Anto", "Bandung", 35, "Office Boy", "Bandung"));
        allKaryawan.add(new Employee("Emp-003", "Riman", "Jakarta", 28, "Human Resource Dev", "Bandung"));

        allKaryawan.add(new Programmer("Prog-001", "Budi", "Bandung", 25, "Back End Dev", "Jakarta", "Java", 2));
        allKaryawan.add(new Programmer("Prog-002", "Ani", "Bandung", 30, "Front End Dev", "Bandung", "React Js", 6));
        allKaryawan.add(new Programmer("Prog-003", "Ujang", "Jakarta", 28, "Full Stack Dev", "Bandung", "Kotlin", 4));

        allKaryawan.add(new ProjectLeader("PL-001", "Ahmad", "Bandung", 25, "Project Leader", "Garut", 2));
        allKaryawan.add(new ProjectLeader("PL-002", "Dani", "Bandung", 30, "Scrum Master", "Bekasi", 1));
        allKaryawan.add(new ProjectLeader("PL-003", "Cecep", "Jakarta", 28, "Project Owner", "Bogor", 4));

        allKaryawan.add(new Analyst("AL-001", "Indah", "Garut", 25, "Analyst", "Jakarta"));
        allKaryawan.add(new Analyst("AL-002", "Puspa", "Bandung", 30, "Analyst", "Bekasi"));
        allKaryawan.add(new Analyst("AL-003", "Sari", "Jakarta", 28, "Analyst", "Bogor"));
    }

    public List<Employee> getAllKaryawan() {
        return new ArrayList<>(allKaryawan);
    }

    public void addEmployee(String newEmployeeID, String newEmployeeName,
                             String newEmployeeAddress, int newEmployeeAge, String newJobDesc, String newPlacement) {
        Employee newEmployee = new Employee(newEmployeeID, newEmployeeName, newEmployeeAddress,
                newEmployeeAge, newJobDesc, newPlacement);
        allKaryawan.add(newEmployee);

        System.out.println("Employee baru berhasil ditambahkan!");
    }
}

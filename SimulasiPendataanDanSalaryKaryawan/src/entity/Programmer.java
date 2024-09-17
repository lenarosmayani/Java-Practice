package entity;

public class Programmer extends Analyst {
    private String programmingLanguage;
    private int experiences;

    public Programmer(String employeeID, String name, String address, int age, String jobDesc,
                      String placement, String programmingLanguage, int experiences) {
        super(employeeID, name, address, age, jobDesc, placement);
        this.programmingLanguage = programmingLanguage;
        this.experiences = experiences;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public int getExperiences() {
        return experiences;
    }

    public void setExperiences(int experiences) {
        this.experiences = experiences;
    }
    
    @Override
    public String toString() {
        return "Programmer{" +
                super.toString() +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                ", experiences=" + experiences +
               '}';
    }

}

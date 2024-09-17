package entity;

public class ProjectLeader extends Analyst{
	private int totalProject;

    public ProjectLeader(String employeeID, String name, String address, int age, String jobDesc, String placement,int totalProject) {
        super(employeeID, name, address, age, jobDesc, placement);
        this.totalProject = totalProject;
    }

    public int getTotalProject() {
        return totalProject;
    }

    public void setTotalProject(int totalProject) {
        this.totalProject = totalProject;
    }
    
    @Override
    public String toString() {
        return "ProjectLeader{" +
                super.toString() +
                ", totalProject=" + totalProject +
                '}';
    }
}

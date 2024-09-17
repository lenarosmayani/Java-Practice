public class Author {
    private String firstName;
    private String lastName;
    private String country;
    private int age;

    // Default Constructor
    public Author() {
    }

    // Constructor with Parameters
    public Author(String firstName, String lastName, String country, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCountry(country);
        this.setAge(age);
    }
    
    // Getter, Setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + getFullName() +
                ", country='" + country + '\'' +
                ", age=" + age +
                '}';
    }
}

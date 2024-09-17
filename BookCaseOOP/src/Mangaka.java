public class Mangaka extends Author {
    private String rating;

    // Default Constructor
    public Mangaka() {
    }

    // Constructor with Parameters
    public Mangaka(String firstName, String lastName, String country, int age, String rating) {
        super(firstName, lastName, country, age);
        this.setRating(rating);
    }

    // Getter, Setter, toString methods
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Mangaka{" +
        		"name ='" + getFullName() +
                ", country='" + getCountry() + '\'' +
                ", age=" + getAge() +
                ", rating='" + getRating() + '\'' +
                '}';
    }
}

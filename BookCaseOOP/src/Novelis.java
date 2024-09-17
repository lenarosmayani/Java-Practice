
public class Novelis extends Author {
    private boolean serial;
    private String rating;

    public Novelis() {
    }

    public Novelis(String firstName, String lastName, String country, int age, boolean serial, String rating) {
        super(firstName, lastName, country, age);
        this.setSerial(serial);
        this.setRating(rating);
    }

    public boolean isSerial() {
        return serial;
    }

    public void setSerial(boolean serial) {
        this.serial = serial;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Novelis{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", age=" + getAge() +
                ", serial=" + serial +
                ", rating='" + rating + '\'' +
                '}';
    }
}

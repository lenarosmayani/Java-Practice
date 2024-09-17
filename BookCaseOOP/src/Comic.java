public class Comic extends CommercialBook implements ICalculatePrice, IRating, ITax {
    private boolean volumeSeries;
    private double tax;

    // Default Constructor
    public Comic() {
    }

    // Constructor with Parameters
    public Comic(String bookCode, String title, Mangaka mangaka, Publisher publisher, boolean volumeSeries) {
        super(bookCode, title, mangaka, publisher);
        this.setVolumeSeries(volumeSeries);
        this.calculatePrice();
        this.calculateTax();
    }

    // calculatePrice, calculateTax, toString, Getter, Setter methods

    @Override
    public void calculatePrice() {
        Mangaka mangaka = (Mangaka) getAuthor();
        double productionCost = getPublisher().getProductionCost();

        if (mangaka != null) {
            String rating = mangaka.getRating();
            boolean validRating = false;

            for (int i = 0; i < RATING_ARR.length; i++) {
                if (rating.equalsIgnoreCase(RATING_ARR[i])) {
                    if (this.volumeSeries) {
                        setPrice(productionCost * COMIC_MULTIPLIER_PRICE[0][i]);
                    } else {
                        setPrice(productionCost * COMIC_MULTIPLIER_PRICE[1][i]);
                    }
                    validRating = true;
                    break;
                }
            }

            if (!validRating) {
                System.out.println("Rating tidak valid: " + rating);
            }
        } else {
            System.out.println("Objek Mangaka belum diinisialisasi.");
        }
    }

    @Override
    public void calculateTax() {
        setTax(getPrice() * TAX_PERCENTAGE);
    }

    public boolean isVolumeSeries() {
        return this.volumeSeries;
    }

    public void setVolumeSeries(boolean volumeSeries) {
        this.volumeSeries = volumeSeries;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        Mangaka mangaka = (Mangaka) getAuthor();
        Publisher publisher = getPublisher();

        if (mangaka != null) {
            return "Comic{" +
                    "volumeSeries=" + volumeSeries +
                    ", tax=" + tax +
                    ", bookCode='" + getBookCode() + '\'' +
                    ", title='" + getTitle() + '\'' +
                    ", author=" + mangaka.getFirstName() + " " + mangaka.getLastName() +
                    ", publisher=" + (publisher != null ? publisher.getPublisherName() : "Unknown Publisher") +
                    ", price=" + getPrice() +
                    '}';
        } else {
            return "Comic{" +
                    "volumeSeries=" + volumeSeries +
                    ", tax=" + tax +
                    ", bookCode='" + getBookCode() + '\'' +
                    ", title='" + getTitle() + '\'' +
                    ", author=Unknown Author" +
                    ", publisher=" + (publisher != null ? publisher.getPublisherName() : "Unknown Publisher") +
                    ", price=" + getPrice() +
                    '}';
        }
    }
}

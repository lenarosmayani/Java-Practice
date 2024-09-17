public class Novel extends CommercialBook implements ICalculatePrice, IRating {
    private String genre;

    // Default Constructor
    public Novel() {
    }

    // Constructor with Parameters
    public Novel(String bookCode, String title, Novelis novelis, Publisher publisher, String genre) {
        super(bookCode, title, novelis, publisher);
        this.genre = genre;
    }

	// calculatePrice, toString, Getter, Setter methods
    @Override
    public void calculatePrice() {
        Novelis novelis = (Novelis) getAuthor();

        if (novelis != null) {
            double productionCost = getPublisher().getProductionCost();
            String rating = novelis.getRating();

            boolean validRating = false;
            for (int i = 0; i < RATING_ARR.length; i++) {
                if (rating.equalsIgnoreCase(RATING_ARR[i])) {
                    setPrice(productionCost * NOVEL_MULTIPLIER_PRICE_BY_RATING[i]);
                    validRating = true;
                    break;
                }
            }
            if (!validRating) {
                System.out.println("Rating tidak valid: " + rating);
            }
        } else {
            System.out.println("Objek Novelis belum diinisialisasi.");
        }
    }

    @Override
    public String toString() {
        Novelis novelis =(Novelis) getAuthor();
        Publisher publisher = getPublisher();

        return "Novel{" +
                "genre='" + genre + '\'' +
                ", bookCode='" + getBookCode() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author=" + (novelis != null ? novelis.getFirstName() + " " + novelis.getLastName() : "Unknown Author") +
                ", publisher=" + (publisher != null ? publisher.getPublisherName() : "Unknown Publisher") +
                ", price=" + getPrice() +
                '}';
    }
	public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

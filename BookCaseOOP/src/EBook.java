public class EBook extends CommercialBook implements ICalculatePrice{
  
    // Default Constructor
    public EBook() {
    }
    
    // Constructor with Parameters
    public EBook(String bookCode, String title, Author author, Publisher publisher) {
        super(bookCode, title, author, publisher);
    }


	// calculatePrice, toString, Getter, Setter methods
    public void calculatePrice() {
        double productionCost = getPublisher().getProductionCost();
        setPrice(productionCost * EBOOK_MULTIPLIER_PRICE );
    }

    @Override
    public String toString() {
        return "EBook{" +
                "bookCode='" + getBookCode() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author=" + (getAuthor() != null ? getAuthor().getFirstName() + " " + getAuthor().getLastName() : "Unknown Author") +
                ", publisher=" + (getPublisher() != null ? getPublisher().getPublisherName() : "Unknown Publisher") +
                ", price=" + getPrice() +
                '}';
    }

  
}

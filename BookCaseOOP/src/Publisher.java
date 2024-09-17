public class Publisher {
    private String publisherName;
    private String country;
    private double productionCost;

    // Default Constructor
    public Publisher() {
    }

    // Constructor with Parameters
    public Publisher(String publisherName, String country, double productionCost) {
        this.setPublisherName(publisherName);
        this.setCountry(country);
        this.setProductionCost(productionCost);
    }

    // toString, Getter, Setter methods
    @Override
    public String toString() {
        return "Publisher{" +
                "publisherName='" + publisherName + '\'' +
                ", country='" + country + '\'' +
                ", productionCost=" + productionCost +
                '}';
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }
}

package Entity;

import Interface.ICalculateBookLoanPrice;

public class Comic extends BookForLoan implements ICalculateBookLoanPrice {
    private String genre;

    public Comic(String bookID, String title, String author, double bookPrice, int stock, String genre) {
        super(bookID, title, author, bookPrice, stock);
        this.genre = genre;
    }

	public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public double calculateBookLoanPrice() {
        double stockPercentage = (getStock() < 10) ? RATE_STOCK_PERCENTAGE_UNDER_10 : RATE_STOCK_PERCENTAGE_ABOVE_10;
        double bookTypePercentage = RATE_COMIC;
        return (stockPercentage + bookTypePercentage) * getBookPrice();
    }
    
    @Override
    public String toString() {
        return "Comic{" +
                super.toString() +
                ", genre='" + genre + '\'' +
                '}';
    }
}

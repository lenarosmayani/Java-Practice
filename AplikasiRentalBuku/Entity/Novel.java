package Entity;

import Interface.ICalculateBookLoanPrice;

public class Novel extends BookForLoan implements ICalculateBookLoanPrice {
    private boolean isASeries;

    
    public Novel(String bookID, String title, String author, double bookPrice, int stock, boolean isASeries) {
        super(bookID, title, author, bookPrice, stock);
        this.isASeries = isASeries;
    }

	public boolean isASeries() {
        return isASeries;
    }

    public void setASeries(boolean isASeries) {
        this.isASeries = isASeries;
    }
    
    @Override
    public double calculateBookLoanPrice() {
        double stockPercentage = (getStock() < 10) ? RATE_STOCK_PERCENTAGE_UNDER_10 : RATE_STOCK_PERCENTAGE_ABOVE_10;
        double bookTypePercentage = RATE_NOVEL;
        return (stockPercentage + bookTypePercentage) * getBookPrice();
    }

    @Override
    public String toString() {
        return "Novel{" +
                super.toString() +
                ", isASeries=" + isASeries +
                '}';
    }
}


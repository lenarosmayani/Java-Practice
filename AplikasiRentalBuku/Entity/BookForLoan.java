package Entity;

import Interface.ICalculateBookLoanPrice;


public abstract class BookForLoan extends Book implements ICalculateBookLoanPrice{
    private double bookLoanPrice;
    private int stock;

    public BookForLoan(String bookID, String title, String author, double bookPrice, int stock) {
        super(bookID, title, author, bookPrice);
        this.stock = stock;
        calculateBookLoanPrice();
    }

	public double getBookLoanPrice() {
        return bookLoanPrice;
    }

    public void setBookLoanPrice(double bookLoanPrice) {
        this.bookLoanPrice = bookLoanPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "BookForLoan{" +
                super.toString() +
                ", bookLoanPrice=" + bookLoanPrice +
                ", stock=" + stock +
                '}';
    }

	public void decreaseStock() {
		stock--;
		
	}

	public void increaseStock() {
		stock++;
		
	}

}



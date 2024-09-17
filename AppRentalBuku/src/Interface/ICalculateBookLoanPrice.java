package Interface;

public interface ICalculateBookLoanPrice {
    double RATE_STOCK_PERCENTAGE_UNDER_10 = 0.05;
    double RATE_STOCK_PERCENTAGE_ABOVE_10 = 0.03;
    double RATE_COMIC = 0.1;
    double RATE_NOVEL = 0.05;

    double calculateBookLoanPrice();
}
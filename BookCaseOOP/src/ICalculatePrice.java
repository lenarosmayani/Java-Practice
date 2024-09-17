

public interface ICalculatePrice {

	void calculatePrice();
	double EBOOK_MULTIPLIER_PRICE = 1.2;

	double NOVEL_MULTIPLIER_PRICE_BY_RATING [] = {1.25, 1.35, 1.50};
	
	double[][] COMIC_MULTIPLIER_PRICE = {{1.35, 1.45, 1.5}, {1.25, 1.3, 1.4}};
}
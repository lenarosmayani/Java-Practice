import java.util.Scanner;

public class Soal5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        double R = input.nextDouble();
        double N = input.nextDouble();
        
        double L = 3.14 * R * R * N;
        
        System.out.printf("%.2f\n",L);

        input.close();

	}
}

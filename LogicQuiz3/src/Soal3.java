import java.util.Scanner;

public class Soal3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int R1 = input.nextInt();
        int R2 = input.nextInt();
        int R3 = input.nextInt();
        double S = input.nextDouble();

        double S2 = R2 * (S/R1) ;
        double S3 = R3 * (S/R1);

        double luas1 = S * S;
        double luas2 = S2 * S2;
        double luas3 = S3 * S3;

        double jumlahLuas = luas1 + luas2 + luas3;

        System.out.printf("%.2f\n", jumlahLuas);

        input.close();
	}

}

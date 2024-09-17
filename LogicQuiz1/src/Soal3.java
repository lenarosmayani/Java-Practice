import java.util.Scanner;

public class Soal3 {
	
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double Awal = input.nextDouble();
        double Bunga = input.nextDouble();

        double total = Awal + (Awal * (Bunga / 100));

        System.out.printf("%.2f\n", total);

        input.close();
    }
}

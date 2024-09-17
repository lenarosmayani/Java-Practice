import java.util.Scanner;

public class Soal3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        double R = input.nextDouble();
        double t = input.nextDouble();
        
        double V = 3.14 * R * R * t;
        
        System.out.printf("%.2f\n",V);

        input.close();

	}

}

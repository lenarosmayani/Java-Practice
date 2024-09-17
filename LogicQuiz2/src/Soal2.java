import java.util.Scanner;

public class Soal2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double suhuR = input.nextDouble();

        double suhuK = suhuR * 1.25 + 273;

        System.out.printf("%.2f\n",suhuK);

        input.close();
    }
}

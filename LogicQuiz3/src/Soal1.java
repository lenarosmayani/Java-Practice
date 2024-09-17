import java.util.Scanner;

public class Soal1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double uang = input.nextDouble();
        double kapasitas = input.nextDouble();

        int hargaBensin = 7600;
        double jumlahBensin = uang / hargaBensin;

        System.out.printf("%.2f\n", jumlahBensin);

        if (jumlahBensin > kapasitas) {
            System.out.println("Bensin Berlebih");
        }

        input.close();
    }
}

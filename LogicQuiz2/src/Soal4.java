import java.util.Scanner;

public class Soal4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int kendaraan = input.nextInt();
        int waktu = input.nextInt();
        int tarif;

        if (kendaraan == 1) {
            tarif = 2000 + 1000 * (waktu - 1);
        } else {
            tarif = 1000 + 500 * (waktu - 1);
        }

        System.out.println(tarif);

        input.close();
    }
}


import java.util.Scanner;

public class Soal5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menerima input jenis kendaraan dan waktu parkir
        int kendaraan = input.nextInt();
        int waktu = input.nextInt();
        int tarif;

        // Menentukan tarif berdasarkan jenis kendaraan dan waktu parkir
        if (waktu <= 5) {
            // Tarif untuk waktu kurang dari atau sama dengan 5 jam
            if (kendaraan == 1) {
                // Tarif untuk jenis kendaraan 1
                tarif = 1500 * waktu;
                System.out.println(tarif);
            } else {
                // Tarif untuk jenis kendaraan 2
                tarif = 1000 * waktu;
                System.out.println(tarif);
            }
        } else if (waktu > 5 && waktu <= 8) {
            // Tarif untuk waktu lebih dari 5 jam hingga 8 jam
            if (kendaraan == 1) {
                // Tarif untuk jenis kendaraan 1
                tarif = 1500 * 5 + (2000*(waktu-5));
                System.out.println(tarif);
            } else {
                // Tarif untuk jenis kendaraan 2
                tarif = 1000 * 5 + (1500 * (waktu-5));
                System.out.println(tarif);
            }
        } else {
            // Jika waktu lebih dari 8 jam
            System.out.println("disegel");
        }

        input.close();
    }
}

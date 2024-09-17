import java.util.Scanner;

public class Soal1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double harga = input.nextDouble();
        int jumlahBarang = input.nextInt();

        double totalHarga = harga * jumlahBarang;  // Mengubah nama variabel agar sesuai dengan yang digunakan

        // Mengecek apakah jumlah barang kelipatan 3 dan 4, jika ya, berikan diskon 15%
        if (jumlahBarang % 3 == 0 && jumlahBarang % 4 == 0) {
            double diskon = 0.15 * totalHarga;
            totalHarga -= diskon;
        }

        // Menampilkan total harga setelah diskon
        System.out.printf("%.2f\n", totalHarga);

        input.close();
    }
}

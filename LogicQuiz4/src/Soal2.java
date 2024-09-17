import java.util.Scanner;

public class Soal2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menerima input nomor kasus dan banyaknya kasus
        int nomorKasus = input.nextInt();
        int banyakKasus = input.nextInt();

        // Menentukan tindakan yang harus dilakukan oleh satpam
        if (nomorKasus == 1) {
            if (banyakKasus < 4) {
                System.out.println("Serahkan KTP anda !!!");
            } else {
                System.out.println("Bayar Denda 10000 !!!");
            }
        } else if (nomorKasus == 2) {
            System.out.println("Ambil STNK dulu !!!");
        }

        input.close();
    }
}

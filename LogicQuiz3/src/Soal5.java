import java.util.Scanner;

public class Soal5 {

    public static void main(String[] args) {
    	 Scanner input = new Scanner(System.in);

         int jumlahUang = input.nextInt();
         double saldoRekening = input.nextDouble();

         double biayaTransaksi = 0.5;
         double totalBiaya = jumlahUang + biayaTransaksi;

         if (saldoRekening >= totalBiaya && jumlahUang % 5 == 0) {
             saldoRekening -= totalBiaya;
             System.out.printf("%.2f\n", saldoRekening);
         } else {
             System.out.printf("%.2f\n", saldoRekening);
         }

         input.close();
     
    }
}

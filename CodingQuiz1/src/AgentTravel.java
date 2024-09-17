import java.util.Scanner;

public class AgentTravel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jumlahPenumpang;

        int[] arrJumlahKursi = {60, 45, 32, 18, 12};
        int[] arrHargaBus = {2300000, 2000000, 1800000, 1500000, 1300000};

        jumlahPenumpang = input.nextInt();

        // Mendapatkan rekomendasi harga termurah
        int hargaTermurah = rekHargaBus(jumlahPenumpang, arrJumlahKursi, arrHargaBus);

        // Menampilkan output
        System.out.println(hargaTermurah);
    }

    public static int rekHargaBus(int jumlahPenumpang, int[] arrJumlahKursi, int[] arrHargaBus) {
    int totalHarga = Integer.MAX_VALUE;

    for (int i = 0; i < arrJumlahKursi.length; i++) {
        if (jumlahPenumpang <= arrJumlahKursi[i]) {
            totalHarga = Math.min(totalHarga, arrHargaBus[i]);
        } else {
            int jumlahBus = (int) Math.ceil((double) jumlahPenumpang / arrJumlahKursi[i]);
            totalHarga = Math.min(totalHarga, jumlahBus * arrHargaBus[i]);
        }
	}
    return totalHarga;
	}
}

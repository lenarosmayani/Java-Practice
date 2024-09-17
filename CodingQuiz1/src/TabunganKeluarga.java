import java.util.Scanner;

public class TotalTabungan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca input jumlah keluarga dan lama tabungan
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Menghitung total tabungan
        int totalTabungan = hitungTotalTabungan(m, n);

        // Menampilkan output
        String result;

        if (1 < m && m < 6 && 0 < n && n < 13) {
            result = String.valueOf(totalTabungan);
        } else {
            result = "Input Error!!!";
        }
        System.out.println(result);
    }

    public static int hitungTotalTabungan(int m, int n) {
        int totalTabungan = 0;

            for (int bulan = 1; bulan <= n; bulan++) {
                int hariDalamBulan = hitungHariDalamBulan(bulan);
                for (int hari = 1; hari <= hariDalamBulan; hari++) {
                    int tabunganHariIni = m * (hari * 1000);  // Setiap anggota menabung sejumlah tanggal * 1000 pada setiap tanggal
                    totalTabungan += tabunganHariIni;
                }
            }

        return totalTabungan;
    }

    public static int hitungHariDalamBulan(int bulan) {
        // Fungsi untuk mendapatkan jumlah hari dalam satu bulan
        int tahun = 2024;  // Tahun kabisat
        int hariDalamBulan;

        if (bulan == 1 || bulan == 3 || bulan == 5 || bulan == 7 || bulan == 8 || bulan == 10 || bulan == 12) {
            hariDalamBulan = 31;
        } else if (bulan == 4 || bulan == 6 || bulan == 9 || bulan == 11) {
            hariDalamBulan = 30;
        } else if (bulan == 2) {
            hariDalamBulan = isTahunKabisat(tahun) ? 29 : 28;
        } else {
            hariDalamBulan = 0;  // Bulan tidak valid
        }

        return hariDalamBulan;
    }

    public static boolean isTahunKabisat(int tahun) {
        // Fungsi untuk mengecek apakah tahun ini tahun kabisat atau bukan
        return (tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0);
    }
}

import java.text.DecimalFormat;
import java.util.Scanner;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat array
        String[] arrDivisi = {"Surabaya", "Jakarta", "Bandung", "Medan", "Makassar"};
        String[] arrPosisi = {"Software Engineer", "Data Analyst", "UX Designer", "Project Manager", "QA Engineer"};
        int[][] arrGajiPokok = {{8000000, 7000000, 7500000, 10000000, 7500000},
                                {9000000, 8000000, 8500000, 11000000, 8500000},
                                {7500000, 6500000, 7000000, 9500000, 7000000},
                                {7200000, 6200000, 6800000, 9200000, 6800000},
                                {8500000, 7500000, 8000000, 10500000, 8000000}};
        int[] tunjanganTransportasi = {1000000, 1500000, 1200000, 1100000, 1300000};

        // Input
        String posisi = scanner.nextLine();
        String divisi = scanner.nextLine();
         
        //Menghitung Tunjangan Makan
        int tunjanganMakan = 50000 * 22;
        
        // Mendapatkan gajiPokok berdasarkan divisi
        int gajiPokok = getGajiPokok(divisi, arrDivisi, posisi, arrPosisi, arrGajiPokok);

        // Mendapatkan tunjangan transportasi berdasarkan divisi
        int tunjanganTransport = getTunjanganTransport(divisi, arrDivisi, tunjanganTransportasi);

        // Menghitung tunjangan kesehatan
        double tunjanganKesehatan = calculateTunjanganKesehatan(gajiPokok);

        // Menghitung potongan BPJS
        double potonganBPJS = calculatePotonganBPJS(gajiPokok);

        // Menghitung potongan PPH
        double potonganPPH = calculatePotonganPPH(gajiPokok);

        // Menghitung gaji bersih
        double gajiBersih = calculateGajiBersih(gajiPokok, tunjanganMakan, tunjanganTransport, tunjanganKesehatan, potonganBPJS, potonganPPH);

        // Format angka dengan dua desimal
        DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.00");

        // Output
        System.out.println(posisi);
        System.out.println(divisi);
        System.out.println("22 hari");
        System.out.println( decimalFormat.format(gajiBersih));
    }

    public static int getGajiPokok(String divisi, String[] arrDivisi, String posisi, String[] arrPosisi, int[][] arrGajiPokok) {
        int divisiIndex = -1;
        int posisiIndex = -1;

        // Mencari index divisi
        for (int i = 0; i < arrDivisi.length; i++) {
            if (arrDivisi[i].equalsIgnoreCase(divisi)) {
                divisiIndex = i;
                break;
            }
        }

        // Mencari index posisi
        for (int i = 0; i < arrPosisi.length; i++) {
            if (arrPosisi[i].equalsIgnoreCase(posisi)) {
                posisiIndex = i;
                break;
            }
        }

        // Mengembalikan gaji pokok berdasarkan index divisi dan posisi
        return arrGajiPokok[divisiIndex][posisiIndex];
    }

    public static int getTunjanganTransport(String divisi, String[] arrDivisi, int[] tunjanganTransportasi) {
        int divisiIndex = -1;

        // Mencari index divisi
        for (int i = 0; i < arrDivisi.length; i++) {
            if (arrDivisi[i].equalsIgnoreCase(divisi)) {
                divisiIndex = i;
                break;
            }
        }

        // Mengembalikan tunjangan transportasi berdasarkan index divisi
        return tunjanganTransportasi[divisiIndex];
    }

    public static double calculateTunjanganKesehatan(int gajiPokok) {
        double persentaseTunjanganKesehatan = 0.02; // 2%
        return gajiPokok * persentaseTunjanganKesehatan;
    }

    public static double calculatePotonganBPJS(int gajiPokok) {
        double persentasePotonganBPJS = 0.03; // 3%
        return gajiPokok * persentasePotonganBPJS;
    }

    public static double calculatePotonganPPH(int gajiPokok) {
        double persentasePotonganPPH = 0.05; // 5%
        return gajiPokok * persentasePotonganPPH;
    }

    public static double calculateGajiBersih(int gajiPokok, int tunjanganMakan, int tunjanganTransport, double tunjanganKesehatan, double potonganBPJS, double potonganPPH) {
        int jumlahHariKerja = 22;
        double totalGaji = gajiPokok + tunjanganMakan + tunjanganTransport + tunjanganKesehatan;
        double potongan = potonganBPJS + potonganPPH;
        return ((totalGaji ) - potongan);
    }
}
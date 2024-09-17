import java.util.Scanner;

public class ParkirMall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] jenisKendaraan = {"Mobil", "Motor", "Box"};
        int lamaParkir;
        int biayaJamPertama, biayaPerJamBerikutnya, biayaMax, biayaTotal;
        String result;

        int[] arrBiayaJamPertama = {5000, 2000, 10000};
        int[] arrBiayaPerJamBerikutnya = {2000, 1000, 5000};
        int[] arrBiayaParkirMaksimal = {25000, 10000, 50000};

        String inputJenisKendaraan = input.next().toLowerCase();
        int jenisKendaraanIndex = -1;
        for (int i = 0; i < jenisKendaraan.length; i++) {
            if (jenisKendaraan[i].equalsIgnoreCase(inputJenisKendaraan)) {
                jenisKendaraanIndex = i;
                break;
            }
        }

        lamaParkir = input.nextInt();

        if (lamaParkir <= 0 || lamaParkir > 24) {
            result = "Input Error!!!";
        } else {
            biayaJamPertama = getTarifJamPertama(jenisKendaraanIndex, arrBiayaJamPertama);
            biayaPerJamBerikutnya = getTarifJamBerikutnya(jenisKendaraanIndex, arrBiayaPerJamBerikutnya);
            biayaMax = getTarifMaksimal(jenisKendaraanIndex, arrBiayaParkirMaksimal);
            biayaTotal = calculateTotalTarif(biayaJamPertama, lamaParkir, biayaPerJamBerikutnya, biayaMax);

            result = String.valueOf(biayaTotal);
        }

        System.out.println(result);
    }

    public static int getTarifJamPertama(int jenisKendaraan, int[] arrBiayaJamPertama) {
        return arrBiayaJamPertama[jenisKendaraan];
    }

    public static int getTarifJamBerikutnya(int jenisKendaraan, int[] arrBiayaPerJamBerikutnya) {
        return arrBiayaPerJamBerikutnya[jenisKendaraan];
    }

    public static int getTarifMaksimal(int jenisKendaraan, int[] arrBiayaParkirMaksimal) {
        return arrBiayaParkirMaksimal[jenisKendaraan];
    }

    public static int calculateTotalTarif(int biayaJamPertama, int lamaParkir, int biayaPerJamBerikutnya, int biayaMax) {
        int result;
        result = biayaJamPertama + ((lamaParkir - 1) * biayaPerJamBerikutnya);

        if (result > biayaMax) {
            result = biayaMax;
        }
        return result;
    }
}

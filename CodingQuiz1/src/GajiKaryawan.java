import java.util.Scanner;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi
        String[] daftarKota = {"Garut", "Bandung", "Jakarta", "Bekasi", "Bogor", "Palembang"};
        int[] umkPerCabang = {1961085, 3742276, 4453935, 4782935, 4330249, 3289409};
        String[] daftarJabatan = {"Admin", "Coordinator", "SPV", "Manager", "Sprinter", "Officer"};
        double[] tunjanganPegawai = {200000, 500000, 700000, 1000000, 200000, 200000};

        // Input P (kota cabang perusahaan), Q(jabatan), R(lama bekerja), S (status pernikahan (true = menikah))
        String kota = scanner.nextLine();
        String jabatan = scanner.nextLine();
        int lamaBekerja = scanner.nextInt();
        boolean statusMenikah = scanner.nextBoolean();

        // Mendapatkan umk berdasarkan kota
        int umk = getUMK(kota, daftarKota, umkPerCabang);

        // Mendapatkan gaji pokok, tunjangan keluarga, dan tunjangan jabatan
        double gajiPokok = getGajiPokok(jabatan, lamaBekerja, umk);
        double tunjanganKeluarga = getTunjanganKeluarga(gajiPokok, statusMenikah);
        double tunjanganJabatan = getTunjanganJabatan(lamaBekerja, gajiPokok);
        double tunjanganPegawaiValue = getTunjanganPegawai(jabatan, daftarJabatan, tunjanganPegawai);

        // Menghitung gaji kotor
        double gajiKotor = gajiPokok + tunjanganKeluarga + tunjanganJabatan + tunjanganPegawaiValue;

        // Menghitung potongan pensiun, BPJS, dan PPH
        double potonganPensiun = 0.02 * gajiKotor;
        double potonganBPJS = 0.02 * gajiKotor;
        double potonganPPH = 0.05 * gajiKotor;

        // Menghitung gaji bersih
        double gajiBersih = gajiKotor - potonganPensiun - potonganBPJS - potonganPPH;

        // Output
        System.out.println((int) gajiPokok);
        System.out.println((int) tunjanganKeluarga);
        System.out.println((int) tunjanganJabatan);
        System.out.println((int) tunjanganPegawaiValue);
        System.out.println((int) gajiKotor);
        System.out.println((int) potonganPensiun);
        System.out.println((int) potonganBPJS);
        System.out.println((int) potonganPPH);
        System.out.println((int) gajiBersih);

        scanner.close();
    }

    // Implementasi method getGajiPokok
    private static double getGajiPokok(String jabatan, int lamaBekerja, int umk) {
        double gajiPokok = 0;

        if (jabatan.equalsIgnoreCase("Admin")) {
            if (lamaBekerja < 2) {
                gajiPokok = 1.0 * umk;
            } else {
                gajiPokok = 1.2 * umk;
            }
        } else if (jabatan.equalsIgnoreCase("Coordinator")) {
            if (lamaBekerja < 3) {
                gajiPokok = 1.1 * umk;
            } else {
                gajiPokok = 1.3 * umk;
            }
        } else if (jabatan.equalsIgnoreCase("SPV")) {
            if (lamaBekerja < 2) {
                gajiPokok = 1.25 * umk;
            } else if (lamaBekerja >= 2 && lamaBekerja <= 4) {
                gajiPokok = 1.4 * umk;
            } else {
                gajiPokok = 1.5 * umk;
            }
        } else if (jabatan.equalsIgnoreCase("Sprinter")) {
            gajiPokok = 0.9 * umk;
        } else if (jabatan.equalsIgnoreCase("Officer")) {
            gajiPokok = 1.0 * umk;
        } else if (jabatan.equalsIgnoreCase("Manager")) {
            if (lamaBekerja < 3) {
                gajiPokok = 1.5 * umk;
            } else {
                gajiPokok = 2.0 * umk;
            }
        }

        return gajiPokok;
    }

    // Implementasi method getTunjanganKeluarga
    private static double getTunjanganKeluarga(double gajiPokok, boolean statusMenikah) {
        double tunjanganKeluarga = 0;

        if (statusMenikah) {
            tunjanganKeluarga = 0.1 * gajiPokok;
        }

        return tunjanganKeluarga;
    }

    // Implementasi method getTunjanganJabatan
    private static double getTunjanganJabatan(int lamaBekerja, double gajiPokok) {
        double tunjanganJabatan = 0;

        if (lamaBekerja > 4) {
            tunjanganJabatan = 0.05 * gajiPokok;
        }

        return tunjanganJabatan;
    }

    // Implementasi method getTunjanganPegawai
    private static double getTunjanganPegawai(String jabatan, String[] daftarJabatan, double[] tunjanganPegawai) {
        double tunjangan = 0;

        for (int i = 0; i < daftarJabatan.length; i++) {
            if (jabatan.equalsIgnoreCase(daftarJabatan[i])) {
                tunjangan = tunjanganPegawai[i];
                break;
            }
        }

        return tunjangan;
    }

    // Implementasi method getUMK
    private static int getUMK(String kota, String[] daftarKota, int[] umkPerCabang) {
        int umk = 0;

        for (int i = 0; i < daftarKota.length; i++) {
            if (kota.equalsIgnoreCase(daftarKota[i])) {
                umk = umkPerCabang[i];
                break;
            }
        }

        return umk;
    }
}

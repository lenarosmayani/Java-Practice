import java.util.Scanner;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat array
        String[] daftarKota = {"Garut", "Bandung", "Jakarta", "Bekasi", "Bogor", "Palembang"};
        int[] umkPerCabang = {1961085, 3742276, 4453935, 4782935, 4330249, 3289409};
        String[] daftarJabatan = {"Admin", "Coordinator", "SPV", "Manager", "Sprinter", "Officer"};
        int[] tunjanganPegawai = {200000, 500000, 700000, 1000000, 200000, 200000};

        // Input
        String kota = scanner.nextLine();
        String jabatan = scanner.nextLine();
        int lamaBekerja = scanner.nextInt();
        boolean statusMenikah = scanner.nextBoolean();

        // Mendapatkan umk berdasarkan kota
        int umk = getUMK(kota, daftarKota, umkPerCabang);

        // Mendapatkan gaji pokok, tunjangan keluarga, dan tunjangan jabatan
        int gajiPokok = getGajiPokok(jabatan, lamaBekerja, umk);
        int tunjanganKeluarga = getTunjanganKeluarga(gajiPokok, statusMenikah);
        int tunjanganJabatan = getTunjanganJabatan(lamaBekerja, gajiPokok);
        int tunjanganPegawaiValue = getTunjanganPegawai(jabatan, daftarJabatan, tunjanganPegawai);

        // Menghitung gaji kotor
        int gajiKotor = gajiPokok + tunjanganKeluarga + tunjanganJabatan + tunjanganPegawaiValue;

        // Menghitung potongan pensiun, BPJS, dan PPH
        int potonganPensiun = (int) (0.02 * gajiKotor);
        int potonganBPJS = (int) (0.02 * gajiKotor);
        int potonganPPH = (int) (0.05 * gajiKotor);

        // Menghitung gaji bersih
        int gajiBersih = gajiKotor - potonganPensiun - potonganBPJS - potonganPPH;

        // Output
        System.out.println(gajiPokok);
        System.out.println(tunjanganKeluarga);
        System.out.println(tunjanganJabatan);
        System.out.println(tunjanganPegawaiValue);
        System.out.println(gajiKotor);
        System.out.println(potonganPensiun);
        System.out.println(potonganBPJS);
        System.out.println(potonganPPH);
        System.out.println(gajiBersih);

        scanner.close();
    }

    // Implementasi method getGajiPokok
    private static int getGajiPokok(String jabatan, int lamaBekerja, int umk) {
        int gajiPokok = 0;

        if (jabatan.equalsIgnoreCase("Admin")) {
            if (lamaBekerja < 2) {
                gajiPokok = (int) (1.0 * umk);
            } else {
                gajiPokok = (int) (1.2 * umk);
            }
        } else if (jabatan.equalsIgnoreCase("Coordinator")) {
            if (lamaBekerja < 3) {
                gajiPokok = (int) (1.1 * umk);
            } else {
                gajiPokok = (int) (1.3 * umk);
            }
        } else if (jabatan.equalsIgnoreCase("SPV")) {
            if (lamaBekerja < 2) {
                gajiPokok = (int) (1.25 * umk);
            } else if (lamaBekerja >= 2 && lamaBekerja <= 4) {
                gajiPokok = (int) (1.4 * umk);
            } else {
                gajiPokok = (int) (1.5 * umk);
            }
        } else if (jabatan.equalsIgnoreCase("Sprinter")) {
            gajiPokok = (int) (0.9 * umk);
        } else if (jabatan.equalsIgnoreCase("Officer")) {
            gajiPokok = (int) (1.0 * umk);
        } else if (jabatan.equalsIgnoreCase("Manager")) {
            if (lamaBekerja < 3) {
                gajiPokok = (int) (1.5 * umk);
            } else {
                gajiPokok = (int) (2.0 * umk);
            }
        }

        return gajiPokok;
    }

    // Implementasi method getTunjanganKeluarga
    private static int getTunjanganKeluarga(int gajiPokok, boolean statusMenikah) {
        int tunjanganKeluarga = 0;

        if (statusMenikah) {
            tunjanganKeluarga = (int) (0.1 * gajiPokok);
        }

        return tunjanganKeluarga;
    }

    // Implementasi method getTunjanganJabatan
    private static int getTunjanganJabatan(int lamaBekerja, int gajiPokok) {
        int tunjanganJabatan = 0;

        if (lamaBekerja > 4) {
            tunjanganJabatan = (int) (0.05 * gajiPokok);
        }

        return tunjanganJabatan;
    }

    // Implementasi method getTunjanganPegawai
    private static int getTunjanganPegawai(String jabatan, String[] daftarJabatan, int[] tunjanganPegawai) {
        int tunjangan = 0;

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

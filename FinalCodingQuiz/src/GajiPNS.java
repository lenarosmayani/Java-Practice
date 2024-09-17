import java.util.Scanner;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

/*
 * Created by : Lena Rosmayani
 * Created at : 11.38 Kamis, 4 Januari 2024
 */

public class GajiPNS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Membuat array
	    String[] arrGolRuang = {"A", "B", "C", "D", "E"};
	    int[][] arrGajiPokokGol1 = {{
	    						    1560800, 1560800, 1610000, 1610000, 1660700, 1660700, 1713000, 1713000, 1766900, 1766900, 
	    						    1822600, 1822600, 1880000, 1880000, 1939200, 1939200, 2000300, 2000300, 2063300, 2063300, 
	    						    2128300, 2128300, 2195300, 2195300, 2264400, 2264400, 2335800, 2335800
	    						   }, {
	                           	    1560800, 1560800, 1610000, 1704500, 1704500, 1758200, 1758200, 1813600, 1813600, 1870700, 
	    						    1870700, 1929600, 1929600, 1990400, 1990400, 2053100, 2053100, 2117700, 2117700, 2184400, 
	    						    2184400, 2253200, 2253200, 2324200, 2324200, 2397400, 2397400, 2472900
	    						   }, {
	    						    1560800, 1560800, 1610000, 1776600, 1776600, 1832600, 1832600, 1890300, 1890300, 1949800, 
	    						    1949800, 2011200, 2011200, 2074600, 2074600, 2139900, 2139900, 2207300, 2207300, 2276800, 
	    						    2276800, 2348500, 2348500, 2422500, 2422500, 2498800, 2498800, 2557500
	    						   }, {
	    						    1560800, 1560800, 1610000, 1851800, 1851800, 1910100, 1910100, 1970200, 1970200, 2032300, 
	    						    2032300, 2096300, 2096300, 2162300, 2162300, 2230400, 2230400, 2300700, 2300700, 2373100, 
	    						    2373100, 2447900, 2447900, 2525000, 2525000, 2604500, 2604500, 2686500
	    						   }};
	    int[][] arrGajiPokokGol2 = {{
							    	2022200, 2054100, 2054100, 2118800, 2118800, 2185500, 2185500, 2254300, 2254300, 2325300, 
							    	2325300, 2398600, 2398600, 2474100, 2474100, 2552000, 2552000, 2632400, 2632400, 2715300, 
							    	2715300, 2800800, 2800800, 2889100, 2889100, 2980000, 2980000, 3073900, 3073900, 3170700, 
							    	3170700, 3270600, 3270600, 3373600
								   }, {
								    2022200, 2054100, 2054100, 2208400, 2208400, 2277900, 2277900, 2349700, 2349700, 2423700, 
									2423700, 2500000, 2500000, 2578800, 2578800, 2660000, 2660000, 2743800, 2743800, 2830200, 
									2830200, 2919300, 2919300, 3011200, 3011200, 3106100, 3106100, 3203900, 3203900, 3304800, 
									3304800, 3408900, 3408900, 3516300
								   }, {
									2022200, 2054100, 2054100, 2301800, 2301800, 2374300, 2374300, 2449100, 2449100, 2526200, 
									2526200, 2605800, 2605800, 2687800, 2687800, 2772500, 2772500, 2859800, 2859800, 2949900, 
									2949900, 3042800, 3042800, 3138600, 3138600, 3237500, 3237500, 3339400, 3339400, 3444600, 
									3444600, 3553100, 3553100, 3665000
								   }, {
									2022200, 2054100, 2054100, 2399200, 2399200, 2474700, 2474700, 2552700, 2552700, 2633100, 
									2633100, 2716000, 2716000, 2801500, 2801500, 2889800, 2889800, 2980800, 2980800, 3074700, 
									3074700, 3171500, 3171500, 3271400, 3271400, 3374400, 3374400, 3480700, 3480700, 3590300, 
									3590300, 3703400, 3703400, 3820000
								   }};
	    int[][] arrGajiPokokGol3 = {{
							    	2579400, 2579400, 2660700, 2660700, 2744500, 2744500, 2830900, 2830900, 2920100, 2920100, 
							    	3012000, 3012000, 3106900, 3106900, 3204700, 3204700, 3305700, 3305700, 3409800, 3409800, 
							    	3517200, 3517200, 3627900, 3627900, 3742200, 3742200, 3860100, 3860100, 3981600, 3981600, 
							    	4107000, 4107000, 4236400
								   }, {
								    2688500, 2688500, 2773200, 2773200, 2860500, 2860500, 2950600, 2950600, 3043600, 3043600, 
								    3139400, 3139400, 3238300, 3238300, 3340300, 3340300, 3445500, 3445500, 3554000, 3554000, 
								    3665900, 3665900, 3781400, 3781400, 3900500, 3900500, 4023300, 4023300, 4150100, 4150100, 
								    4280800, 4280800, 4415600
								   }, {
								    2802300, 2802300, 2890500, 2890500, 2981500, 2981500, 3075500, 3075500, 3172300, 3172300, 
								    3272200, 3272200, 3375300, 3375300, 3481600, 3481600, 3591200, 3591200, 3704300, 3704300, 
								    3821000, 3821000, 3941400, 3941400, 4065500, 4065500, 4193500, 4193500, 4325600, 4325600, 
								    4461800, 4461800, 4602400
								   }, {
									2920800, 2920800, 3012800, 3012800, 3107700, 3107700, 3205500, 3205500, 3306500, 3306500, 
									3410600, 3410600, 3518100, 3518100, 3628900, 3628900, 3743100, 3743100, 3861000, 3861000, 
									3982600, 3982600, 4108100, 4108100, 4237500, 4237500, 4370900, 4370900, 4508600, 4508600, 
									4650600, 4650600, 4797000
								   }};
	    int[][] arrGajiPokokGol4 = {{
							    	3044300, 3044300, 3140200, 3140200, 3239100, 3239100, 3341100, 3341100, 3446400, 3446400, 
							    	3554900, 3554900, 3666900, 3666900, 3782400, 3782400, 3901500, 3901500, 4024400, 4024400, 
							    	4151100, 4151100, 4281800, 4281800, 4416700, 4416700, 4555800, 4555800, 4699300, 4699300, 
							    	4847300, 4847300, 5000000
								   }, {
									3173100, 3173100, 3272100, 3272100, 3376100, 3376100, 3482500, 3482500, 3592100, 3592100, 
									3705300, 3705300, 3822000, 3822000, 3942400, 3942400, 4066500, 4066500, 4194600, 4194600, 
									4326700, 4326700, 4463000, 4463000, 4603500, 4603500, 4748500, 4748500, 4898100, 4898100, 
									5052300, 5052300, 5211500
								   }, {
									3307300, 3307300, 3411500, 3411500, 3518900, 3518900, 3629800, 3629800, 3744100, 3744100, 
									3862000, 3862000, 3983600, 3983600, 4109100, 4109100, 4238500, 4238500, 4372000, 4372000, 
									4509700, 4509700, 4651800, 4651800, 4798300, 4798300, 4949400, 4949400, 5105300, 5105300, 
									5266100, 5266100, 5431900
								   }, {
									3447200, 3447200, 3555800, 3555800, 3667800, 3667800, 3783300, 3783300, 3902500, 3902500, 
									4025400, 4025400, 4152200, 4152200, 4282900, 4282900, 4417800, 4417800, 4557000, 4557000, 
									4700500, 4700500, 4848500, 4848500, 5001200, 5001200, 5158700, 5158700, 5321200, 5321200, 
									5488800, 5488800, 5661700
								   }, {
									3593100, 3593100, 3706200, 3706200, 3822900, 3822900, 3943300, 3943300, 4067500, 4067500, 
									4195700, 4195700, 4327800, 4327800, 4462100, 4462100, 4604700, 4604700, 4749700, 4749700, 
									4899300, 4899300, 5053600, 5053600, 5212800, 5212800, 5377000, 5377000, 5546300, 5546300, 
									5721000, 5721000, 5901200
								   }};
	    
	    int[][][] arrGajiPokok = {arrGajiPokokGol1, arrGajiPokokGol2, arrGajiPokokGol3, arrGajiPokokGol4} ;
	    int [] arrTunjanganUmumJabatan = {175000, 180000, 185000, 190000};
	    int [] arrPotonganTaperum = {3000, 5000, 7000, 10000};

	 // Validasi Nama Pegawai
        String nama;
        do {
            System.out.println("Masukkan Nama Pegawai (Hanya Alfabet): ");
            nama = scanner.nextLine();
            if (!isValidNama(nama)) {
                System.out.println("Inputan yang Anda masukkan salah!");
                System.out.println();
            }
        } while (!isValidNama(nama));

        // Validasi Golongan Pangkat
        int golonganPangkat;
        do {
            System.out.println("Masukkan Golongan Pangkat (1-4): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Inputan yang Anda masukkan salah!");
                scanner.next();
            }
            golonganPangkat = scanner.nextInt();
            scanner.nextLine();
            if (!isValidGolonganPangkat(golonganPangkat)) {
                System.out.println("Inputan yang Anda masukkan salah!");
                System.out.println();
            }
        } while (!isValidGolonganPangkat(golonganPangkat));

        // Validasi Golongan Ruang Kerja
        String tipeGolongan;
        do {
            System.out.println("Masukkan Golongan Ruang Kerja (A/B/C/D/E): ");
            tipeGolongan = scanner.nextLine();
            if (!isValidGolonganRuangKerja(golonganPangkat, tipeGolongan)) {
                System.out.println("Inputan yang Anda masukkan salah!");
                System.out.println();
            }
        } while (!isValidGolonganRuangKerja(golonganPangkat, tipeGolongan));

        // Validasi Masa Kerja
        int masaKerja;
        do {
            System.out.println("Masukkan Masa Kerja (0-50): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Inputan yang Anda masukkan salah!");
                scanner.next();
            }
            masaKerja = scanner.nextInt();
            scanner.nextLine();
            if (!isValidMasaKerja(masaKerja)) {
                System.out.println("Inputan yang Anda masukkan salah!");
                System.out.println();
            }
        } while (!isValidMasaKerja(masaKerja));

        // Validasi Status Pernikahan
        String statusPernikahan;
        do {
            System.out.println("Masukkan Status Pernikahan (Kawin/Belum Kawin/Cerai): ");
            statusPernikahan = scanner.nextLine();
            if (!isValidStatusPernikahan(statusPernikahan)) {
                System.out.println("Inputan yang Anda masukkan salah!");
                System.out.println();
            }
        } while (!isValidStatusPernikahan(statusPernikahan));

        // Validasi Jumlah Anak
        int jumlahAnak;
        do {
            System.out.println("Masukkan Jumlah Anak (>= 0): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Inputan yang Anda masukkan salah!");
                scanner.next();
            }
            jumlahAnak = scanner.nextInt();
            scanner.nextLine();
            if (!isValidJumlahAnak(jumlahAnak)) {
                System.out.println("Inputan yang Anda masukkan salah!");
                System.out.println();
            }
        } while (!isValidJumlahAnak(jumlahAnak));
        
         scanner.close();
         
        // Mendapatkan Kalkulasi gaji, potongan dan tunjangan
        int gajiPokok = kalkulasiGajiPokok(masaKerja,tipeGolongan, arrGolRuang,golonganPangkat,arrGajiPokok);
        int tunjanganKeluarga = kalkulasiTunjanganKeluarga(statusPernikahan, gajiPokok);
        int tunjanganAnak = kalkulasiTunjanganAnak(jumlahAnak, gajiPokok);
        int tunjanganBeras = kalkulasiTunjanganBeras(statusPernikahan, jumlahAnak);
        int tunjanganUmumJabatan = kalkulasiTunjanganUmumJabatan(golonganPangkat, arrTunjanganUmumJabatan);
        int gajiKotor = kalkulasiGajiKotor(gajiPokok, tunjanganAnak, tunjanganKeluarga, tunjanganUmumJabatan, tunjanganBeras);
        int potonganPPH = kalkulasiPotonganPPH(gajiPokok, statusPernikahan, gajiKotor, jumlahAnak, tunjanganKeluarga, tunjanganAnak);
        int potonganIWP = kalkulasiPotonganIWP(gajiPokok, tunjanganAnak, tunjanganKeluarga);
        int potonganTaperum = kalkulasiPotonganTaperum(golonganPangkat, arrPotonganTaperum);
        int gajiBersih = kalkulasiGajiBersih(gajiKotor, potonganPPH, potonganIWP, potonganTaperum);

        // Format angka dengan dua desimal
        DecimalFormat decimalFormat = new DecimalFormat("Rp #,###,##0.00");
        
        // Display Out
        System.out.println();
        System.out.println("H A S I L");
        System.out.println("======================================");
        System.out.printf("%-20s: %s%n", "Nama Pegawai", nama);
        System.out.printf("%-20s: %s%n", "Gaji Pokok", decimalFormat.format(gajiPokok));
        System.out.printf("%-20s: %s%n", "Tunjangan Keluarga", decimalFormat.format(tunjanganKeluarga));
        System.out.printf("%-20s: %s%n", "Tunjangan Anak", decimalFormat.format(tunjanganAnak));
        System.out.printf("%-20s: %s%n", "Tunjangan Beras", decimalFormat.format(tunjanganBeras));
        System.out.printf("%-20s: %s%n", "Tunjangan Jabatan", decimalFormat.format(tunjanganUmumJabatan));
        System.out.printf("%-20s: %s%n", "Gaji Bruto", decimalFormat.format(gajiKotor));
        System.out.printf("%-20s: %s%n", "Pph", decimalFormat.format(potonganPPH));
        System.out.printf("%-20s: %s%n", "Potongan IWP", decimalFormat.format(potonganIWP));
        System.out.printf("%-20s: %s%n", "Potongan Taperum", decimalFormat.format(potonganTaperum));
        System.out.printf("%-20s: %s%n", "Gaji Take Home Pay", decimalFormat.format(gajiBersih));
        System.out.println("======================================");
	}


    private static boolean isValidNama(String nama) {
        return Pattern.matches("^[A-Za-z\\s]+$", nama);
    }

    private static boolean isValidGolonganPangkat(int golonganPangkat) {
        return golonganPangkat >= 1 && golonganPangkat <= 4;
    }


    private static boolean isValidGolonganRuangKerja(int golonganPangkat, String golonganRuangKerja) {
        if (golonganPangkat >= 1 && golonganPangkat <= 3) {
            return Pattern.matches("^[A-Da-d]$", golonganRuangKerja);
        } else if (golonganPangkat == 4) {
            return Pattern.matches("^[A-Ea-e]$", golonganRuangKerja);
        }
        return false;
    }

    private static boolean isValidMasaKerja(int masaKerja) {
        return masaKerja >= 0 && masaKerja <= 50;
    }

    private static boolean isValidStatusPernikahan(String statusPernikahan) {
        boolean isValid = Pattern.matches("^[A-Za-z\\s]+$", statusPernikahan);
     
        if (isValid) {
            switch (statusPernikahan.toLowerCase()) {
                case "kawin":
                case "belum kawin":
                case "cerai":
                    return true;
                default:
                    return false;
            }
        }
  
        return false;
    }

    private static boolean isValidJumlahAnak(int jumlahAnak) {
        return jumlahAnak >= 0;
    }

    private static int kalkulasiGajiPokok(int masaKerja, String tipeGolongan, String[] arrGolRuang, int golonganPangkat, int[][][] arrGajiPokok) {
        int golonganPangkatIndex = -1;
        int tipeGolonganIndex = -1;

        for (int i = 0; i < arrGajiPokok.length; i++) {
            if (i + 1 == golonganPangkat) { 
                golonganPangkatIndex = i;
                break;
            }
        }

        for (int i = 0; i < arrGolRuang.length; i++) {
            if (arrGolRuang[i].equalsIgnoreCase(tipeGolongan)) {
                tipeGolonganIndex = i;
                break;
            }
        }
        
        int masaKerjaMaksimal = arrGajiPokok[golonganPangkatIndex][tipeGolonganIndex].length - 1;

        masaKerja = Math.min(masaKerja, masaKerjaMaksimal);

        if (golonganPangkatIndex != -1 && tipeGolonganIndex != -1) {
            return arrGajiPokok[golonganPangkatIndex][tipeGolonganIndex][masaKerja];
        } else {
            return 0;
        }
    }

    private static int kalkulasiTunjanganKeluarga(String statusPernikahan, int gajiPokok) {
        double persentaseTunjanganKeluarga = 0.0;
        
        if (statusPernikahan.equalsIgnoreCase("Kawin")) {
            persentaseTunjanganKeluarga = 0.1;
        }
        
        return (int) (gajiPokok * persentaseTunjanganKeluarga);
    }

    private static int kalkulasiTunjanganAnak(int jumlahAnak, int gajiPokok) {
        double persentaseTunjanganAnak = 0.0;
        int maxAnak = 2;
        persentaseTunjanganAnak = 0.02;

        return (int) (gajiPokok * persentaseTunjanganAnak * Math.min(jumlahAnak, maxAnak));
    }

    private static int kalkulasiTunjanganBeras(String statusPernikahan, int jumlahAnak) {
        int beratBerasPerAnggota = 10;
        int maxAnak = 2;
        int hargaBeras = 15000;
      
        int jumlahAnggota; 
        if (statusPernikahan.equalsIgnoreCase("Kawin")) {
            jumlahAnggota = 2 + Math.min(jumlahAnak, maxAnak);
        } else {
            jumlahAnggota = 1 + Math.min(jumlahAnak, maxAnak);
        }
        
        return (int) (beratBerasPerAnggota * hargaBeras * jumlahAnggota);
    }

    private static int kalkulasiTunjanganUmumJabatan(int golonganPangkat, int[] arrTunjanganUmumJabatan) {
        int TunjUmumJabatanIndex = -1;

        for (int i = 0; i < arrTunjanganUmumJabatan.length; i++) {
            if (i + 1 == golonganPangkat) {
                TunjUmumJabatanIndex = i;
                break;
            }
        }
        return arrTunjanganUmumJabatan[TunjUmumJabatanIndex];
    }

    private static int kalkulasiGajiKotor(int gajiPokok, int tunjanganAnak, int tunjanganKeluarga, int tunjanganUmumJabatan, int tunjanganBeras) {
        return gajiPokok + tunjanganAnak + tunjanganKeluarga + tunjanganUmumJabatan + tunjanganBeras;
    }

    private static int kalkulasiPotonganPPH(int gajiPokok, String statusPernikahan, int gajiKotor, int jumlahAnak, int tunjanganKeluarga, int tunjanganAnak) {
        int wPSendiri  = 36000000;
        int wPPasangan = 3000000;
        int wPAnak = 3000000;
        int maxAnak = 3;

        int biayaJabatan = (int)(0.05 * gajiKotor);
        int iuranPensiun = (int)(0.0475 * (gajiPokok + tunjanganAnak + tunjanganKeluarga));
        int gajiKotorPerBulan = gajiKotor - (biayaJabatan + iuranPensiun);
        int gajiKotorPerTahun = gajiKotorPerBulan * 12;
        
        int PTKP;
        if (statusPernikahan.equalsIgnoreCase("Kawin")) {
            PTKP = wPSendiri + wPPasangan + (wPAnak * Math.min(jumlahAnak, maxAnak));
        } else {
            PTKP = wPSendiri + (wPAnak * Math.min(jumlahAnak, maxAnak));
        }
        
        int PKP = gajiKotorPerTahun - PTKP;
        
        int pPHSetahun = 0;
        if (gajiKotor >= 4500000) {
            pPHSetahun = (int)(0.05 * PKP);
        }
        
        return pPHSetahun / 12;
    }

    private static int kalkulasiPotonganIWP(int gajiPokok, int tunjanganAnak, int tunjanganKeluarga) {
    	double persentasePotonganIWP = 0.1;
    	return (int)((gajiPokok + tunjanganAnak + tunjanganKeluarga) * persentasePotonganIWP);
    }

    private static int kalkulasiPotonganTaperum(int golonganPangkat, int [] arrPotonganTaperum) {
    	int potonganTaperumIndex = -1;

        for (int i = 0; i < arrPotonganTaperum.length; i++) {
            if (i + 1 == golonganPangkat) {
            	potonganTaperumIndex = i;
                break;
            }
        }

        return arrPotonganTaperum[potonganTaperumIndex];
    }

    private static int kalkulasiGajiBersih(int gajiKotor, int potonganPPH, int potonganIWP, int potonganTaperum) {
        return gajiKotor - potonganPPH - potonganIWP - potonganTaperum;
    }
}
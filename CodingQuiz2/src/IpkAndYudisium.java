import java.util.Scanner;

public class IpkAndYudisium {

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		String[] arrNamaModule;
		String[] arrHarkat;
		int [] arrSks;
		int [] arrScore;
		
		String statusYudisium = "";
		int banyakModule = 0;
		double ipk, totalSks = 0, totalScore = 0;
		boolean isPending = false;

		//Input banyak module
		banyakModule = Integer.valueOf(input.nextLine());
		
		//inisialisasi semua Array yang dibutuhkan berdasarkan Banyak module
		arrNamaModule = new String[banyakModule];
		arrHarkat = new String[banyakModule];
		arrScore = new int [banyakModule];
		arrSks = new int [banyakModule];
		
		//Lengkapi Kodingan Berikut ini, Agar Looping input data Module berdasarkan Banyak Module Bisa berjalan Sesuai dengan Kebutuhan.
		// Looping input data Module berdasarkan Banyak Module
        for (int i = 0; i < banyakModule; i++) {
            // Input Nama Module
            arrNamaModule[i] = input.nextLine();

            // Input Jumlah SKS
            arrSks[i] = Integer.parseInt(input.nextLine());

            // Input Nilai Harkat
            arrHarkat[i] = input.nextLine();

            // Update arrScore berdasarkan Harkat
            arrScore[i] = convertHarkat(arrHarkat[i])*arrSks[i];
        }
        
		totalScore = calculateTotalValue(arrScore);
		totalSks = calculateTotalValue(arrSks);	
		ipk = calculateIpk(totalSks, totalScore);
		isPending = isPendingValildation(arrHarkat);
		statusYudisium = getYudisium(isPending, ipk);
		
		//print hasil
		printHasil(ipk, totalSks, statusYudisium, arrNamaModule, arrHarkat);
	}	
	
	//menghitung total nilai pada sebuah array
	public static int calculateTotalValue(int[] arrValue) {
		int total = 0;
		//Lanjutkan Kodingan disini
		for (int value : arrValue) {
            total += value;
        }
		return total;
	}
	
	//Konversi Harkat ke Nilai
	public static int convertHarkat(String harkat) {
		int value = 0;
		//Lanjutkan Kodingan disini
		    switch (harkat) {
        case "A":
            value = 4;
            break;
        case "B":
            value = 3;
            break;
        case "C":
            value = 2;
            break;
        case "D":
            value = 1;
            break;
        case "E":
            value = 0;
            break;
    }
   		return value;
}
	
	//Menantukan Yudisium
	public static String getYudisium(boolean isPending, double ipk) {
		String statusYudisium = "";
		//Lanjutkan Kodingan disini
		if (isPending || ipk < 2) {
        statusYudisium = "Pending";
        } else if (ipk >= 3.5) {
        statusYudisium = "Cum Laude";
        } else if (ipk >= 2.75 && ipk < 3.5) {
        statusYudisium = "Sangat Memuaskan";
        } else if (ipk >= 2 && ipk < 2.75) {
        statusYudisium = "Memuaskan";
        } else {
        statusYudisium = ""; // Handle other cases if needed
        }
		return statusYudisium;
	}
	
	//Menghitung IPK
	public static double calculateIpk(double totalSks, double totalScore) {
		double ipk = 0;
		//Lanjutkan Kodingan disini
		if (totalSks != 0) {
            ipk = totalScore / totalSks;
        }
		return ipk;
	}
	
	//Print Hasil
	public static void printHasil(double ipk, double totalSks, String statusYudisium, String[] arrModule, String[] arrHarkat) {
		int number =1;
		
		System.out.println("Yudisium: "+statusYudisium);
		System.out.print("IPK: ");
		System.out.printf("%.2f",ipk);
		
		//Lanjutkan kodingan disini
		System.out.println("\nTotal SKS: " + totalSks);
        System.out.println("Total Module: " + arrModule.length);
        for (int i = 0; i < arrModule.length; i++) {
            System.out.println(number + ". " + arrModule[i] + " (" + arrHarkat[i] + ")");
            number++;
        }
	}
	
	//Validasi Pending berdasarkan Nilai Harkat
	public static boolean isPendingValildation(String[] arrHarkat) {
		boolean isPending = false;
		//Lanjutkan kodingan disini
        for (String harkat : arrHarkat) {
        if (harkat.equals("E")) {
            isPending = true;
            break;
        }
    }
    	return isPending;
	}
}

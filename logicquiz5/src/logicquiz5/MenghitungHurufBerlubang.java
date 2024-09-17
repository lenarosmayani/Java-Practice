import java.util.Scanner

public class MenghitungHurufBerlubang {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		String kalimat = input.nextLine();
		
		int jumlahLubang = hitungLubang(kalimat);
		
	// metode untuk menghitung lubang
		
	public static int hitungLubang(String kalimat) {
		int jumlahLubang = 0;
		
		for (int i = 0; i <=50; i++) {
			char huruf = Character.toUpperCase(kalimat.charArt(i));
			
	       if (huruf == 'A' || huruf == 'D' || huruf == 'O'|| huruf == 'P'|| 
	    		   		huruf == 'Q'|| huruf == 'R') {
	    	   jumlahLubang +=1;
	       } else if (huruf == 'B'){
	    	   jumlahLubang +=2;
	       }
		
		}
		
		return jumlahLubang;

	}

}

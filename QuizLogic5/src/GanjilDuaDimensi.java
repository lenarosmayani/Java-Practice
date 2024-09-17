import java.util.Scanner;


public class GanjilDuaDimensi {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Membuat input array 2 dimensi ordo 4x4
		int[][]X= new int[4][4];
		
		for(int i=0; i<4; i++) {
		  for(int j=0; j<4; j++) {
			X[i][j]= input.nextInt();
			}
		}
		int jumlahGanjil = hitungGanjil(X);
		
		System.out.println(jumlahGanjil);	
	}
	// membuat fungsi hitungGanjil
	public static int hitungGanjil(int[][]arr){
		int count = 0;
		for (int[]row:arr) {
		  for (int num:row){
			 if (num%2!=0) {
				 count++;
			 }
		  }
		}
		return count;
	}

}

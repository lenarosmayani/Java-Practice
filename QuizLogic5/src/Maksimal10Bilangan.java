import java.util.Scanner;


public class Maksimal10Bilangan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []X=new int[10];
		
		Scanner input = new Scanner(System.in);
		
		for (int i =0; i<10; i++) {
			X[i]=input.nextInt();
		}
		
		int nilaiMaksimal = cariMaksimal(X);
		
		System.out.println(nilaiMaksimal);
	}
	
	public static int cariMaksimal(int[]X) {
		int maksimal = X[0];
		for (int num : X) {
		 if(num > maksimal) {
			maksimal = num;
		 }
		}
		return maksimal;
	}

}

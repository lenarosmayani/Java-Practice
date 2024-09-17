import java.util.Scanner;

public class latihan {
    public static void main(String args[] ) {
      Scanner input = new Scanner(System.in);
      
      		int [][] x = new int[3][3];
      		
      		for (int i =0; i<3; i++) {
      			for (int j =0; j<3; i++) {
      				x[i][j]=input.nextInt();
      			}
      		}
      		boolean matriksNol = isMatriksNol(x);
      		
    		System.out.println(matriksNol);	
    	}
    	private static boolean isMatriksNol(int[][]arr) {
    		for (int[]row:arr) {
      		  for (int num:row){
      			 if (num ==0) {
      				 return true;
      			 }
      		  }
      		}
      		return false;
      }
}
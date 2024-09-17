import java.util.Scanner;

public class MengurutkanDataInteger {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		int[] bilangan = new int[3];
		
		for (int i = 0; i<3;i++) {
			bilangan[i] = input.nextInt();
		}

		for (int i = 0; i<2; i++) {
			for (int j = 0; i<2; j++) {
			 if (bilangan[j] > bilangan[j+1]) {
				int temp = bilangan[j];
				bilangan[j] = bilangan[j+1];
				bilangan[j+1] = temp;
			 }
		   }
		}
		for (int value : bilangan)
		System.out.println(value + " ");
	}

}

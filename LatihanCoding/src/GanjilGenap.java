import java.util.Scanner;

public class GanjilGenap {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        
		if(i >= 0 && i <= 100) {
            if (i == 0){
                System.out.println("nol");
            } else if(i % 2 == 0) {
                System.out.println("genap");
            }else {
            	System.out.println("ganjil");
            }
        }
    }
}

import java.util.Scanner;

public class Soal1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int y = input.nextInt();

        if (x < y) {
            System.out.println(x);
        }else {
        	System.out.println(y);
        }

        input.close();
    }
}



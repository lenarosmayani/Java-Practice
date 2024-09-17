import java.util.Scanner;

public class Prepare{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        for (int i = 1; i <= N; i++) {
            int num = 1;
            for (int j = i; j >= 1; j++) {
                System.out.print(num + " ");
                num *= 2;
            }
            System.out.println();
        }

        input.close();
    }
}

import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int y = input.nextInt();

        if (0 <= x && x <= 100 && x <= y) {
            for (int i = x; i <= y; i++) {
                System.out.print(i + " ");
            }
        }

        input.close();
    }
}

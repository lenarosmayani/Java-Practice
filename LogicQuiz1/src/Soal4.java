import java.util.Scanner;

public class Soal4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();

        if (0 <= x && x <= 100) {
            if (x % 2 == 0) {
                System.out.println("genap");
            } else {
                System.out.println("ganjil");
            }
        }

        input.close();
    }
}

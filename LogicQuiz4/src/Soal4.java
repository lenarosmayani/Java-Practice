import java.util.Scanner;

public class Soal4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        // Membuat pola
        for (int i = 1; i <= N; i++) {
            // Mencetak '*' sebanyak i kali pada setiap baris
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        input.close();
    }
}

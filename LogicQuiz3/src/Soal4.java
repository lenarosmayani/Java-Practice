import java.util.Scanner;

public class Soal4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Kamus data
        int bilangan;
        int cek = 0; // berisi 1 jika bilangan merupakan kelipatan 3 dan 4, 
                    // berisi 0 jika sebaliknya

        // Algoritma
        bilangan = input.nextInt();

        if (bilangan > 0 && bilangan < 100) {
            if (bilangan % 3 == 0 && bilangan % 4 == 0) {
                cek = 1;
            }
        }

        System.out.println(cek);

        input.close();
    }
}

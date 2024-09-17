import java.util.Scanner;

public class LogicQuiz1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();

        int hasil = 2 * x;

        System.out.println( hasil);

        input.close();
    }
}
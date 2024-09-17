import java.util.Scanner;

public class Soal2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numb1 = input.nextInt();
        int numb2 = input.nextInt();
        int numb3 = input.nextInt();

        int max = Math.max(Math.max(numb1, numb2), numb3);

        System.out.println(max);

        input.close();
    }
}

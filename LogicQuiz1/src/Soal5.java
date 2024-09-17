import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double suhu = input.nextDouble();

        if (suhu >= 0 && suhu <= 100) {
            System.out.println("berwujud cair");
        } else {
            System.out.println("berwujud non cair");
        }

        input.close();
    }
}

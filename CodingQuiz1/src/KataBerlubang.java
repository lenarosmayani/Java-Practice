import java.util.Scanner;

public class KataBerlubang {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membaca input kata
        String kata = input.nextLine();

        // Menghitung jumlah lubang pada kata
        int jumlahLubang = hitungLubang(kata);

        // Menampilkan output
        System.out.println(jumlahLubang);
    }

    public static int hitungLubang(char karakter) {
        // Menggunakan switch untuk menentukan jumlah lubang
        switch (karakter) {
            case 'A': case 'D': case 'O': case 'P': case 'Q': case 'R': 
            case 'a': case 'b': case 'd': case 'e': case 'g': case 'o': case 'p': case 'q':
            case '0': case '4': case '6': case '9':
                return 1;
            case 'B': case '8':
                return 2;
            default:
                return 0;
        }
    }

    public static int hitungLubang(String kata) {
        int totalLubang = 0;

        // Menghitung jumlah lubang pada setiap karakter dalam kata
        for (char karakter : kata.toCharArray()) {
            totalLubang += hitungLubang(karakter);
        }

        return totalLubang;
    }
}

import java.util.Scanner;

public class Soal3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String kalimat = input.nextLine();

        char[] kalimatArray = kalimat.toCharArray();
        ubahKeAlay(kalimatArray);

        System.out.println(kalimatArray);

        input.close();
    }

    private static void ubahKeAlay(char[] karakter) {
        for (int i = 0; i < karakter.length; i++) {
            switch (karakter[i]) {
                case 'A': case 'a': karakter[i] = '4'; break;
                case 'I': case 'i': karakter[i] = '1'; break;
                case 'Z': case 'z': karakter[i] = '2'; break;
                case 'E': case 'e': karakter[i] = '3'; break;
                case 'G': case 'g': karakter[i] = '6'; break;
                case 'J': case 'j': karakter[i] = '7'; break;
                case 'B': case 'b': karakter[i] = '8'; break;
                
            }
        }
    }
}

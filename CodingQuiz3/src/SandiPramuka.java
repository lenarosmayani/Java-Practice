import java.util.Scanner;

public class SandiPramuka {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] sandi = encodeToSandi(input);
        String sandiString = generateSandiString(sandi);

        System.out.println(sandiString);
    }

    private static int[] encodeToSandi(String input) {
        int[] sandi = new int[input.length()];

        for (int i = 0; i < sandi.length; i++) {
            char currentChar = input.charAt(i);
            int sandiNumber = getSandiNumber(currentChar);
            int count = getCount(currentChar);

            StringBuilder sandiString = new StringBuilder();

            for (int j = 0; j < count; j++) {
                sandiString.append(sandiNumber);
            }

            if (sandiString.length() > 0) {
                sandi[i] = Integer.valueOf(sandiString.toString());
            } else {
                sandi[i] = 0;
            }
        }
        return sandi;
    }


    private static int getSandiNumber(char c) {
        switch (c) {
            case 'A': case 'B': case 'C': case 'D':
                return 1;
            case 'E': case 'F': case 'G': case 'H':
                return 2;
            case 'I': case 'J': case 'K': case 'L':
                return 3;
            case 'M': case 'N': case 'O': case 'P':
                return 4;
            case 'Q': case 'R': case 'S': case 'T':
                return 5;
            case 'U': case 'V': case 'W': case 'X':
                return 6;
            case 'Y': case 'Z':
                return 7;
            default:
                return 0;
        }
    }

    private static int getCount(char c) {
        switch (c) {
            case 'A': case 'E': case 'I': case 'M': case 'Q':
            case 'U': case 'Y':
                return 1;
            case 'B': case 'F': case 'J': case 'N': case 'R':
            case 'V': case 'Z':
                return 2;
            case 'C': case 'G': case 'K': case 'O': case 'S':
            case 'W':
                return 3;
            case 'D': case 'H': case 'L': case 'P': case 'T':
            case 'X':
                return 4;
            default:
                return 0;
        }
    }

    private static String generateSandiString(int[] sandi) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sandi.length - 1; i++) {
            sb.append(sandi[i]);

            char charIndexAwal = String.valueOf(sandi[i]).charAt(0);
            char charIndexSelanjutnya = String.valueOf(sandi[i + 1]).charAt(0);

            if (charIndexAwal == charIndexSelanjutnya) {
                sb.append('-');
            }
        }

        sb.append(sandi[sandi.length - 1]);

        return sb.toString();
    }
}

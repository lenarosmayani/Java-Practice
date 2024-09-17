import java.util.Scanner;

public class PenjumlahanMatriks {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriksA = new int[3][3];
        int[][] matriksB = new int[3][3];
        int[][] jumlahMatriks = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriksA[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriksB[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jumlahMatriks[i][j] = matriksA[i][j] + matriksB[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(jumlahMatriks[i][j] + " ");
            }
            System.out.println();
        }

        input.close();
    }
}

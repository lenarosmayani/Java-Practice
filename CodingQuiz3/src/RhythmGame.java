import java.util.Scanner;

public class RhythmGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Nama Pemain
        System.out.println("Masukan Nama Pemain: ");
        String playerName = scanner.nextLine();

        // Input jumlah poin "Perfect", "Great", "Good", dan "Miss"
        System.out.println("Skor Perfect: ");
        int perfectCount = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Skor Great: ");
        int greatCount = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Skor Good: ");
        int goodCount = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Skor Miss: ");
        int missCount = Integer.parseInt(scanner.nextLine());

        // Hitung skor dan peringkat
        int totalScore = calculateScore(perfectCount, greatCount, goodCount, missCount);
        int totalMaxScore = calculateTotalMaxScore(100, 0, 0);  // Maksimum 100 Perfect = 10000 poin
        String rank = getRank((double) totalScore / totalMaxScore);

        // Tampilkan hasil
        System.out.println("Hasil: ");
        printResult(playerName, totalScore, totalMaxScore, rank);
    }

    // Function untuk menghitung skor berdasarkan jumlah ketepatan
    public static int calculateScore(int perfectCount, int greatCount, int goodCount, int missCount) {
        return (perfectCount * 100) + (greatCount * 80) + (goodCount * 60) + (missCount * 0);
    }

    // Function untuk menghitung total maksimal skor yang bisa dicapai pada lagu tertentu.
    public static int calculateTotalMaxScore(int maxPerfect, int maxGreat, int maxGood) {
        return (maxPerfect * 100) + (maxGreat * 80) + (maxGood * 60);
    }

    // Function untuk mendapatkan peringkat berdasarkan persentase skor yang diperoleh
    public static String getRank(double percentage) {
        if (percentage >= 0.9) {
            return "S (Super)";
        } else if (percentage >= 0.8) {
            return "A (Amazing)";
        } else if (percentage >= 0.7) {
            return "B (Brilliant)";
        } else if (percentage >= 0.6) {
            return "C (Cool)";
        } else {
            return "D (Decent)";
        }
    }

    // Function untuk menampilkan hasil perhitungan skor dan peringkat pemain
    public static void printResult(String playerName, int totalScore, int totalMaxScore, String rank) {
        System.out.println(" Total Skor" + totalScore);
        System.out.println(playerName + " peringkat " + rank);
    }
}

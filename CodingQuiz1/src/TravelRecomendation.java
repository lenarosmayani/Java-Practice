import java.util.Scanner;

public class TravelRecomendation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca input: jumlah orang (p), lama menginap (d), dan budget (b)
        int p = scanner.nextInt();
        int d = scanner.nextInt();
        int b = scanner.nextInt();

        // Menampilkan rekomendasi destinasi dan total budget
        String[] destinations = {"Lombok", "Bangkok", "Singapore", "Tokyo"};
        int[] transportationCosts = {2170000, 3780000, 1200000, 4760000};
        int[] hotelCostsPerDay = {125000, 155000, 170000, 170000};
        int[] foodCostsPerDay = {75000, 55000, 85000, 105000};
        int[] shoppingCostsPerPerson = {250000, 300000, 360000, 325000};

        // Menghitung total cost untuk setiap destinasi
        int[] totalCost = calculateTotalCost(p, d, destinations, transportationCosts, hotelCostsPerDay, foodCostsPerDay, shoppingCostsPerPerson);

        // Mencari destinasi dengan budget paling mendekati
        int closestBudgetIndex = findClosestIndex(totalCost, b);

        // Output
        if (closestBudgetIndex != -1) {
            if (b >= totalCost[closestBudgetIndex]) {
                String destination = destinations[closestBudgetIndex];
                int recommendedBudget = totalCost[closestBudgetIndex];
                System.out.println(destination + " " + recommendedBudget);
            } else {
                System.out.println("Need more budget");
            }
        }
    }

    public static int[] calculateTotalCost(int p, int d, String[] destinations, int[] transportationCosts,
                                           int[] hotelCostsPerDay, int[] foodCostsPerDay, int[] shoppingCostsPerPerson) {
        int[] totalCost = new int[transportationCosts.length];
        for (int i = 0; i < totalCost.length; i++) {
            totalCost[i] = p * (transportationCosts[i] + shoppingCostsPerPerson[i]) + p * d * (hotelCostsPerDay[i] + foodCostsPerDay[i]);
        }
        return totalCost;
    }

    public static int findClosestIndex(int[] totalCost, int b) {
        int closestBudgetIndex = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < totalCost.length; i++) {
            int difference = Math.abs(totalCost[i] - b);

            if (difference < minDiff) {
                minDiff = difference;
                closestBudgetIndex = i;
            }
        }

        return closestBudgetIndex;
    }
}

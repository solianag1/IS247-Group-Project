import java.util.Scanner;
import java.util.Random;

/**
 * The SavingsCalculator class provides a utility method to calculate
 * how many days it will take to reach a savings goal using daily saving amounts.
 * This method uses recursion to simulate accumulation over time.
 *
 */
public class SavingsCalculator {

    /**
     * Recursively calculates days needed to reach the savings goal.
     * @param goal The target amount
     * @param dailyAmount How much is saved each day
     * @return Number of days needed
     */
    public static int calculateDays(double goal, double dailyAmount) {
        if (goal <= 0) {
            return 0;
        } else {
            return 1 + calculateDays(goal - dailyAmount, dailyAmount);
        }
    }

    /**
     * Starts the calculator by simulating a random daily savings amount.
     */
    public static void startCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your savings goal: $");
        double goal = scanner.nextDouble();

        Random random = new Random();
        double daily = 5 + random.nextDouble() * 15; // random between $5 and $20
        System.out.printf("Simulated daily savings: $%.2f%n", daily);

        int days = calculateDays(goal, daily);
        System.out.println("It will take about " + days + " days to reach your goal.");
    }
}

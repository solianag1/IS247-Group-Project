/**
 * The SavingsCalculator class provides a utility method to calculate
 * how many days it will take to reach a savings goal using daily saving amounts.
 * This method uses recursion to simulate accumulation over time.
 *
 */
public class SavingsCalculator {

    /**
     * Calculates how many days it takes to reach the savings goal.
     * @param dailyAmount The amount saved per day.
     * @param savingsGoal The total goal to reach.
     * @return Number of days to reach the goal.
     * @throws MyCustomException if the input values are invalid.
     */
    public static int calculateDaysToGoal(double dailyAmount, double savingsGoal) throws MyCustomException {
        if (dailyAmount <= 0 || savingsGoal <= 0) {
            throw new MyCustomException("Amounts must be greater than zero.");
        }
        // Use a helper method to track days
        return calculateRecursive(dailyAmount, savingsGoal, 0);
    }

    // Private helper method that uses recursion
    private static int calculateRecursive(double dailyAmount, double savingsGoal, int days) {
        if (dailyAmount * days >= savingsGoal) {
            return days;
        }
        return calculateRecursive(dailyAmount, savingsGoal, days + 1);
    }
}

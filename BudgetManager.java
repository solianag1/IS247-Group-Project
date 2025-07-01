
/**
 * The BudgetManager class tracks a monthly spending budget,
 * records expenses, and alerts the user when they approach or
 * exceed their budget limit.
 */
public class BudgetManager {
    private double monthlyBudget;
    private double totalSpent;

    /**
     * Constructs a BudgetManager with a specified monthly budget.
     *
     * @param monthlyBudget the maximum spendable amount for the month; must be > 0
     * @throws IllegalArgumentException if monthlyBudget is not greater than zero
     */
    public BudgetManager(double monthlyBudget) {
        if (monthlyBudget <= 0) {
            throw new IllegalArgumentException("Budget must be greater than zero.");
        }
        this.monthlyBudget = monthlyBudget;
        this.totalSpent = 0;
    }

    /**
     * Records an expense against the monthly budget.
     * Alerts if under $50 remaining or if budget limit is reached.
     *
     * @param amount the expense amount; must be > 0
     * @throws MyCustomException if amount ≤ 0 or if remaining budget is zero or insufficient
     */
    public void spend(double amount) throws MyCustomException {
        if (amount <= 0) {
            throw new MyCustomException("Expense amount must be greater than zero.");
        }
        double remainingBefore = monthlyBudget - totalSpent;
        if (remainingBefore <= 0) {
            throw new MyCustomException("You have no remaining budget.");
        }
        if (amount > remainingBefore) {
            throw new MyCustomException(
                    "Expense exceeds remaining budget of $" + remainingBefore
            );
        }

        totalSpent += amount;
        double remainingAfter = monthlyBudget - totalSpent;

        System.out.printf("Recorded $%.2f expense. Remaining budget: $%.2f%n", amount, remainingAfter);

        // Warn when low on budget
        if (remainingAfter > 0 && remainingAfter <= 50) {
            System.out.println("Warning: Only $" + remainingAfter + " left until you hit your budget!");
        }

        // Notify when budget is fully used
        if (remainingAfter == 0) {
            System.out.println("You have reached your monthly budget limit.");
        }
    }

    /**
     * Returns the total amount spent so far.
     *
     * @return total spent
     */
    public double getTotalSpent() {
        return totalSpent;
    }

    /**
     * Returns the remaining budget.
     *
     * @return remaining budget amount
     */
    public double getRemainingBudget() {
        return monthlyBudget - totalSpent;
    }

    /**
     * Displays a summary of the original budget, total spent,
     * and the remaining amount.
     */
    public void displaySummary() {
        System.out.println("\n--- Budget Summary ---");
        System.out.printf("Original budget: $%.2f%n", monthlyBudget);
        System.out.printf("Total spent:     $%.2f%n", totalSpent);
        System.out.printf("Remaining:       $%.2f%n", getRemainingBudget());
    }
}

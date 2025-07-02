/**
 * BudgetManager is the main class used to manage the user's budget, income, expenses, and savings.
 * It provides methods to add income, track spending, set savings goals, and check alerts for low budget.
 * This class uses exception handling to manage invalid inputs like negative or zero values.
 */
public class BudgetManager extends FinancialAccount implements Trackable {
    private double monthlyBudget;
    private double totalSpent;
    private double totalIncome;
    private double savingsGoal;
    private double totalSaved;
 /**
     * Constructor that sets the monthly budget. Throws an exception if the budget is invalid.
     */
    public BudgetManager(double monthlyBudget) {
        if (monthlyBudget <= 0) {
            throw new IllegalArgumentException("Budget must be greater than zero.");
        }
        this.monthlyBudget = monthlyBudget;
        this.totalSpent = 0;
        this.totalIncome = 0;
        this.savingsGoal = 0;
        this.totalSaved = 0;
    }
  
    /**
     * Adds income to the total. Throws exception if input is invalid.
     */
    public void addIncome(double amount) throws MyCustomException {
        if (amount <= 0) {
            throw new MyCustomException("Income must be greater than zero.");
        }
        totalIncome += amount;
        System.out.printf("Added $%.2f income. Total income: $%.2f%n", amount, totalIncome);
    }

      /**
     * Spends money and increases the total spent. Warns if close to or over budget.
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

        if (remainingAfter > 0 && remainingAfter <= 50) {
            System.out.println("Warning: Only $" + remainingAfter + " left until you hit your budget.");
        } else if (remainingAfter == 0) {
            System.out.println("You have reached your monthly budget limit.");
        }
    }
 
    /**
     * Sets the user’s savings goal.
     */
    public void setSavingsGoal(double goal) throws MyCustomException {
        if (goal <= 0) {
            throw new MyCustomException("Savings goal must be greater than zero.");
        }
        savingsGoal = goal;
        totalSaved = 0; // reset progress
        System.out.println("Savings goal set to $" + goal);
    }

    /**
     * Adds money to savings.
     */
    public void addToSavings(double amount) throws MyCustomException {
        if (amount <= 0) {
            throw new MyCustomException("Saved amount must be greater than zero.");
        }
        totalSaved += amount;
        System.out.printf("Saved $%.2f. Total saved: $%.2f%n", amount, totalSaved);

        if (totalSaved >= savingsGoal && savingsGoal > 0) {
            System.out.println("Congratulations! You've reached your savings goal!");
        } else if (savingsGoal > 0) {
            System.out.printf("You are $%.2f away from your savings goal.%n", savingsGoal - totalSaved);
        }
    }

    /**
     * Displays a summary of budget, spending, income, and savings.
     */
    public void displaySummary() {
        System.out.println("\n--- Budget Summary ---");
        System.out.printf("Original budget:    $%.2f%n", monthlyBudget);
        System.out.printf("Total income:       $%.2f%n", totalIncome);
        System.out.printf("Total spent:        $%.2f%n", totalSpent);
        System.out.printf("Remaining budget:   $%.2f%n", (monthlyBudget - totalSpent));
        System.out.printf("Available earnings: $%.2f%n", (totalIncome - totalSpent));
        System.out.printf("Savings goal:       $%.2f%n", savingsGoal);
        System.out.printf("Total saved:        $%.2f%n", totalSaved);
    }
}


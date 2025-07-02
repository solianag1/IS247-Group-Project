/**
 * Tracks a savings goal and shows progress.
 * Implements Trackable so it can be tracked like an account.
 */
public class GoalTracker implements Trackable {
    private String goalName;
    private double targetAmount;
    private double currentAmount;

    public GoalTracker(String goalName, double targetAmount) {
        this.goalName = goalName;
        this.targetAmount = targetAmount;
        this.currentAmount = 0;
    }

    public void addToGoal(double amount) {
        currentAmount += amount;
        System.out.println(amount + " added to " + goalName);
    }

    @Override
    public void track() {
        double percent = (currentAmount / targetAmount) * 100;
        System.out.printf("Goal: %s | Progress: $%.2f / $%.2f (%.1f%%)\n", goalName, currentAmount, targetAmount, percent);
    }
}


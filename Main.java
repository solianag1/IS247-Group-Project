import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BudgetManager budgetMgr;

        // 1) Ask for initial budget
        while (true) {
            System.out.print("Enter your monthly budget amount: $");
            try {
                double budget = Double.parseDouble(scanner.nextLine());
                budgetMgr = new BudgetManager(budget);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // 2) Main loop
        while (true) {
            System.out.println("\nChoose: [s]pend  [v]iew summary  [c]alculate savings days  [q]uit");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("q")) {
                System.out.println("Goodbye! Final summary:");
                budgetMgr.displaySummary();
                break;
            }

            switch (choice) {
                case "s":
                    System.out.print("Enter expense amount: $");
                    try {
                        double amt = Double.parseDouble(scanner.nextLine());
                        budgetMgr.spend(amt);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    } catch (MyCustomException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "v":
                    budgetMgr.displaySummary();
                    break;

                case "c":
                    try {
                        System.out.print("Enter daily saving amount: $");
                        double daily = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter savings goal amount: $");
                        double goal = Double.parseDouble(scanner.nextLine());
                        int days = SavingsCalculator.calculateDaysToGoal(daily, goal);
                        System.out.println("You will reach your goal in " + days + " days.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter valid numbers.");
                    } catch (MyCustomException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice—please use s, v, c, or q.");
            }
        }

        scanner.close();
    }
}



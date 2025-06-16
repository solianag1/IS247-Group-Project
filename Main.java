// Name: Kate Abunassar
// Email: Katea1@umbc.edu

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(500);

        while (true) {
            System.out.println("\nEnter 'd' to deposit, 'w' to withdraw, or 'q' to quit:");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                System.out.println("Exiting program. Final balance: " + account.getBalance());
                break;
            }

            try {
                if (choice.equalsIgnoreCase("d")) {
                    System.out.print("Enter deposit amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.deposit(amount);
                } else if (choice.equalsIgnoreCase("w")) {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.withdraw(amount);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (MyCustomException e) {
                System.out.println("Banking Exception: " + e.getMessage());

                if (e.getMessage().toLowerCase().contains("insufficient funds")) {
                    System.out.println("Please enter a valid withdrawal amount.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        scanner.close();
    }
}

/**
 * Represents a user's financial account.
 * You can deposit, withdraw, and track the balance.
 */
public class FinancialAccount implements Trackable {
    private String accountName;
    private double balance;

    public FinancialAccount(String accountName, double startingBalance) {
        this.accountName = accountName;
        this.balance = startingBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("$" + amount + " deposited to " + accountName);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn from " + accountName);
        } else {
            System.out.println("Insufficient funds in " + accountName);
        }
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void track() {
        System.out.printf("Account: %s | Balance: $%.2f\n", accountName, balance);
    }
}

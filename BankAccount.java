
public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws MyCustomException {
        if (amount <= 0) {
            throw new MyCustomException("Deposit amount must be greater than zero.");
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) throws MyCustomException {
        if (amount > balance) {
            throw new MyCustomException("Insufficient funds. Attempted to withdraw: " + amount);

        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

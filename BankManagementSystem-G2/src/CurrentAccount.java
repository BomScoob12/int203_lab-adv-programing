public class CurrentAccount implements Account {

    private final int accountNumber;
    private final String accountName;
    private double balance;
    private double minimum;
    private final String accountType = "Current Account";

    public CurrentAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.minimum = 0;
    }

    @Override
    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public String getAccountName() {
        return this.accountName;
    }

    public double getMinimum() {
        return this.minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) return;
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;
        this.balance -= amount;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public String getAccountType() {
        return this.accountType;
    }
}

public interface Account {
    void deposit(double amount);

    void withdraw(double amount);

    double getBalance();

    String getAccountType();

    int getAccountNumber();

    String getAccountName();
}

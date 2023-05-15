public class Account {
    private final int accountNumber;
    private final String accountName;
    private double balance;


    public Account(int accountNumber, String accountName, double balance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount <= 0) return;
        this.balance += amount;
    }
    public void withdraw(double amount){
        if (amount <= 0 || amount > balance) return;
        this.balance -= amount;
    }
    public double getBalance(){
        return balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public String getAccountName(){
        return accountName;
    }
}

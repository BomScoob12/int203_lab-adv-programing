public class FixedDepositAccount implements Account{

    private final int accountNumber;
    private final String accountName;
    private double balance;
    private final String accountType = "Fixed Deposit Account";

    public FixedDepositAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    @Override
    public int getAccountNumber(){
        return this.accountNumber;
    }
    @Override
    public String getAccountName(){
        return this.accountName;
    }
    @Override
    public void deposit(double amount){
        if(amount <= 0) return;
        this.balance += amount;
    }
    @Override
    public void withdraw(double amount){
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

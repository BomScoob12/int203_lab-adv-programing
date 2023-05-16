import java.sql.*;

public class Bank {
    private final String bankName;
    private final String branch;
    private final int bankID;

    Connection connection = BankingConnection.connect();

    public Bank() {
        bankName = "Bank";
        branch = "Unknowns";
        bankID = 0;
    }

    public Bank(String name, String branch, int bankID) {
        this.bankName = name;
        this.branch = branch;
        this.bankID = bankID;
    }

    public void listAccount() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM accounts";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                System.out.println(result.getInt(1) +
                        " " + result.getString(2) +
                        " " + result.getDouble(3) +
                        " " + result.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void openAccount(Account account) {
        String sql = "INSERT INTO accounts (accNumber, accName, accBalance, accType) "
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setString(4, account.getAccountType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeAccount(Account account) {
        try {
            String sql = "DELETE FROM accounts WHERE accNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getAccountNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void depositMoney(Account account, double amount) {
        account.deposit(amount);
        String sql = "UPDATE accounts SET accBalance = ? WHERE accNumber = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void withdrawMoney(Account account, double amount) {
        account.withdraw(amount);
        String sql = "UPDATE accounts SET accBalance = ? WHERE accNumber = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account getAccount(int accountNumber, String accountType) {
        String sql = "SELECT * FROM accounts WHERE accNumber = ? AND accType = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountNumber);
            preparedStatement.setString(2, accountType);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            switch (accountType) {
                case "Current Account" -> {
                    return new CurrentAccount(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
                }
                case "Fixed Deposit Account" -> {
                    return new FixedDepositAccount(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
                }
                case "Saving Account" -> {
                    return new SavingAccount(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBankName() {
        return bankName;
    }

    public String getBranch() {
        return branch;
    }

    public int getBankID() {
        return bankID;
    }
}

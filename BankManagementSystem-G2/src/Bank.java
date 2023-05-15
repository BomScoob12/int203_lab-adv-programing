import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Bank {
    private final String bankName;
    private final String branch;
    private final int bankID;

    Connection connection = BankingConnection.connect();

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
//            result.next();
//            System.out.println(result.getString(1)+result.getString(2));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void openAccount(int accountNumber, String accountName, double balance) {
        if (accountNumber <= 0 || accountName.isBlank()) return;
        String sql = "INSERT INTO accounts (accNumber, accName, accBalance) "
                + "VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountNumber);
            preparedStatement.setString(2, accountName);
            preparedStatement.setDouble(3, balance);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeAccount(int accountNumber) {
        try {
            String sql = "DELETE FROM accounts WHERE accNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,accountNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void depositMoney(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
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

    public void withdrawMoney(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
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

    public Account getAccount(int accountNumber) {
        String sql = "SELECT * FROM accounts WHERE accNumber = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Account(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

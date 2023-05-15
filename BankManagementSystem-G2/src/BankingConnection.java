import java.sql.*;

public class BankingConnection {
//    public static void main(String[] args) {
//        connect();
//    }
    public static Connection connect(){
        String URL = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        final String password = "BomScoob112004@";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL,username,password);
            System.out.println(connection);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

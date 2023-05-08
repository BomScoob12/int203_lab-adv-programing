package dbprogramming2;

import java.sql.SQLException;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class Lab13 {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "mysql@sit";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "UPDATE students SET email =? WHERE stdID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "sql@email.com");
            preparedStatement.setString(2, "11111");
            
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e){
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

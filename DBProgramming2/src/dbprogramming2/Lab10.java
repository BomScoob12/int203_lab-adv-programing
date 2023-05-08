package dbprogramming2;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class Lab10 {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "mysql@sit";
        try{
            // Connection connect = DriverManager.getConnection(url, username, password);
            // Statement statement = connect.createStatement();
            // ResultSet result = statement.executeQuery("SQL command");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "UPDATE students SET email = 'email@gmail.com' WHERE stdID = 11111";
            DriverManager.getConnection(url, username, password).createStatement().execute(sql);
        } catch (SQLException e){
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e){
            Logger.getLogger(Lab8.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

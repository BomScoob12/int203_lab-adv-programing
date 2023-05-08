
package dbprogramming2;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBProgramming2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variable
        String URL = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        final String password = "mysql@sit";
        
        //load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            
            //connection to driver
            Connection connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Connected database");
            
            //get stagement for execute sql command
            Statement statement = connection.createStatement();
            String sqlCmd = "select * from students";
            //execute sql command
            ResultSet results = statement.executeQuery(sqlCmd);
            //sql keep in result[Set] and loop to gat data

            //So you can do it in one statement
            ResultSet results2 = DriverManager.getConnection(URL,username,password).createStatement().executeQuery(sqlCmd);
            
            while(results.next()){
                //getString(x) method  "x" is column
                System.out.println(results.getInt(1) + " " +
                        results.getString(2) + " " + 
                        results.getString(3));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

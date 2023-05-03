/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbprogramming2;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author BomScoob
 */
public class DBProgramming2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variable
        String URL = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "BomScoob112004@";
        
        //load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            
            //connection to driver
            Connection connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Connected database");
            
            //get stagement
            Statement statement = connection.createStatement();
            String sql = "select * from students";
            //execute sql command
            ResultSet results = statement.executeQuery(sql);
            //sql keep in result and loop to gat data
            
            while(results.next()){
                //getString(x) method  "x" is column
                System.out.println(results.getString(1) + " " +
                        results.getString(2) + " " + 
                        results.getString(3));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

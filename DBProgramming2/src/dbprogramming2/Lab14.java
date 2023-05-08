package dbprogramming2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;

public class Lab14 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "mysql@sit";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            DatabaseMetaData meta = connection.getMetaData();

            System.out.println("Database URL: " + meta.getURL());
            System.out.println("Database Username: " + meta.getUserName());
            System.out.println("Database productname: " + meta.getDatabaseProductName());
            System.out.println("Database product version : " + meta.getDatabaseProductVersion());
            System.out.println("JDBC driver name: " + meta.getDriverName());
            System.out.println("JDBC driver version: " + meta.getDriverVersion());
            System.out.println("JDBC driver major version: " + meta.getDriverMajorVersion());
            System.out.println("JDBC driver minor version: " + meta.getDriverMinorVersion());
            System.out.println("Max number of connections: " + meta.getMaxConnections());
            System.out.println("MaxTableNameLength: " + meta.getMaxTableNameLength());
            System.out.println("MaxColumnsInTable: " + meta.getMaxColumnsInTable());
            
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

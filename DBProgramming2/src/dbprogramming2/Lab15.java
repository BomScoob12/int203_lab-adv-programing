package dbprogramming2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class Lab15 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "mysql@sit";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            String sql = "Select * from students";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsMeta = rs.getMetaData();

            for (int i = 1; i< rsMeta.getColumnCount(); i++){
                System.out.printf("%s\t", rsMeta.getColumnName(i));
            } System.out.println();
            while(rs.next()){
                for(int i = 1; i< rsMeta.getColumnCount(); i++){
                    System.out.printf("%s\t",rs.getString(i));
                }
                System.out.println();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

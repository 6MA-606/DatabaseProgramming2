package dbprogramming2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dbprogramming2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "140104";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected...");
            Statement statement = connection.createStatement();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbprogramming2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbprogramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

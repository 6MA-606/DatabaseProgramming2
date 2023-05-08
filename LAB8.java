package dbprogramming2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB8 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "140104";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + 
                                resultSet.getString(2) + " " + 
                                resultSet.getString(3) + " " + 
                                resultSet.getString(4) + " " + 
                                resultSet.getString(5));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

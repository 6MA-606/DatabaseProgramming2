package dbprogramming2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB11 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "140104";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM student WHERE studentID = 651084";
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB11.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

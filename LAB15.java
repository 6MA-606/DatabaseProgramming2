package dbprogramming2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB15 {
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
            ResultSetMetaData rsMetaData = resultSet.getMetaData();
            
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
                System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    System.out.printf("%-12s\t", resultSet.getObject(i));
                }
                System.out.println();
            }
            connection.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB15.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB15.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

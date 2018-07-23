package DSP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionToDatabase {
    // Makes the connection to the database, 
    // You need to call this function before any SQL commands
    public static Connection connectToDatabase() throws ClassNotFoundException{

            Connection connection = null;
            try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String connectionURL = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false";
                    connection = DriverManager.getConnection(connectionURL, "root", "root1");
                    System.out.println("Here");
            }
            catch(SQLException e) {
                    e.printStackTrace();
            }
            return connection;
    }
    
    /*
        Connection connection = connectToDatabase();
        String query1 = "SELECT * FROM mydb.revisionlog";
        Statement stst = connection.createStatement();
        ResultSet fullRevisionLog = stst.executeQuery(query1);
    */
}

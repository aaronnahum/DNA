
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;

import javafx.event.ActionEvent;


//import com.mysql.jdbc.Connection;

public class test {
	

	public static void establishJDBC() throws ClassNotFoundException {
		
		// New connection
		java.sql.Connection connection = null;
		
		try {
			// access driver from jar file
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionURL = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false";
			connection = DriverManager.getConnection(connectionURL, "root", "root1");
			
			String query = "SELECT * FROM mydb.revision_log";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

		//	Statement statement = connection.createStatement();
			
		//	statement.executeUpdate("SELECT * FROM revisionlog.revisionlog");
			while (result.next()) {
				System.out.println(result.getInt("REVISION_ID")); 	
			}
			
			String sql = "INSERT INTO revision_log "
					+ " (REVISION_ID, DATE, PROJECT_LEAD, CATEGORY, DESCRIPTION, CODE)"
					+ "VALUES ('20', '2018-11-09', 'Aaron', '22', '17', '5')";
			
			statement.executeUpdate(sql);
			
			System.out.println("Insert complete.");
					
			
			connection.close();
			
			
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	void actionPerformed(ActionEvent e) {
		//try {
			//theQuery
		//}
	}

	public static void main(String[] args) {
		try {
			establishJDBC();	

		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
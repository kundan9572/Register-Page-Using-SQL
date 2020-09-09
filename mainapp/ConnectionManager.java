package mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		// Register the driver class 
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// Create the Connection Object 
		
		Connection con = null;
		
		// URL to connect with the database 
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "kundan123");
		
		if(con != null) {
			System.out.println("Connection Established");
		}
		else
			System.out.println("Connection not established");
		
		
		return con ;
		
		
		
	}

}

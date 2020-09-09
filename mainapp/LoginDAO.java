package mainapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	
	public  boolean validate(LoginPojo loginpojo) throws ClassNotFoundException, SQLException {
		
		String username = loginpojo.getUsername();
		String password =loginpojo.getPassword();
		
	
		
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery(" SELECT * from USERDETAILS");
		
		while( rs.next())
		{
		//	System.out.println("Username " + rs.getString("USERNAME"));
			
			if(username.equals(rs.getString("username"))) {
				
				if(password.equals(rs.getString("password")))
				{
					//con.getConnection().close();
					return true;
				}
			}
		
		}
		
		//con.getConnection().close();
		return false;

		
		
	}

}

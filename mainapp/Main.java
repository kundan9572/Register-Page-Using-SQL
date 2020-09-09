package mainapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Enter your choice: ");
		System.out.println("Register");
		System.out.println("Login");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = Integer.parseInt(br.readLine());
		
		
		// objects 
		
		RegisterPojo registerpojo = new RegisterPojo();
		RegisterDAO registerdao = new RegisterDAO();
		
		LoginPojo loginpojo = new LoginPojo();
		LoginDAO	logindao = new LoginDAO();
		
		switch(choice)
		{
		case 1 : 	System.out.println("Enter the First Name : ");
					String firstname = br.readLine();
					System.out.println("Enter the Last Name : ");
					String lastname = br.readLine();
					System.out.println("Enter the Username : ");
					String username = br.readLine();
					System.out.println("Enter the Password : ");
					String password = br.readLine();
					System.out.println("Enter the Email ID : ");
					String email = br.readLine();
					registerpojo.setFirstname(firstname);
					registerpojo.setLastname(lastname);
					registerpojo.setUsername(username);
					registerpojo.setPassword(password);
					registerpojo.setEmail(email);
					
					registerdao.addUser(registerpojo);
					break;
		
		case 2 : 	System.out.println("Enter the Username : ");
					String name = br.readLine();
					System.out.println("Enter the Password : ");
					String pass = br.readLine();
					loginpojo.setUsername(name);
					
					loginpojo.setPassword(pass);
					
					if(logindao.validate(loginpojo) == true)
					{
						Register register = new Register();
						register.display();
					}
					else
					{
						System.out.println("Incorrect Username or Password");
					}
					break;
		
		default : System.out.println("Invalid Choice");
					System.exit(0);
		
		
		}
	}

}

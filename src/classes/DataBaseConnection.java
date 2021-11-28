package classes;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class DataBaseConnection {
	
//Verify DB entry after submitting the form using JDBC connection
	
	public void database() throws SQLException 
	{
		final String JDBC_DRIVER = "com.mysql.jdc.Driver";
		final String DB_URL = "jdbc:mysql://13.233.35.41:3306/dummy";
		
		
// dummy credentials
		
		final String user = "dbuser"; 
		final String pass = "dbPass";
		
		
		Connection con = null;
		
		java.sql.Statement stmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(DB_URL, user, pass);
			
			stmt = con.createStatement();
			
			String sql = "SELECT email_sent.value FROM email_trigger_table WHERE email_sent.value = ?";
			ResultSet executeQuery = stmt.executeQuery(sql);

//Verify Email is triggered or not after submitting the form using assertion on DB considering an email trigger column as email_sent
			
			while(executeQuery.next()) 
			{
				String value = executeQuery.getString("email_sent");
				
				Assert.assertTrue(value.contains("True"), "**[ASSERT FAILED]: Email sent not sent vale is not true");
				System.out.println("**[ASSERT PASSED]: Email sent not sent vale is true");
			}
			
			executeQuery.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	  
	    
}

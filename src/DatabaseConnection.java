/**
 * this class is for conneting database
 * the driver manager path is declared
 */

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;

public class DatabaseConnection
{
	
		Connection conn = null;
		public static Connection dbConnector()
		{
		try
		{


			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","Vapor_Clouds","123");
			return conn;
	
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Cannot connect to database.");
			return null;
		}
		
	}
}

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection = null;
	
	public static Connection myConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end try1
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_c_epms", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
			
		}//end try2
		//System.out.println(connection);
		return connection;
		
	}//end myConnection

}
package login.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DBConnection;
import login.pojo.EmployeePOJO;
import login.pojo.LoginPOJO;

public class EmployeeDAO {
	
	
	EmployeePOJO email = new EmployeePOJO();
	
	static Connection con = null;
	
	public void sendEmail(int empID){
		con = DBConnection.myConnection();

		Statement st;
		try {
			st = con.createStatement();
			
			String str = String.format("select empEmail from employee where empID = '%d'", empID);

			ResultSet rs = st.executeQuery(str);
			

			if (rs.next()) {
				System.out.println("Email is sent to " + rs.getString(1) + "\n");
			} else {
				System.out.println("no such email" + "\n");
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
}

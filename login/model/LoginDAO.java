package login.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DBConnection;
import login.pojo.EmployeePOJO;
import login.pojo.LoginPOJO;

public class LoginDAO {

	LoginPOJO login = new LoginPOJO();

	static Connection con = null;
	// Statement st = null;
	// ResultSet rs = null;
	// PreparedStatement ps = null;

	public boolean isValid(LoginPOJO login) throws SQLException, NoSuchAlgorithmException {
		boolean b = false;
		String password;
		con = DBConnection.myConnection();

		Statement st = con.createStatement();
		PreparedStatement ps = null;
		String str = String.format("select password, empID, counter, isLocked from login where userName = '%s'",
				login.getUserName());
		ResultSet rs = st.executeQuery(str);

		if (rs.next()) {// result set is not null..user exists in database
			if (rs.getBoolean(4)) {
				System.out.println("Account is Locked");
				EmployeeDAO empdao = new EmployeeDAO();
				empdao.sendEmail(rs.getInt(2));
			} else {

				password = hashString(login.getPassword());

				if (password.equals(rs.getString(1))) {
					b = true;

				} else {
					System.out.println("Username and password do not match.");
					String dbQuery = "update login set counter = ?, isLocked = ? where userName = ?";
					int counter = rs.getInt(3) + 1;
					ps = con.prepareStatement(dbQuery);

					if (counter == 3) {
						System.out.println("Account Locked");
						counter = 0;
						ps.setBoolean(2, true);
					} else {
						ps.setBoolean(2, false);
					}

					ps.setInt(1, counter);
					ps.setString(3, login.getUserName());
					ps.executeUpdate();
				}
			}

		} else { // result set is null
			System.out.println("Username does not exist.");
		}

		con.close();
		return b;

	}// end isValid

	public String getRole(LoginPOJO login) {

		// String username, password;

		con = DBConnection.myConnection();

		Statement st;
		String userType = null;
		try {
			st = con.createStatement();
			String str = String.format("select empID, userType from login where userName = '%s'", login.getUserName());
			ResultSet rs = st.executeQuery(str);
			if (rs.next()) {
				userType = rs.getString(2);

				if (userType.equals("E")) {
					login.setEmpID(rs.getInt(1));
				}
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userType;

	}

	public boolean createNewLogin(LoginPOJO login) throws SQLException {

		con = DBConnection.myConnection();

		try {
			// String dbQuery = "insert into login values (default, ?, ?, ?);";
			String dbQuery = "insert into login (username, password, userType) values (?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(dbQuery);
			ps.setString(1, login.getUserName());
			ps.setString(2, hashString(login.getPassword()));
			ps.setString(3, "E");

			if (ps.executeUpdate() == 1) {
				System.out.println("Account Created.");
			} else {
				System.out.println("Error, please try again.");
			}

			// } catch (NoSuchAlgorithmException e) {
			// e.printStackTrace();
			// return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		return true;
	}

	public boolean isValidEmail(String email) {
		con = DBConnection.myConnection();
		boolean isValid = false;
		Statement st;
		try {
			st = con.createStatement();
			String str = String.format("select * from employee where empEmail = '%s'", email);
			ResultSet rs = st.executeQuery(str);
			
			if(rs.next()){
				System.out.println("Email is sent to " + email);
				isValid = true;
			} else {
				System.out.println("Email doesn't exist");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isValid;
	}

	private String hashString(String str) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();

	}

}

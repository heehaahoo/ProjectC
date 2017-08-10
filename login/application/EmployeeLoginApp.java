package login.application;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.apache.log4j.PropertyConfigurator;

import login.controller.LoginController;

public class EmployeeLoginApp {
	
	

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {

		File log4jfile = new File("C:/batch3/ProjectC/properties/log4j.properties");
		PropertyConfigurator.configure(log4jfile.getAbsolutePath());
		
		System.out.println("Employee Performance Management System.");
		
		LoginController session = new LoginController();
		session.runLoginUI();

	}//end main

}//end employeeloginapp

package login.controller;

import java.util.Scanner;

import login.model.EmployeeDAO;
import login.model.UserInput;
import login.pojo.EmployeePOJO;

public class EmployeeController {

	UserInput io = new UserInput();
	EmployeeDAO empdao = new EmployeeDAO();
	EmployeePOJO empPOJO = new EmployeePOJO();
	
	
	public void runEmployeeUI(int empID){
		
		while(true){
		
		int option= io.runEmployeeMenu();
		
		switch(option){
		case 1:
			break;
		case 2:
		
			break;
		case 3:
			//System.out.println("I chose 3.");
			empdao.sendEmail(empID);
			break;
		case 4:
			break;
		
		}
			
		}
		
	}//end runEmployeeUI()
}

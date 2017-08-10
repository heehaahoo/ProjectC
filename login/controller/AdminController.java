package login.controller;

import java.sql.SQLException;

import login.model.EmployeeDAO;
import login.model.LoginDAO;
import login.model.UserInput;
import login.pojo.EmployeePOJO;
import login.pojo.LoginPOJO;

public class AdminController {

	UserInput io = new UserInput();
	LoginPOJO login = new LoginPOJO(); // to use Employee obj instead at Phase 2
	EmployeeDAO emdao = new EmployeeDAO();
	LoginDAO lgdao = new LoginDAO();
	EmployeePOJO employ = new EmployeePOJO(); 
	
	/* - Called from Login Controller
	 * - switch case for all options
	 * - prints and gets user option for menu
	 * - runs option and get user option again
	 *   until exit is called
	 */
	public void runAdminUI() throws SQLException{
		
		while(true){
			
			int option = io.runAdminMenu();
			
			switch(option){
				case 1: // Upload Test
					System.out.println("Upload Test");
					break;
				case 2: // Create a new account
					createNewEmployee();
					break;
				case 3: // View all employee's performance
					System.out.println("View all employee's performance");
					break;
				case 4: // Log out
					System.out.println("Thank you have a nice day!");
					System.exit(0);
					
					//break;
				default: // Invalid input
					System.out.println("Invalid input.");
					break;
			}
			
		}
		
	}
	
	public void createNewEmployee() throws SQLException{
		System.out.println("************************************\nCreating New Employee");
		login = io.getNewEmployeeInfo(login);
		employ = io.getEmployeeDetail(employ);
		// call employee method and pass the emp pojo
		
		lgdao.createNewLogin(login);
		
	}
	
	
}

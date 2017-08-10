package login.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

import login.application.ApplicationLogger;
import login.model.EmployeeDAO;
import login.model.LoginDAO;
import login.model.UserInput;
import login.pojo.LoginPOJO;

public class LoginController {

	UserInput io = new UserInput();
	LoginPOJO login = new LoginPOJO();
	LoginDAO dao = new LoginDAO();
	AdminController admin = new AdminController();
	EmployeeController employee = new EmployeeController();
	EmployeeDAO empdao = new EmployeeDAO();

	public void runLoginUI() throws NoSuchAlgorithmException, SQLException {

		while (true) {

			int option = io.runLoginMenu();

			switch (option) {
			case 1: // login
				getLogin();
				break; // reset
			case 2:
				boolean isValidEmail = false;
				while (!isValidEmail) {
					String email = io.getEmail();
					isValidEmail = dao.isValidEmail(email);
				}

				break;
			case 3: // quit
				System.exit(0);
				System.out.println("Good Bye!");
				break;
			default:
				System.out.println("Invalid option.");
				break;
			}

		}

	}

	private void getLogin() throws SQLException, NoSuchAlgorithmException {

		ApplicationLogger log = new ApplicationLogger();

		while (true) {
			io.getLoginInfo(login);
			if (dao.isValid(login)) {
				break;
			} else {
				log.LoginFailed(); // logger

			}
		}

		if (dao.getRole(login).equals("E")) {
			log.LoginSuccessful(); // logger
			System.out.println("****************************************");
			System.out.println("Welcome Employee, " + login.getUserName() + ".");
			employee.runEmployeeUI(login.getEmpID());
			// run employee controller
		} else {
			log.LoginSuccessful(); // logger
			System.out.println("****************************************");
			System.out.println("Welcome Admin.");
			admin.runAdminUI();

		}

	}
}

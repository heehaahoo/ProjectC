package login.model;

import java.util.Scanner;

import login.pojo.EmployeePOJO;
import login.pojo.LoginPOJO;

public class UserInput {

	public LoginPOJO getLoginInfo(LoginPOJO login) {
		System.out.println("****************************************");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Username: ");
		login.setUserName(keyboard.nextLine());
		System.out.println("Password: ");
		login.setPassword(keyboard.nextLine());

		return login;

	}

	/*
	 * Prints menu and gets user's option
	 */
	public int runLoginMenu() {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("1. Login");
		System.out.println("2. Reset Password/Recover ID");
		System.out.println("3. Quit");

		return keyboard.nextInt();

	}

	/*
	 * Prints menu and gets user's option
	 */
	public int runAdminMenu() {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("1. Upoad Test");
		System.out.println("2. Create Employee Account");
		System.out.println("3. View Empoyee Performances");
		System.out.println("4. Log Out");

		return keyboard.nextInt();

	}

	public int runEmployeeMenu() {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("1. View Profile ");
		System.out.println("2. Do Test");
		System.out.println("3. Reset Password");
		System.out.println("4. Log Out");

		return keyboard.nextInt();

	}

	/*
	 * Gets new account information (temp) only asks for username and password
	 */
	public LoginPOJO getNewEmployeeInfo(LoginPOJO login) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Username: ");
		login.setUserName(keyboard.nextLine());
		System.out.println("Password: ");
		login.setPassword(keyboard.nextLine());

		return login;

	}
	
	public String getEmail(){
		
		System.out.println("Please Enter Your Email: ");
		Scanner sc = new Scanner(System.in);

		return sc.nextLine();
		
	}

	// cre8 method to get employee personal detail
	public EmployeePOJO getEmployeeDetail(EmployeePOJO detail) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Employee First Name: ");
		detail.setEmpFName(sc.nextLine());
		System.out.println("Employee Last Name: ");
		detail.setEmpLName(sc.nextLine());
		System.out.println("Employee NIRC: ");
		detail.setEmpNIRC(sc.nextLine());
		// System.out.println("Employee Gender(M/F only): ");
		// detail.setEmpGender(sc.nextLine());
		System.out.println("Employee Address: ");
		detail.setEmpAddress(sc.nextLine());
		System.out.println("Employee Date of Birth: ");
		detail.setEmpDOB(sc.nextLine());
		System.out.println("Employee Office Email: ");
		detail.setEmpEmail(sc.nextLine());
		System.out.println("Employee Mobile Number: ");
		detail.setEmpTelNo(sc.nextInt());
		System.out.println("Employee Home Number: ");
		detail.setEmpHomeNo(sc.nextInt());

		System.out.println("Employee Postal Code: ");
		detail.setEmpPostCode(sc.nextInt());

		System.out.println("Employee Status: ");
		char choice;
		while (true) {
			String temp = sc.next(); // ask for input
			choice = temp.charAt(0); // avoid using next line after next int, it
										// will only catch /n
			if (choice == 'a' || choice == 'n') {
				break;
			}
			System.out.println("Invalid input");
			// check if input is valid
			// if input not valid
			// ask again
		} // end while loop
		detail.setEmpStatus(choice);

		return detail;

	}// end getEmployeeDetail

}

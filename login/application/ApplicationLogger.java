package login.application;

import org.apache.log4j.Logger;

public class ApplicationLogger {

	private static final Logger log = Logger.getLogger(ApplicationLogger.class); 
	
	public static void main(String[] args) {
		

	}//end main
	
	
	public void LoginSuccessful(){
		if(log.isDebugEnabled()){
			log.info("Login Successful");
		}
	}
	
	public void LoginFailed(){
		if(log.isDebugEnabled()){
			log.info("Login Failed");
		}
	}
	
	
	

}//end ApplicationLogger

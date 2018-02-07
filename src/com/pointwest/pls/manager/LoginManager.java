package com.pointwest.pls.manager;

import org.apache.log4j.Logger;

import com.pointwest.pls.dao.LoginDao;
import com.pointwest.pls.data.Employee;
import com.pointwest.pls.util.PLSException;

public class LoginManager {
	static Logger log = Logger.getLogger(LoginManager.class);

	public String validateLogin(String userName, String password) throws PLSException {
		Employee employee = null;
		String welcomeMessage = "";
		log.info("validateLogin() - Start");
		try {
			LoginDao loginDao = new LoginDao();
			employee = loginDao.validateLogin(userName, password);

			if (employee == null) {
				welcomeMessage = ("Invalid username and/or password!");
			} else {
				welcomeMessage = ("Welcome " + employee.getFirstName() + " " + employee.getLastName() + " ["
						+ employee.getAppRole() + "]!");
			}
		} catch (PLSException e) {
			log.error("There was an error in getting a connection!", e);
			throw new PLSException("Sorry! There was an error in getting a connection!", e);
		}
		log.info("validateLogin() - End");
		return welcomeMessage;
	}

}

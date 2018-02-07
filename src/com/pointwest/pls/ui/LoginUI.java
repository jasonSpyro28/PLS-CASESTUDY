package com.pointwest.pls.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.pls.dao.LoginDao;
import com.pointwest.pls.manager.LoginManager;
import com.pointwest.pls.util.PLSException;
import com.pointwest.pls.util.PLSGUI;

public class LoginUI {
	static Logger log = Logger.getLogger(LoginDao.class);
	public static Scanner scanner = new Scanner(System.in);

	public static String displayLogin() throws PLSException {
		LoginManager loginManager = new LoginManager();
		String welcomeMessage = "";
		boolean repeatMenu = true;
		log.info("displayLogin() - Start");
		try {
			do {
				PLSGUI.printLoginMenu();
				System.out.print(" Username:");
				String userName = scanner.next();
				System.out.print(" Password:");
				String password = scanner.next();

				welcomeMessage = loginManager.validateLogin(userName, password);

				if (welcomeMessage.contains("Invalid")) {
					System.out.println(welcomeMessage);
				} else {
					repeatMenu = false;
				}
			} while (repeatMenu == true);
		} catch (PLSException e) {
			log.error("There was an error encountered while logging in!", e);
			throw new PLSException("Sorry! There was an error encountered while logging in!", e);
		}
		log.info("displayLogin() - End");
		return welcomeMessage;
	}
}

package com.pointwest.pls.ui;

import org.apache.log4j.Logger;

import com.pointwest.pls.dao.LoginDao;
import com.pointwest.pls.util.PLSGUI;

public class LogoutUI {
	static Logger log = Logger.getLogger(LoginDao.class);

	public void logOutMenu() {
		
		log.info("logOutMenu() - Start");
		PLSGUI.printLogoutMessage();
		log.info("logOutMenu() - End");
		log.info("System Terminates!");
	}
}

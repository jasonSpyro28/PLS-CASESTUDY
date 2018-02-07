package com.pointwest.pls.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.pls.ui.LoginUI;
import com.pointwest.pls.ui.LogoutUI;
import com.pointwest.pls.ui.SearchUI;
import com.pointwest.pls.ui.ViewUI;
import com.pointwest.pls.util.PLSException;
import com.pointwest.pls.util.PLSGUI;

public class PLS_Main {
	static Logger log = Logger.getLogger(PLS_Main.class);
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String welcomeMessage;

		try {
			welcomeMessage = LoginUI.displayLogin();
			boolean repeatMenu = true;

			SearchUI searchUI = new SearchUI();
			ViewUI viewUI = new ViewUI();
			LogoutUI logoutUI = new LogoutUI();
			String invalidMessage = "Invalid Input! Try again.";

			do {
				PLSGUI.printHomeMenu(welcomeMessage);
				String mainMenuChoice = scanner.next();

				switch (mainMenuChoice) {
				case "1":
					searchUI.searchMenu();
					repeatMenu = true;
					break;
				case "2":
					viewUI.viewSeatMenu();
					repeatMenu = true;
					break;
				case "3":
					logoutUI.logOutMenu();
					repeatMenu = false;
					break;
				default:
					System.out.println(invalidMessage);
				}
			} while (repeatMenu == true);

		} catch (PLSException e) {
			System.out.println(e.getMessage());
		}
	}

}

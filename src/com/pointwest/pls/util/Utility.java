package com.pointwest.pls.util;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Utility {
	static Logger log = Logger.getLogger(Utility.class);

	public static boolean isSearchAgain() throws PLSException {
		String invalidMessage = "Invalid Input! Try again.";
		boolean invalidInput = true;
		boolean repeatMenu = true;

		log.info("isSearchAgain() - Start");
		do {
			System.out.println("");
			System.out.println("------------------------------------------------");
			System.out.println("|ACTIONS:[1]Search Again [2]Home ");
			System.out.println("------------------------------------------------");
			Scanner scanner = new Scanner(System.in);
			String searchMenuAgainChoice = scanner.next();
			if ("1".equalsIgnoreCase(searchMenuAgainChoice)) {
				repeatMenu = true;
				invalidInput = false;
			} else if ("2".equalsIgnoreCase(searchMenuAgainChoice)) {
				repeatMenu = false;
				invalidInput = false;
			} else {
				invalidInput = true;
				System.out.println(invalidMessage);
			}
		} while (invalidInput == true);
		log.info("isSearchAgain() - End");
		return repeatMenu;
	}

	public static boolean isViewSeatAgain() {
		String invalidMessage = "Invalid Input! Try again.";
		boolean invalidInput = true;
		boolean repeatMenu = true;
		log.info("isViewSeatAgain() - Start");
		do {
			System.out.println("");
			System.out.println("------------------------------------------------");
			System.out.println("|ACTIONS:[1]View seatplan again [2]Home ");
			System.out.println("------------------------------------------------");
			Scanner scanner = new Scanner(System.in);
			String searchMenuAgainChoice = scanner.next();
			if ("1".equalsIgnoreCase(searchMenuAgainChoice)) {
				repeatMenu = true;
				invalidInput = false;
			} else if ("2".equalsIgnoreCase(searchMenuAgainChoice)) {
				repeatMenu = false;
				invalidInput = false;
			} else {
				invalidInput = true;
				System.out.println(invalidMessage);
			}
		} while (invalidInput == true);
		log.info("isViewSeatAgain() - End");
		return repeatMenu;
	}
}

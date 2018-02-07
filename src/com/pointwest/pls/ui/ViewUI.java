package com.pointwest.pls.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.pls.manager.ViewManager;
import com.pointwest.pls.util.PLSException;
import com.pointwest.pls.util.PLSGUI;
import com.pointwest.pls.util.Utility;

public class ViewUI {
	static Logger log = Logger.getLogger(ViewUI.class);
	public static Scanner scanner = new Scanner(System.in);

	public void viewSeatMenu() throws PLSException {
		String invalidMessage = "Invalid Input! Try again.";
		boolean repeatMenu = true;
		log.info("viewSeatMenu() - Start");
		try {
			do {
				PLSGUI.printViewSeatMenu();
				String searchMenuChoice = scanner.next();
				ViewManager viewManager = new ViewManager();
				String inputLocation = "";
				String inputFloor = "";
				String inputQuadrant = "";

				switch (searchMenuChoice) {
				case "1":
					PLSGUI.printViewLocHeader();
					System.out.print(" Enter location: ");
					inputLocation = scanner.next();
					System.out.print(" Enter floor level: ");
					inputFloor = scanner.next();

					PLSGUI.printSeatPlanResults(viewManager.getSeatPlan(inputLocation, inputFloor), inputLocation,
							inputFloor, inputQuadrant);
					repeatMenu = Utility.isViewSeatAgain();
					break;
				case "2":
					PLSGUI.printViewQuadrantHeader();
					System.out.print(" Enter location: ");
					inputLocation = scanner.next();
					System.out.print(" Enter floor level: ");
					inputFloor = scanner.next();
					System.out.print(" Enter quadrant: ");
					inputQuadrant = scanner.next();

					PLSGUI.printQuadrantSeatPlanResults(
							viewManager.getSeatPlanByQuadrant(inputLocation, inputFloor, inputQuadrant), inputLocation,
							inputFloor, inputQuadrant);
					repeatMenu = Utility.isViewSeatAgain();
					break;
				default:
					System.out.println(invalidMessage);
				}
			} while (repeatMenu == true);
		} catch (PLSException e) {
			log.error("There was an error encountered while viewing seatplan!", e);
			throw new PLSException("Sorry! There was an error encountered while viewing seatplan!", e);
		}
		log.info("viewSeatMenu() - End");
	}
}

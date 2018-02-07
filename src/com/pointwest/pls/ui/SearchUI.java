package com.pointwest.pls.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.pls.data.Employee;
import com.pointwest.pls.manager.SearchManager;
import com.pointwest.pls.util.PLSException;
import com.pointwest.pls.util.PLSGUI;
import com.pointwest.pls.util.Utility;

public class SearchUI {
	static Logger log = Logger.getLogger(SearchUI.class);
	public static Scanner scanner = new Scanner(System.in);
	public static PLSGUI gui = new PLSGUI();

	public void searchMenu() throws PLSException {

		boolean repeatMenu = true;
		String invalidMessage = "Invalid Input! Try again.";
		SearchManager searchManager = new SearchManager();
		List<Employee> employeeList = null;
		log.info("searchMenu() - Start");
		try {
			do {
				PLSGUI.printSearchMenu();
				String searchMenuChoice = scanner.next();

				switch (searchMenuChoice) {
				case "1":
					PLSGUI.printSearchByIDHeader();
					String inputEmployeeId = scanner.next();
					employeeList = searchManager.getEmployeeInfoById(inputEmployeeId);
					PLSGUI.printSearchResult(employeeList);

					repeatMenu = Utility.isSearchAgain();
					break;

				case "2":
					PLSGUI.printSearchByNameHeader();
					String inputEmployeeName = scanner.next();
					employeeList = searchManager.getEmployeeInfoByName(inputEmployeeName);
					PLSGUI.printSearchResult(employeeList);
					repeatMenu = Utility.isSearchAgain();
					break;

				case "3":
					PLSGUI.printSearchByProjectHeader();
					String inputEmployeeProject = scanner.next();
					employeeList = searchManager.getEmployeeInfoByProject(inputEmployeeProject);
					PLSGUI.printSearchResult(employeeList);
					repeatMenu = Utility.isSearchAgain();
					break;

				default:
					invalidMessage = "Invalid Input! Try again.";
					System.out.println(invalidMessage);
				}
			} while (repeatMenu == true);
		} catch (PLSException e) {
			log.error("There was an error encountered while searching employee!", e);
			throw new PLSException("Sorry! There was an error encountered while searching employee!", e);
		}
		log.info("searchMenu() - End");
	}
}

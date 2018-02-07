package com.pointwest.pls.util;

import java.util.List;

import com.pointwest.pls.data.Employee;

public class PLSGUI {

	public static void printLoginMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("            PEOPLE LOCATOR SYSTEM               ");
		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");
		System.out.println(" LOGIN                                          ");
		System.out.println("------------------------------------------------");
	}

	public static void printHomeMenu(String welcomeMessage) {
		System.out.println("                  ##HOME##                      ");
		System.out.println("------------------------------------------------");
		System.out.println(" " + welcomeMessage);
		System.out.println("------------------------------------------------");
		System.out.println("|MENU:                                          ");
		System.out.println("|[1] Search employee                            ");
		System.out.println("|[2] View Seatplan                              ");
		System.out.println("|[3] Exit                                       ");
		System.out.println("------------------------------------------------");
		System.out.println("|Enter choice:");
	}

	public static void printSearchMenu() {
		System.out.println("                 ##SEARCH##                     ");
		System.out.println("------------------------------------------------");
		System.out.println("|MENU:                                          ");
		System.out.println("|[1] By Employee ID                             ");
		System.out.println("|[2] By Name                                    ");
		System.out.println("|[3] By Project                                 ");
		System.out.println("------------------------------------------------");
	}

	public static void printViewSeatMenu() {
		System.out.println("              ##VIEW SEATPLAN##                 ");
		System.out.println("------------------------------------------------");
		System.out.println("|MENU:                                          ");
		System.out.println("|[1] By Location - Floor Level                  ");
		System.out.println("|[2] By Quadrant                                ");
		System.out.println("------------------------------------------------");
	}

	public static void printViewLocHeader() {
		System.out.println("------------------------------------------------");
		System.out.println("|VIEW SEAT PLAN - Location - Floor Level               ");
		System.out.println("------------------------------------------------");
	}

	public static void printViewQuadrantHeader() {
		System.out.println("------------------------------------------------");
		System.out.println("|VIEW SEAT PLAN - Quadrant       ");
		System.out.println("------------------------------------------------");
	}

	public static void printSearchByIDHeader() {
		System.out.println("------------------------------------------------");
		System.out.println("|SEARCH BY EMPLOYEE ID                                 ");
		System.out.println("------------------------------------------------");
		System.out.println("Please enter the ID of the employee you want to search:");
	}

	public static void printSearchByNameHeader() {
		System.out.println("------------------------------------------------");
		System.out.println("|SEARCH BY EMPLOYEE NAME                                 ");
		System.out.println("------------------------------------------------");
		System.out.println("Please enter the Name of the employee you want to search:");
	}

	public static void printSearchByProjectHeader() {
		System.out.println("------------------------------------------------");
		System.out.println("|SEARCH BY EMPLOYEE PROJECT                                 ");
		System.out.println("------------------------------------------------");
		System.out.println("Please enter the project of the employee you want to search:");
	}

	public static void printSearchResult(List<Employee> searchResultList) {
		try {
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"                                                ##SEARCHRESULTS##                                                         ");
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------");
			System.out.println(" Matched employees: " + searchResultList.size());
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------");
			if (searchResultList.isEmpty()) {
				System.out
						.println("                                     No employee matched!                         ");
			} else {

				System.out.println(" No.    Employee ID \tName \t \t \t\tSeat\t\tLocal\tShift\tProject(s)");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------");

				int index = 1;
				for (Employee list : searchResultList) {

					String id = list.getEmployeeId();
					String name = list.getFirstName() + " " + list.getLastName();
					String seat = list.getEmployeeSeat().getLocation();
					String local = list.getEmployeeSeat().getLocalNum();
					String shift = list.getShift();
					String project = list.getProject().getProject_alias();

					System.out.print("[" + index + "]\t");
					System.out.print(String.format("%-9s", id) + "\t");
					System.out.print(String.format("%-30s", name) + "\t");
					System.out.print(String.format("%-16s", seat));
					System.out.print(String.format("%-8s", local));
					System.out.print(String.format("%-8s", shift));
					System.out.print(String.format("%-40s", project));
					System.out.print("\n");
					index++;
				}
			}
			System.out.println(
					"-------------------------------------------------END OF RESULT------------------------------------------------------------");
		} catch (Exception e) {
			System.out.println("There was an error displaying employee information!");
		}
	}

	public static void printSearchAgainMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("|ACTIONS:[1]Search Again [2]Home ");
		System.out.println("------------------------------------------------");
	}

	public static void printLogoutMessage() {
		System.out.println("------------------------------------------------");
		System.out.println("        THANK YOU FOR USING THIS SYSTEM!        ");
		System.out.println("------------------------------------------------");
	}

	public static void printSeatPlanResults(List<Employee> searchResultList, String inputBuildingId, String inputFloor,
			String quadrant) {

		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("                               ##VIEW SEAT PLAN##                                      ");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println(" Building: " + inputBuildingId.toUpperCase() + "\t FLOOR:" + inputFloor);
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------");

		String seatRow1 = "";
		String nameRow1 = "";
		String localRow1 = "";
		String seatRow2 = "";
		String nameRow2 = "";
		String localRow2 = "";
		String seatRow3 = "";
		String nameRow3 = "";
		String localRow3 = "";
		String seatRow4 = "";
		String nameRow4 = "";
		String localRow4 = "";
		String seatRow5 = "";
		String nameRow5 = "";
		String localRow5 = "";
		String seatRow6 = "";
		String nameRow6 = "";
		String localRow6 = "";
		if (searchResultList.isEmpty()) {
			System.out.println(
					"                            No seatplan found. Please try again.                         ");
		} else {
			for (Employee list : searchResultList) {

				String name = list.getFirstName() + " " + list.getLastName();
				String seat = list.getEmployeeSeat().getBuildingId() + list.getEmployeeSeat().getFloorNum() + "F"
						+ list.getEmployeeSeat().getQuadrant() + list.getEmployeeSeat().getRowNum() + "-"
						+ list.getEmployeeSeat().getColumnNum();
				String local = list.getEmployeeSeat().getLocalNum();

				if (list.getEmployeeSeat().getRowNum().matches("1") && (list.getEmployeeSeat().getQuadrant().equals("A")
						|| list.getEmployeeSeat().getQuadrant().equals("B"))) {
					seatRow1 += (seat + "\t\t");
					nameRow1 += (String.format("%-24s", name));
					localRow1 += (local + "\t\t\t");
				} else if (list.getEmployeeSeat().getRowNum().matches("2")
						&& (list.getEmployeeSeat().getQuadrant().equals("A")
								|| list.getEmployeeSeat().getQuadrant().equals("B"))) {
					seatRow2 += (seat + "\t\t");
					nameRow2 += (String.format("%-24s", name));
					localRow2 += (local + "\t\t\t");
				} else if (list.getEmployeeSeat().getRowNum().matches("3")
						&& (list.getEmployeeSeat().getQuadrant().equals("A")
								|| list.getEmployeeSeat().getQuadrant().equals("B"))) {
					seatRow3 += (seat + "\t\t");
					nameRow3 += (String.format("%-24s", name));
					localRow3 += (local + "\t\t\t");
				} else if (list.getEmployeeSeat().getRowNum().matches("1")
						&& (list.getEmployeeSeat().getQuadrant().equals("C")
								|| list.getEmployeeSeat().getQuadrant().equals("D"))) {
					seatRow4 += (seat + "\t\t");
					nameRow4 += (String.format("%-24s", name));
					localRow4 += (local + "\t\t\t");
				} else if (list.getEmployeeSeat().getRowNum().matches("2")
						&& (list.getEmployeeSeat().getQuadrant().equals("C")
								|| list.getEmployeeSeat().getQuadrant().equals("D"))) {
					seatRow5 += (seat + "\t\t");
					nameRow5 += (String.format("%-24s", name));
					localRow5 += (local + "\t\t\t");
				} else if (list.getEmployeeSeat().getRowNum().matches("3")
						&& (list.getEmployeeSeat().getQuadrant().equals("C")
								|| list.getEmployeeSeat().getQuadrant().equals("D"))) {
					seatRow6 += (seat + "\t\t");
					nameRow6 += (String.format("%-24s", name));
					localRow6 += (local + "\t\t\t");
				}
			}

			System.out.println(
					"               QUADRANT A                                QUADRANT B                     ");
			System.out.println(seatRow1);
			System.out.println(String.format("%-30s", nameRow1) + "\t");
			System.out.println(localRow1);
			System.out.println("\n" + seatRow2);
			System.out.println(String.format("%-30s", nameRow2) + "\t");
			System.out.println(localRow2);
			System.out.println("\n" + seatRow3);
			System.out.println(String.format("%-30s", nameRow3) + "\t");
			System.out.println(localRow3);
			System.out.println(
					"\n               QUADRANT C                                QUADRANT D                     ");
			System.out.println("\n" + seatRow4);
			System.out.println(String.format("%-30s", nameRow4) + "\t");
			System.out.println(localRow4);
			System.out.println("\n" + seatRow5);
			System.out.println(String.format("%-30s", nameRow5) + "\t");
			System.out.println(localRow5);
			System.out.println("\n" + seatRow6);
			System.out.println(String.format("%-30s", nameRow6) + "\t");
			System.out.println(localRow6);
		}
		System.out.println("\n");
		System.out.println("-------------------------------END OF SEAT PLAN------------------------------------------");
	}

	public static void printQuadrantSeatPlanResults(List<Employee> searchResultList, String inputBuildingId,
			String inputFloor, String inputQuadrant) {

		System.out.println("-----------------------------------------------------------------------");
		System.out.println("|                    ##VIEW SEAT PLAN##                                ");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println(" Building: " + inputBuildingId.toUpperCase() + " FLOOR:" + inputFloor + " QUADRANT: "
				+ inputQuadrant.toUpperCase());
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("------------------------- QUADRANT: " + inputQuadrant.toUpperCase()
				+ " ---------------------------------");

		String seatRow1 = "";
		String nameRow1 = "";
		String localRow1 = "";
		String seatRow2 = "";
		String nameRow2 = "";
		String localRow2 = "";
		String seatRow3 = "";
		String nameRow3 = "";
		String localRow3 = "";

		if (searchResultList.isEmpty()) {
			System.out.println("                No seatplan found. Please try again.                   ");
		} else {
			for (Employee list : searchResultList) {

				String name = list.getFirstName() + " " + list.getLastName();
				String seat = list.getEmployeeSeat().getBuildingId() + list.getEmployeeSeat().getFloorNum() + "F"
						+ list.getEmployeeSeat().getQuadrant() + list.getEmployeeSeat().getRowNum() + "-"
						+ list.getEmployeeSeat().getColumnNum();
				String local = list.getEmployeeSeat().getLocalNum();

				if (list.getEmployeeSeat().getRowNum().matches("1")
						&& (list.getEmployeeSeat().getQuadrant().equals(inputQuadrant.toUpperCase()))) {
					seatRow1 += (seat + "\t\t");
					nameRow1 += (String.format("%-24s", name));
					localRow1 += (local + "\t\t\t");
				} else if (list.getEmployeeSeat().getRowNum().matches("2")
						&& (list.getEmployeeSeat().getQuadrant().equals(inputQuadrant.toUpperCase()))) {
					seatRow2 += (seat + "\t\t");
					nameRow2 += (String.format("%-24s", name));
					localRow2 += (local + "\t\t\t");
				} else if (list.getEmployeeSeat().getRowNum().matches("3")
						&& (list.getEmployeeSeat().getQuadrant().equals(inputQuadrant.toUpperCase()))) {
					seatRow3 += (seat + "\t\t");
					nameRow3 += (String.format("%-24s", name));
					localRow3 += (local + "\t\t\t");
				}
			}

			System.out.println("-----------------------------------------------------------------------");
			System.out.println(seatRow1);
			System.out.println(String.format("%-30s", nameRow1) + "\t");
			System.out.println(localRow1);
			System.out.println("\n" + seatRow2);
			System.out.println(String.format("%-30s", nameRow2) + "\t");
			System.out.println(localRow2);
			System.out.println("\n" + seatRow3);
			System.out.println(String.format("%-30s", nameRow3) + "\t");
			System.out.println(localRow3);
		}
		System.out.println("----------------------END OF SEAT PLAN---------------------------------");
	}

}

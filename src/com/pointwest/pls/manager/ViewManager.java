package com.pointwest.pls.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.pls.dao.SeatPlanDao;
import com.pointwest.pls.data.Employee;
import com.pointwest.pls.util.PLSException;

public class ViewManager {
	static Logger log = Logger.getLogger(ViewManager.class);

	public List<Employee> getSeatPlan(String inputBuildingId, String inputFloorNum) throws PLSException {
		List<Employee> employeeList = null;
		log.info("getSeatPlan() - Start");
		try {
			SeatPlanDao seatPlanDAO = new SeatPlanDao();
			employeeList = seatPlanDAO.getSeatPlan(inputBuildingId, inputFloorNum);
		} catch (PLSException e) {
			log.error("There was an error retrieving seatplan!", e);
			throw new PLSException("Sorry! There was an error retrieving seatplan!", e);
		}
		log.info("getSeatPlan() - End");
		return employeeList;
	}

	public List<Employee> getSeatPlanByQuadrant(String inputBuildingId, String inputFloorNum, String inputQuadrant)
			throws PLSException {
		List<Employee> employeeList = null;
		log.info("getSeatPlan() - Start");
		try {
			SeatPlanDao seatPlanDAO = new SeatPlanDao();
			employeeList = seatPlanDAO.getSeatPlanByQuadrant(inputBuildingId, inputFloorNum, inputQuadrant);
		} catch (PLSException e) {
			log.error("There was an error retrieving seatplan!", e);
			throw new PLSException("Sorry! There was an error retrieving seatplan!", e);
		}
		log.info("getSeatPlan() - End");
		return employeeList;
	}
}

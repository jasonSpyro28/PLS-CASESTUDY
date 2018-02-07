package com.pointwest.pls.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.pls.dao.EmployeeDao;
import com.pointwest.pls.data.Employee;
import com.pointwest.pls.util.PLSException;

public class SearchManager {
	static Logger log = Logger.getLogger(SearchManager.class);

	public List<Employee> getEmployeeInfoById(String inputEmployeeID) throws PLSException {
		List<Employee> employeeList = null;
		log.info("getEmployeeInfoById() - Start");
		try {
			EmployeeDao employeeDAO = new EmployeeDao();
			employeeList = employeeDAO.getEmployeeByID(inputEmployeeID);
		} catch (PLSException e) {
			log.error("There was an error retrieving employee information!", e);
			throw new PLSException("Sorry! There was an error retrieving employee information!", e);
		}
		log.info("getEmployeeInfoById() - End");
		return employeeList;
	}

	public List<Employee> getEmployeeInfoByName(String inputEmployeeName) throws PLSException {
		List<Employee> employeeList = null;
		log.info("getEmployeeInfoByName() - Start");
		try {
			EmployeeDao employeeDAO = new EmployeeDao();
			employeeList = employeeDAO.getEmployeeByName(inputEmployeeName);
		} catch (PLSException e) {
			log.error("There was an error retrieving employee information!", e);
			throw new PLSException("Sorry! There was an error retrieving employee information!", e);
		}
		log.info("getEmployeeInfoByName() - End");
		return employeeList;
	}

	public List<Employee> getEmployeeInfoByProject(String inputEmployeeProject) throws PLSException {
		List<Employee> employeeList = null;
		log.info("getEmployeeInfoByProject() - Start");
		try {
			EmployeeDao employeeDAO = new EmployeeDao();
			employeeList = employeeDAO.getEmployeeByProject(inputEmployeeProject);
		} catch (PLSException e) {
			log.error("There was an error retrieving employee information!", e);
			throw new PLSException("Sorry! There was an error retrieving employee information!", e);
		}
		log.info("getEmployeeInfoByProject() - End");
		return employeeList;
	}
}

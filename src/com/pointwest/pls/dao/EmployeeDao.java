package com.pointwest.pls.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.pls.data.Employee;
import com.pointwest.pls.data.Project;
import com.pointwest.pls.data.Seat;
import com.pointwest.pls.util.PLSException;
import com.pointwest.pls.util.SearchQueries;

public class EmployeeDao extends BaseDao {
	static Logger log = Logger.getLogger(EmployeeDao.class);

	public List<Employee> getEmployeeByID(String inputEmployeeID) throws PLSException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		Seat seat = null;
		Project project = null;
		List<Employee> searchResultList = null;

		log.info("getEmployeeByID() - Start");
		try {
			connection = getConnection();
			searchResultList = new ArrayList<Employee>();
			statement = connection.prepareStatement(SearchQueries.SEARCH_BY_EMPLOYEE_ID);
			statement.setString(1, "%" + inputEmployeeID+ "%" );

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String employeeId = resultSet.getString("emp_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String location = resultSet.getString("location");
				String localNum = resultSet.getString("local_number");
				String shift = resultSet.getString("shift");
				String currentProject = resultSet.getString("projects");
				seat = new Seat();
				seat.setLocation(location);
				seat.setLocalNum(localNum);

				project = new Project();
				project.setProject_alias(currentProject);

				employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setShift(shift);
				employee.setEmployeeSeat(seat);
				employee.setProject(project);

				searchResultList.add(employee);
			}

		} catch (SQLException e) {
			throw new PLSException("There was an error in accessing employee information!", e);
		} catch (Exception e) {
			throw new PLSException("There was an error in Searching!", e);
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}
		log.info("getEmployeeByID() - End");
		return searchResultList;
	}

	public List<Employee> getEmployeeByName(String inputEmployeeName) throws PLSException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		Seat seat = null;
		Project project = null;
		List<Employee> searchResultList = null;

		log.info("getEmployeeByName() - Start");
		try {
			connection = getConnection();
			searchResultList = new ArrayList<Employee>();
			statement = connection.prepareStatement(SearchQueries.SEARCH_BY_NAME);
			statement.setString(1, "%" + inputEmployeeName + "%");
			statement.setString(2, "%" + inputEmployeeName + "%");

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String employeeId = resultSet.getString("emp_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String location = resultSet.getString("location");
				String localNum = resultSet.getString("local_number");
				String shift = resultSet.getString("shift");
				String currentProject = resultSet.getString("projects");
				seat = new Seat();
				seat.setLocation(location);
				seat.setLocalNum(localNum);

				project = new Project();
				project.setProject_alias(currentProject);

				employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setShift(shift);
				employee.setEmployeeSeat(seat);
				employee.setProject(project);

				searchResultList.add(employee);
			}

		} catch (SQLException e) {
			throw new PLSException("There was an error in accessing employee information!", e);
		} catch (Exception e) {
			throw new PLSException("There was an error in Searching!", e);
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}
		log.info("getEmployeeByName() - End");
		return searchResultList;
	}

	public List<Employee> getEmployeeByProject(String inputEmployeeProject) throws PLSException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		Seat seat = null;
		Project project = null;
		List<Employee> searchResultList = null;

		log.info("getEmployeeByProject() - Start");
		try {
			connection = getConnection();
			searchResultList = new ArrayList<Employee>();
			statement = connection.prepareStatement(SearchQueries.SEARCH_BY_PROJECT);
			statement.setString(1, "%" + inputEmployeeProject + "%");
			System.out.println("%" + inputEmployeeProject + "%");

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String employeeId = resultSet.getString("emp_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String location = resultSet.getString("location");
				String localNum = resultSet.getString("local_number");
				String shift = resultSet.getString("shift");
				String currentProject = resultSet.getString("projects");
				seat = new Seat();
				seat.setLocation(location);
				seat.setLocalNum(localNum);

				project = new Project();
				project.setProject_alias(currentProject);

				employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setShift(shift);
				employee.setEmployeeSeat(seat);
				employee.setProject(project);

				searchResultList.add(employee);
			}
		} catch (SQLException e) {
			log.error("There was an error in accessing employee information! An SQLException.", e);
			throw new PLSException("There was an error in accessing employee information!", e);
		} catch (Exception e) {
			log.error("There was an error in Searching!", e);
			throw new PLSException("Sorry! There was an error in Searching!", e);
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}
		log.info("getEmployeeByProject() - End");
		return searchResultList;
	}
}

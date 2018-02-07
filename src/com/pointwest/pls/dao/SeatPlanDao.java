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
import com.pointwest.pls.util.ViewQueries;

public class SeatPlanDao extends BaseDao {
	static Logger log = Logger.getLogger(SeatPlanDao.class);

	public List<Employee> getSeatPlan(String inputBuildingId, String inputFloorNum) throws PLSException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		Seat seat = null;
		Project project = null;
		List<Employee> searchResultList = null;

		log.info("getSeatPlan() - Start");
		try {
			connection = getConnection();
			searchResultList = new ArrayList<Employee>();
			statement = connection.prepareStatement(ViewQueries.VIEW_SEATPLAN_BY_FLOOR);
			statement.setString(1, inputBuildingId);
			statement.setString(2, inputFloorNum);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String employeeId = resultSet.getString("emp_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");

				String buildingId = resultSet.getString("bldg_id");
				String floorNum = resultSet.getString("floor_number");

				String quadrant = resultSet.getString("quadrant");
				String rowNum = resultSet.getString("row_number");
				String columnNum = resultSet.getString("column_number");
				String localNum = resultSet.getString("local_number");
				String shift = resultSet.getString("shift");
				String currentProject = resultSet.getString("projects");

				seat = new Seat();
				seat.setBuildingId(buildingId);
				seat.setFloorNum(floorNum);
				seat.setQuadrant(quadrant);
				seat.setRowNum(rowNum);
				seat.setColumnNum(columnNum);
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
			log.error("There was an error in accessing seatplan information! An SQLException.", e);
			throw new PLSException("Sorry! There was an error in accessing seatplan information!", e);
		} catch (Exception e) {
			log.error("There was an error in accessing seatplan information!", e);
			throw new PLSException("Sorry! There was an error in accessing seatplan information!", e);
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}
		log.info("getSeatPlan() - End");
		return searchResultList;
	}

	public List<Employee> getSeatPlanByQuadrant(String inputBuildingId, String inputFloorNum, String inputQuadrant)
			throws PLSException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		Seat seat = null;
		Project project = null;
		List<Employee> searchResultList = null;

		log.info("getSeatPlanByQuadrant() - Start");
		try {
			connection = getConnection();
			searchResultList = new ArrayList<Employee>();
			statement = connection.prepareStatement(ViewQueries.VIEW_SEATPLAN_BY_QUADRANT);
			statement.setString(1, inputBuildingId);
			statement.setString(2, inputFloorNum);
			statement.setString(3, inputQuadrant);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String employeeId = resultSet.getString("emp_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");

				String buildingId = resultSet.getString("bldg_id");
				String floorNum = resultSet.getString("floor_number");

				String quadrant = resultSet.getString("quadrant");
				String rowNum = resultSet.getString("row_number");
				String columnNum = resultSet.getString("column_number");
				String localNum = resultSet.getString("local_number");
				String shift = resultSet.getString("shift");
				String currentProject = resultSet.getString("projects");

				seat = new Seat();
				seat.setBuildingId(buildingId);
				seat.setFloorNum(floorNum);
				seat.setQuadrant(quadrant);
				seat.setRowNum(rowNum);
				seat.setColumnNum(columnNum);
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
			log.error("There was an error in accessing seatplan information! An SQLException.", e);
			throw new PLSException("Sorry! There was an error in accessing seatplan information!", e);
		} catch (Exception e) {
			log.error("There was an error in accessing seatplan information!", e);
			throw new PLSException("Sorry! There was an error in accessing seatplan information!", e);
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}
		log.info("getSeatPlanByQuadrant() - End");
		return searchResultList;
	}

}

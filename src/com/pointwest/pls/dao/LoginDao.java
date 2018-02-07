package com.pointwest.pls.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.pointwest.pls.data.Employee;
import com.pointwest.pls.data.EmployeeCredentials;
import com.pointwest.pls.util.LoginQueries;
import com.pointwest.pls.util.PLSException;

public class LoginDao extends BaseDao {
	static Logger log = Logger.getLogger(LoginDao.class);

	public Employee validateLogin(String inputUserName, String inputPassword) throws PLSException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		EmployeeCredentials employeeCredentials = null;
		log.info("validateLogin() - Start");
		try {
			connection = getConnection();
			statement = connection.prepareStatement(LoginQueries.LOGIN_QUERY);
			statement.setString(1, inputUserName);
			statement.setString(2, inputPassword);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String appRole = resultSet.getString("role");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");

				employeeCredentials = new EmployeeCredentials();
				employeeCredentials.setUsername(username);
				employeeCredentials.setPassword(password);

				employee = new Employee();
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setAppRole(appRole);
				employee.setEmployeeCredentials(employeeCredentials);
			}
		} catch (SQLException e) {
			log.error("There was an error in accessing employee information! An SQLException.", e);
			throw new PLSException("Sorry! There was an error in accessing employee information!", e);
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}
		log.info("validateLogin() - End");
		return employee;
	}
}

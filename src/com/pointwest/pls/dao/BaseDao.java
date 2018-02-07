package com.pointwest.pls.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.pointwest.pls.util.PLSException;

public class BaseDao {
	static Logger log = Logger.getLogger(BaseDao.class);
	private static final String db = "jdbc:mysql://localhost:3306/plsdb";
	private static final String username = "root";
	private static final String password = "root";

	protected Connection getConnection() throws PLSException {
		Connection connection = null;
		log.info("getConnection() - Start");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(db, username, password);
		} catch (ClassNotFoundException e) {
			log.error("There was an error in getting a connection! A ClassNotFoundException.", e);
			throw new PLSException("Sorry! There was an error in getting a connection!", e);
		} catch (SQLException e) {
			log.error("There was an error in getting a connection!", e);
			throw new PLSException("Sorry! There was an error in getting a connection!", e);
		}
		log.info("getConnection() - End");
		return connection;
	}

	protected static void closeResultSet(ResultSet resultSet) throws PLSException {
		log.info("closeResultSet() - Start");
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			log.error("There was an error in closing the resultSet!An SQLException.", e);
			throw new PLSException("Sorry! There was an error in system!", e);
		}
		log.info("closeResultSet() - End");
	}

	protected static void closeStatement(Statement statement) throws PLSException {
		log.info("closeStatement() - Start");
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			log.error("There was an error in closing the statement. An SQLException.", e);
			throw new PLSException("Sorry! There was an error in system!", e);
		}
		log.info("closeStatement() - End");
	}

	protected static void closeConnection(Connection connection) throws PLSException {
		log.info("closeConnection() - Start");
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			log.error("There was an error in closing the connection. An SQLException.", e);
			throw new PLSException("Sorry! There was an error in system!", e);
		}
		log.info("closeConnection() - End");
	}
}

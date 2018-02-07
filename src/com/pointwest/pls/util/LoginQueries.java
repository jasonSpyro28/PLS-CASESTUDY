package com.pointwest.pls.util;

public interface LoginQueries {
	
	String LOGIN_QUERY = "SELECT first_name, last_name, username, password, role FROM employee WHERE username = ? AND password = ?;";

}

package com.pointwest.pls.util;

public interface SearchQueries {
	String SEARCH_BY_EMPLOYEE_ID = "SELECT e.emp_id, e.first_name, e.last_name, e.shift, s.local_number ,CONCAT(es.bldg_id,s.floor_number,'F', s.quadrant, s.row_number,'-', s.column_number) location, GROUP_CONCAT(proj_alias) projects " + 
			"FROM employee as e " + 
			"LEFT JOIN employee_seat as es " + 
			"ON e.emp_id = es.emp_id " + 
			"LEFT JOIN seat as s " + 
			"ON es.seat_id = s.seat_id " + 
			"LEFT JOIN employee_project as ep " + 
			"ON ep.employee_id = e.emp_id " + 
			"group by e.emp_id, location " + 
			"HAVING e.emp_id LIKE ? ;";

	String SEARCH_BY_NAME = "SELECT e.emp_id, e.first_name, e.last_name, e.shift, s.local_number ,CONCAT(es.bldg_id,s.floor_number,'F', s.quadrant, s.row_number,'-', s.column_number) location, GROUP_CONCAT(proj_alias) projects " + 
			"FROM employee as e " + 
			"LEFT JOIN employee_seat as es " + 
			"ON e.emp_id = es.emp_id " + 
			"LEFT JOIN seat as s " + 
			"ON es.seat_id = s.seat_id " + 
			"LEFT JOIN employee_project as ep " + 
			"ON ep.employee_id = e.emp_id " + 
			"group by e.emp_id, location " + 
			"HAVING (e.first_name LIKE ? OR e.last_name LIKE ?);";

	String SEARCH_BY_PROJECT = "SELECT e.emp_id, e.first_name, e.last_name, e.shift, s.local_number ,CONCAT(es.bldg_id,s.floor_number,'F', s.quadrant, s.row_number,'-', s.column_number) location, GROUP_CONCAT(proj_alias) projects " + 
			"FROM employee as e " + 
			"LEFT JOIN employee_seat as es " + 
			"ON e.emp_id = es.emp_id " + 
			"LEFT JOIN seat as s " + 
			"ON es.seat_id = s.seat_id " + 
			"LEFT JOIN employee_project as ep " + 
			"ON ep.employee_id = e.emp_id " + 
			"group by e.emp_id, location " + 
			"HAVING projects LIKE ?;";

}

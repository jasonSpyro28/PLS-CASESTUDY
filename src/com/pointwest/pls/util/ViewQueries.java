package com.pointwest.pls.util;

public interface ViewQueries {
	String VIEW_SEATPLAN_BY_FLOOR = "SELECT e.emp_id, e.first_name, e.last_name, e.shift, s.local_number, es.bldg_id, s.floor_number, s.quadrant, s.row_number, s.column_number, CONCAT(es.bldg_id,s.floor_number,'F', s.quadrant, s.row_number, s.column_number) location, GROUP_CONCAT(proj_alias) projects " + 
			"FROM employee as e " + 
			"LEFT JOIN employee_seat as es " + 
			"ON e.emp_id = es.emp_id " + 
			"LEFT JOIN seat as s " + 
			"ON es.seat_id = s.seat_id " + 
			"LEFT JOIN employee_project as ep " + 
			"ON ep.employee_id = e.emp_id " + 
			"group by e.emp_id, location " + 
			"HAVING (es.bldg_id = ? AND s.floor_number = ? ) " +
			"ORDER BY s.quadrant, s.column_number;";
	String VIEW_SEATPLAN_BY_QUADRANT = "SELECT e.emp_id, e.first_name, e.last_name, e.shift, s.local_number, es.bldg_id, s.floor_number, s.quadrant, s.row_number, s.column_number, CONCAT(es.bldg_id,s.floor_number,'F', s.quadrant, s.row_number, s.column_number) location, GROUP_CONCAT(proj_alias) projects " + 
			"FROM employee as e " + 
			"LEFT JOIN employee_seat as es " + 
			"ON e.emp_id = es.emp_id " + 
			"LEFT JOIN seat as s " + 
			"ON es.seat_id = s.seat_id " + 
			"LEFT JOIN employee_project as ep " + 
			"ON ep.employee_id = e.emp_id " + 
			"group by e.emp_id, location " + 
			"HAVING (es.bldg_id = ? AND s.floor_number = ? AND s.quadrant = ?) " +
			"ORDER BY s.quadrant, s.column_number;";


}

package com.pointwest.pls.data;

public class Employee {
	private String employeeId;

	private String firstName;

	private String lastName;

	private String appRole;

	private String shift;

	private Seat employeeSeat;

	private Project project;

	private EmployeeCredentials employeeCredentials;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAppRole() {
		return appRole;
	}

	public void setAppRole(String appRole) {
		this.appRole = appRole;
	}

	public Seat getEmployeeSeat() {
		return employeeSeat;
	}

	public void setEmployeeSeat(Seat employeeSeat) {
		this.employeeSeat = employeeSeat;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public EmployeeCredentials getEmployeeCredentials() {
		return employeeCredentials;
	}

	public void setEmployeeCredentials(EmployeeCredentials employeeCredentials) {
		this.employeeCredentials = employeeCredentials;
	}
}

package com.virtusa.eems.beans;

public class SearchCriteria {

	private int employeeId;
	private String email;

	public SearchCriteria() {
	}

	public SearchCriteria(int employeeId, String email) {
		super();
		this.employeeId = employeeId;
		this.email = email;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public Boolean setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public Boolean setEmail(String email) {
		this.email = email;
		return true;
	}

	@Override
	public String toString() {
		return "SearchCriteria [employeeId=" + employeeId + ", email=" + email
				+ "]";
	}

}

package com.virtusa.eems.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departments")
public class Department {
	@Id
	@Column(name = "department_Id", length = 10)
	private int departmentId;
	@Column(name = "department_Name", length = 40)
	private String departmentName;

	public Department() {
	}

	public Department(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public Boolean setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
		return true;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public Boolean setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
		return true;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName="
				+ departmentName + "]";
	}

}

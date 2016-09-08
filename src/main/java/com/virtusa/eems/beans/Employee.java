package com.virtusa.eems.beans;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Employee")
public class Employee {
	// @NotEmpty(message = "not empty")
	@Id
	@Column(name = "employee_Id", length = 10)
	private Integer employeeId;

	// @NotEmpty(message = "not empty")
	// @Size(max=10,min=5)
	@Column(name = "name", length = 100)
	private String name;

	// @NotEmpty(message = "not empty")
	@Column(name = "email", length = 25, unique = true)
	private String email;

	// @NotEmpty(message = "not empty")
	// @Size(min = 7, max = 10)
	@Column(name = "password", length = 10)
	private String password;

	@Transient
	private String confirmPassword;

	// @NotEmpty(message = "not empty")
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dob;

	// @NotEmpty(message = "not empty")
	@Column(name = "gender", length = 7)
	private String gender;

	// @NotEmpty(message = "not empty")
	@Column(name = "contact_Number", length = 11)
	private String contactNumber;

	@Column(name = "department_Id", length = 10)
	private int departmentId;

	@Column(name = "designation_Id", length = 10)
	private int designationId;

	@Column(name = "manager_Id", length = 10)
	private int managerId;

	@Column(name = "account_Number", length = 17)
	private String accountNumber;

	/*
	 * @OneToMany
	 * 
	 * @JoinTable(name = "Employee_Address", joinColumns = @JoinColumn(name =
	 * "employee_Id"), inverseJoinColumns = @JoinColumn(name = "Address_Id"))
	 * private Set<Address> address;
	 */

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "employee_id")
	private Set<Voucher> vouchers;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(name = "Employee_Activity", joinColumns = @JoinColumn(name = "employeeId"), inverseJoinColumns = @JoinColumn(name = "activityId"))
	private List<Activity> activities;

	public Employee() {
	}

	public Employee(Integer employeeId, String name, String email,
			String password, Date dob, String gender, String contactNumber,
			int departmentId, int designationId, int managerId,
			String accountNumber, Set<Voucher> vouchers,
			List<Activity> activities) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.departmentId = departmentId;
		this.designationId = designationId;
		this.managerId = managerId;
		this.accountNumber = accountNumber;
		this.vouchers = vouchers;
		this.activities = activities;
	}

	public Boolean setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
		return true;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public Boolean setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
		return true;
	}

	public String getName() {
		return name;
	}

	public Boolean setName(String name) {
		this.name = name;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public Boolean setEmail(String email) {
		this.email = email;
		return true;
	}

	public String getPassword() {
		return password;
	}

	public Boolean setPassword(String password) {
		this.password = password;
		return true;
	}

	public Date getDob() {
		return dob;
	}

	public Boolean setDob(Date dob) {
		this.dob = dob;
		return true;
	}

	public String getGender() {
		return gender;
	}

	public Boolean setGender(String gender) {
		this.gender = gender;
		return true;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public Boolean setContactNumberId(String contactNumber) {
		this.contactNumber = contactNumber;
		return true;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public Boolean setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
		return true;
	}

	public int getDesignationId() {
		return designationId;
	}

	public Boolean setDesignationId(int designationId) {
		this.designationId = designationId;
		return true;
	}

	public int getManagerId() {
		return managerId;
	}

	public Boolean setManagerId(int managerId) {
		this.managerId = managerId;
		return true;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Boolean setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return true;
	}

	/*
	 * public Set<Address> getAddress() { return address; }
	 * 
	 * public Boolean setAddress(Set<Address> address) { this.address = address;
	 * return true; }
	 */

	public Set<Voucher> getVouchers() {
		return vouchers;
	}

	public Boolean setVouchers(Set<Voucher> vouchers) {
		this.vouchers = vouchers;
		return true;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public Boolean setActivities(List<Activity> activities) {
		this.activities = activities;
		return true;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public Boolean setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name
				+ ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", dob=" + dob
				+ ", gender=" + gender + ", contactNumber=" + contactNumber
				+ ", departmentId=" + departmentId + ", designationId="
				+ designationId + ", managerId=" + managerId
				+ ", accountNumber=" + accountNumber + ", vouchers=" + vouchers
				+ ", activities=" + activities + "]";
	}

}

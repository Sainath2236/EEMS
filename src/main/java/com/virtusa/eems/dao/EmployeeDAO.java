package com.virtusa.eems.dao;

import java.util.List;
import java.util.Map;

import com.virtusa.eems.beans.Activity;
import com.virtusa.eems.beans.BankAccount;
import com.virtusa.eems.beans.Designation;
import com.virtusa.eems.beans.Employee;

public interface EmployeeDAO {
	public String registerEmployee(Employee employee);
	public Map<Integer, String> getDepartments();
	public Map<Integer, String> getDesignations();
	public Map<String, String> getGender();
	public List<Employee> getEmployees();
	public String updateEmployee(Employee employee);
	public Employee getEmployee(int employeeId);
	public List<Employee> getEmployeesByMID(int managerId);
	public Employee login(int employeeId,String password);
	public List<Activity> getEmployeeActivities(Integer employeeId);
	public Designation getDesignation(int employeeId);
	public BankAccount addBankAccount(BankAccount bankAccount);
	public BankAccount getBankAccount(String accountNumber);
	public BankAccount updateBankAccount(BankAccount bankAccount);
	public Boolean deleteBankAccount(BankAccount bankAccount);
	public Boolean deleteEmployee(Employee employee);
	public Employee getManager(int departmentId, int managerId);
	public Employee getEmployee(String email);
	
}

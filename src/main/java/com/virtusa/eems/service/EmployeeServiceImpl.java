package com.virtusa.eems.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.eems.beans.Activity;
import com.virtusa.eems.beans.BankAccount;
import com.virtusa.eems.beans.Designation;
import com.virtusa.eems.beans.Employee;
import com.virtusa.eems.dao.EmployeeDAO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	static Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	
	

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Transactional
	public String registerEmployee(Employee employee) {
		log.info("*** registering employee in EmployeeService ***");
			return employeeDAO.registerEmployee(employee);
	}

	@Transactional
	public Map<Integer, String> getDepartments() {
		log.info("*** getting departments in EmployeeService ***");
		return employeeDAO.getDepartments();
	}

	@Transactional
	public Map<Integer, String> getDesignations() {
		log.info("*** getting designation in EmployeeService ***");
		return employeeDAO.getDesignations();
	}

	@Transactional
	public Map<String, String> getGender() {
		log.info("*** getting genders in EmployeeService ***");
		return employeeDAO.getGender();
	}

	@Transactional
	public List<Employee> getEmployees() {
		log.info("*** getting employees in EmployeeService ***");
		return employeeDAO.getEmployees();
	}

	@Transactional
	public String updateEmployee(Employee employee) {
		log.info("*** updating employees in EmployeeService ***");
		return employeeDAO.updateEmployee(employee);
	}

	@Transactional
	public Employee getEmployee(int employeeId) {
		log.info("*** getting employess by employee id in EmployeeService ***");
		return employeeDAO.getEmployee(employeeId);
	}

	@Transactional
	public List<Employee> getEmployeesByMID(int managerId) {
		log.info("*** getting employess by manager id in EmployeeService ***");
		return employeeDAO.getEmployeesByMID(managerId);
	}

	@Transactional
	public Employee login(int employeeId, String password) {
		log.info("*** checking login credentials, if true then getting employee object else null  in EmployeeService  ***");
		return employeeDAO.login(employeeId, password);
	}

	@Transactional
	public List<Activity> getEmployeeActivities(Integer employeeId) {
		log.info("*** getting employee activities in EmployeeService ***");
		return employeeDAO.getEmployeeActivities(employeeId);
	}

	@Transactional
	public Designation getDesignation(int employeeId) {
		log.info("*** getting designations in EmployeeService ***");
		return employeeDAO.getDesignation(employeeId);
	}

	public BankAccount addBankAccount(BankAccount bankAccount) {
		log.info("***  Adding bank account in employee Service and getting bankAccount object in return ***");
		return employeeDAO.addBankAccount(bankAccount);
	}

	public BankAccount getBankAccount(String accountNumber) {
		return employeeDAO.getBankAccount(accountNumber);
	}

	
	public BankAccount updateBankAccount(BankAccount bankAccount) {
		return employeeDAO.updateBankAccount(bankAccount);
	}

	
	public Boolean deleteBankAccount(BankAccount bankAccount) {
		return employeeDAO.deleteBankAccount(bankAccount);
		
	}

	
	public Boolean deleteEmployee(Employee employee) {
		return employeeDAO.deleteEmployee(employee);
		
	}

	
	public Employee getManager(int departmentId, int managerId) {
		return employeeDAO.getManager(departmentId,managerId);
	}

	
	public Employee getEmployee(String email) {
		return employeeDAO.getEmployee(email);
	}


}

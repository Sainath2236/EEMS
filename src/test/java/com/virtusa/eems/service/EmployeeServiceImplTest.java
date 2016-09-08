package com.virtusa.eems.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.virtusa.eems.beans.BankAccount;
import com.virtusa.eems.beans.Designation;
import com.virtusa.eems.beans.Employee;
import com.virtusa.eems.dao.EmployeeDAO;

public class EmployeeServiceImplTest {
	EmployeeServiceImpl empServiceIMPL;
	@Mock
	EmployeeDAO employeeDAO;
	@Mock
	Employee employee1,employee2;
	private BankAccount account1,account2;
	private Designation designation1;
	private String message = "Registration Success!!";
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		empServiceIMPL = new EmployeeServiceImpl();
		empServiceIMPL.setEmployeeDAO(employeeDAO);
		
		employee1=new Employee(123456, "employee1", "abc@gmail.com", "abc123", null, "Male", "9603918828", 1, 1, 1, "123", null, null);
		employee2=new Employee(123457, "employee2", "xyz@gmail.com", "xyz123", null, "Female", "9601111234", 1, 1, 1, "456", null, null);
		designation1=new Designation(1,"Manager",null);
		account1=new BankAccount("1234567891234567", "siva", "icici", "icic1234567", "hyderabad");
		Map<Integer, String> departmentsMap = new LinkedHashMap<Integer, String>();
		departmentsMap.put(1, "department1");
		departmentsMap.put(2, "department2");
		Map<Integer, String> designationsMap = new LinkedHashMap<Integer, String>();
		departmentsMap.put(1, "designation1");
		departmentsMap.put(2, "designation2");
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("Male", "Male");
		genderMap.put("female", "female");
		
		//when(employeeDAO.registerEmployee(employee1)).thenReturn(message);
		when(employeeDAO.getEmployee(123456)).thenReturn(employee1);
		when(employeeDAO.getDepartments()).thenReturn(departmentsMap);
		when(employeeDAO.getDesignations()).thenReturn(designationsMap);
		when(employeeDAO.getGender()).thenReturn(genderMap);
		when(employeeDAO.getEmployees()).thenReturn(
				Arrays.asList(employee1, employee2));
		when(employeeDAO.getEmployee(123456)).thenReturn(employee1);
		when(employeeDAO.getEmployeesByMID(1)).thenReturn(
				Arrays.asList(employee1, employee2));
		when(employeeDAO.login(123456, "abc123")).thenReturn(employee1);
		when(employeeDAO.getDesignation(123456)).thenReturn(designation1);
		when(employeeDAO.addBankAccount(account1)).thenReturn(account1);
		when(employeeDAO.getBankAccount("1234567891234567")).thenReturn(account1);
		when(employeeDAO.updateBankAccount(account1)).thenReturn(account1);
		when(employeeDAO.getManager(3, 1)).thenReturn(employee1);
		when(employeeDAO.deleteEmployee(employee1)).thenReturn(new Boolean(true));
		when(employeeDAO.deleteBankAccount(account1)).thenReturn(new Boolean(true));
		when(employeeDAO.registerEmployee(employee1)).thenReturn(message);

	}
	@Test
	public void testRegisterEmployeeNegative(){
		String result = empServiceIMPL.registerEmployee(employee2);
		assertEquals(null, result);

	}
	@Test
	public void testRegisterEmployeePositive(){
		String result = empServiceIMPL.registerEmployee(employee1);
		assertEquals(message, result);

	}
	@Test
	public void testGetEmployeeNegative() {
		Employee employee = empServiceIMPL.getEmployee(12345);
		assertEquals(null, employee);
	}
	@Test
	public void testGetEmployeePositive() {
		Employee employee = empServiceIMPL.getEmployee(123456);
		assertNotNull(employee);
		assertEquals(employee.getName(), "employee1");
		assertEquals(employee.getEmployeeId().intValue(), 123456);
		assertEquals(employee.getPassword(), "abc123");
	

	}

//	@Test
//	public void testRegisterEmployee() throws RegistrationConstraintException, SQLException {
//		String result = empServiceIMPL.registerEmployee(employee1);
//		assertEquals(message, result);
//
//	}

	@Test
	public void testGetDepartments() {
		Map<Integer, String> departments = empServiceIMPL.getDepartments();
		assertEquals(2, departments.size());

	}

	@Test
	public void testGetDesignations() {
		Map<Integer, String> designations = empServiceIMPL.getDepartments();
		assertEquals(2, designations.size());

	}

	@Test
	public void testGetGender() {
		Map<String, String> gender = empServiceIMPL.getGender();
		assertEquals(2, gender.size());

	}

	@Test
	public void testGetEmployees() {
		List<Employee> employee = empServiceIMPL.getEmployees();
		assertEquals(2, employee.size());

	}
	@Test
	public void testGetEmployeeByMIDNegative() {
		List<Employee> employee = empServiceIMPL.getEmployeesByMID(6);
		assertEquals(0, employee.size());
	}
	@Test
	public void testGetEmployeeByMIDPositive() {
		List<Employee> employee = empServiceIMPL.getEmployeesByMID(1);
		assertEquals(2, employee.size());

	}
	@Test
	public void loginFail() {
		Employee employee = empServiceIMPL.login(123456, "abc12");
		assertEquals(null, employee);
		}

	@Test
	public void testLogin() {
		Employee employee = empServiceIMPL.login(123456, "abc123");
		assertNotNull(employee);
		assertEquals(employee.getEmployeeId().intValue(), 123456);
		assertEquals(employee.getPassword(), "abc123");

	}
	@Test
	public void testGetDesignationNegative() {
		Designation designation = empServiceIMPL.getDesignation(12345);
		assertEquals(null, designation);
		
}
	@Test
	public void testGetDesignationPositive() {
		Designation designation = empServiceIMPL.getDesignation(123456);
		assertNotNull(designation);
		assertEquals(designation.getDesignationId().intValue(), 1);
		assertEquals(designation.getDesignationName(), "Manager");

	}
	@Test
	public void testAddBankAccountNegative(){
		BankAccount account=empServiceIMPL.addBankAccount(account2);
		assertEquals(null, account);
		}
	@Test
	public void testAddBankAccountPositive(){
		BankAccount account=empServiceIMPL.addBankAccount(account1);
		assertNotNull(account);
		}
	@Test
	public void testGetBankAccountNegative(){
		BankAccount account=empServiceIMPL.getBankAccount("123456789123456");
		assertEquals(null, account);
		}
	@Test
	public void testGetBankAccountPositive(){
		BankAccount account=empServiceIMPL.getBankAccount("1234567891234567");
		assertNotNull(account);
		}
	@Test
	public void testUpdateBankAccountNegative(){
		BankAccount account=empServiceIMPL.updateBankAccount(account2);
		assertEquals(null, account);
		
	}
	@Test
	public void testUpdateBankAccountPositive(){
		BankAccount account=empServiceIMPL.updateBankAccount(account1);
		assertNotNull(account);
		
	}
	@Test
	public void testGetManagerNegative(){
		Employee employee=empServiceIMPL.getManager(6, 8);
		assertEquals(null, employee);
	}
	@Test
	public void testGetManagerPositive(){
		Employee employee=empServiceIMPL.getManager(3, 1);
		assertNotNull(employee);
		// assertEquals(employee.getEmployeeId(),123456);
				assertEquals(employee.getName(), "employee1");
				assertEquals(employee.getEmployeeId().intValue(), 123456);
				assertEquals(employee.getDepartmentId(), 1);
				assertEquals(employee.getDesignationId(), 1);
				assertEquals(employee.getManagerId(), 1);
				assertEquals(employee.getAccountNumber(), "123");
				//assertEquals( employee.getAddress(), null);
				assertEquals(employee.getVouchers(), null);
				assertEquals(employee.getPassword(), "abc123");
				assertEquals(employee.getDob(), null);
				assertEquals(employee.getEmail(), "abc@gmail.com");
				assertEquals(employee.getContactNumber(), "9603918828");

		
	}
	@Test
	public void testDeleteEmployee(){
		Boolean result=empServiceIMPL.deleteEmployee(employee1);
		assertEquals(true, result);
		
	}
	@Test
	public void testDeleteBankAccount(){
		Boolean result=empServiceIMPL.deleteBankAccount(account1);
		assertEquals(true, result);
		
	}

}


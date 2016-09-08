package com.virtusa.eems.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.eems.beans.BankAccount;
import com.virtusa.eems.beans.Designation;
import com.virtusa.eems.beans.Employee;
import com.virtusa.eems.dao.EmployeeDAOImpl;

public class EmployeeDAOIMPLTest {
	private EmployeeDAOImpl mockedEmployeeDao;
	private Employee employee1;
	private Employee employee2;
	private BankAccount account1,account2;
	private Designation designation1;
	private String message = "Registration Success!!";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mockedEmployeeDao = mock(EmployeeDAOImpl.class);
		
		
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
		

		when(mockedEmployeeDao.getDepartments()).thenReturn(departmentsMap);
		when(mockedEmployeeDao.getDesignations()).thenReturn(designationsMap);
		when(mockedEmployeeDao.getGender()).thenReturn(genderMap);
		when(mockedEmployeeDao.getEmployees()).thenReturn(
				Arrays.asList(employee1, employee2));
		when(mockedEmployeeDao.getEmployee(123456)).thenReturn(employee1);
		when(mockedEmployeeDao.getEmployeesByMID(1)).thenReturn(
				Arrays.asList(employee1, employee2));
		when(mockedEmployeeDao.login(123456, "abc123")).thenReturn(employee1);
		when(mockedEmployeeDao.getDesignation(123456)).thenReturn(designation1);
		when(mockedEmployeeDao.addBankAccount(account1)).thenReturn(account1);
		when(mockedEmployeeDao.getBankAccount("1234567891234567")).thenReturn(account1);
		when(mockedEmployeeDao.updateBankAccount(account1)).thenReturn(account1);
		when(mockedEmployeeDao.getManager(3, 1)).thenReturn(employee1);
		when(mockedEmployeeDao.deleteEmployee(employee1)).thenReturn(new Boolean(true));
		when(mockedEmployeeDao.deleteBankAccount(account1)).thenReturn(new Boolean(true));
		when(mockedEmployeeDao.registerEmployee(employee1)).thenReturn(message);
		
		
	
		
	}
	@Test
	public void testRegisterEmployeeNegative(){
		String result = mockedEmployeeDao.registerEmployee(employee2);
		assertEquals(null, result);

	}

	@Test
	public void testRegisterEmployeePositive(){
		String result = mockedEmployeeDao.registerEmployee(employee1);
		assertEquals(message, result);

	}

	@Test
	public void testGetDepartments() {
		Map<Integer, String> departments = mockedEmployeeDao.getDepartments();
		assertEquals(2, departments.size());
		
}

	@Test
	public void testGetDesignations() {
		Map<Integer, String> designations = mockedEmployeeDao.getDepartments();
		assertEquals(2, designations.size());

	}
	
	@Test
	public void testGetGender() {
		Map<String, String> gender = mockedEmployeeDao.getGender();
		assertEquals(2, gender.size());

	}
	

	@Test
	public void testGetEmployeesPositive() {
		List<Employee> employee = mockedEmployeeDao.getEmployees();
		assertEquals(2, employee.size());

	}
	@Test
	public void testGetEmployeeNegative() {
		Employee employee = mockedEmployeeDao.getEmployee(12345);
		assertEquals(null, employee);
	}

	@Test
	public void testGetEmployeePositive() {
		Employee employee = mockedEmployeeDao.getEmployee(123456);
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
	public void testGetEmployeeByMIDNegative() {
		List<Employee> employee = mockedEmployeeDao.getEmployeesByMID(6);
		assertEquals(0, employee.size());
		

	}

	@Test
	public void testGetEmployeeByMIDPositive() {
		List<Employee> employee = mockedEmployeeDao.getEmployeesByMID(1);
		assertEquals(2, employee.size());

	}

	@Test
	public void loginFail() {
		Employee employee = mockedEmployeeDao.login(123456, "abc12");
		assertEquals(null, employee);
		}
	
	@Test
	public void loginSuccess() {
		Employee employee = mockedEmployeeDao.login(123456, "abc123");
		assertNotNull(employee);
		assertEquals(employee.getEmployeeId().intValue(), 123456);
		assertEquals(employee.getPassword(), "abc123");
     }
	
	@Test
	public void testGetDesignationNegative() {
		Designation designation = mockedEmployeeDao.getDesignation(12345);
		assertEquals(null, designation);
		
}
	
	@Test
	public void testGetDesignationPositive() {
		Designation designation = mockedEmployeeDao.getDesignation(123456);
		assertNotNull(designation);
		assertEquals(designation.getDesignationId().intValue(), 1);
		assertEquals(designation.getDesignationName(), "Manager");
}
	@Test
	public void testAddBankAccountNegative(){
		BankAccount account=mockedEmployeeDao.addBankAccount(account2);
		assertEquals(null, account);
		
	}
	@Test
	public void testAddBankAccountPositive(){
		BankAccount account=mockedEmployeeDao.addBankAccount(account1);
		assertNotNull(account);
		
	}
	@Test
	public void testGetBankAccountNegative(){
		BankAccount account=mockedEmployeeDao.getBankAccount("1234567891234");
		assertEquals(null, account);
		}
	@Test
	public void testGetBankAccountPositive(){
		BankAccount account=mockedEmployeeDao.getBankAccount("1234567891234567");
		assertNotNull(account);
		
	}
	@Test
	public void testUpdateBankAccountNegative(){
		BankAccount account=mockedEmployeeDao.updateBankAccount(account2);
		assertEquals(null, account);
		
	}
	@Test
	public void testUpdateBankAccountPositive(){
		BankAccount account=mockedEmployeeDao.updateBankAccount(account1);
		assertNotNull(account);
		
	}
	@Test
	public void testGetManagerNegative(){
		Employee employee=mockedEmployeeDao.getManager(6, 8);
		assertEquals(null, employee);
	}
	@Test
	public void testGetManagerPositive(){
		Employee employee=mockedEmployeeDao.getManager(3, 1);
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
		Boolean result=mockedEmployeeDao.deleteEmployee(employee1);
		assertEquals(true, result);
		
	}
	@Test
	public void testDeleteBankAccount(){
		Boolean result=mockedEmployeeDao.deleteBankAccount(account1);
		assertEquals(true, result);
		
	}


}

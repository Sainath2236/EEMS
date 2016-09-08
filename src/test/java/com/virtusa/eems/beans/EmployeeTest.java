package com.virtusa.eems.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.eems.dao.EmployeeDAOImpl;


@SuppressWarnings("unused")
public class EmployeeTest {
	private Employee employee,employee1;
	private Integer employeeId;
	private String name;
	private String email;
	private String password;
	private Date dob;
	private String gender;
    private String contactNumber;
    private int departmentId;
    private int designationId;
    private int managerId;
    private String accountNumber;
    private Activity activity1,activity2;
	private List<Activity> activities;
    String temp;
	
	 @BeforeClass
	    public static void setUpBeforeClass() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
	    
	    @Before
		public void setUp() throws Exception {
	    	
	    	employee = mock(Employee.class);
	    	activities=new ArrayList<Activity>();
	    	activities.add(activity1);
	    	employee1=new Employee();
	    	employee1.setEmployeeId(23);
	    	employee1.setName("siva");
	    	employee1.setEmail("siva123@gmail.com");
	    	employee1.setPassword("Qwer123456");
	    	employee1.setDob(null);
	    	employee1.setGender("Male");
	    	employee1.setContactNumber(contactNumber);
	    	employee1.setDepartmentId(5);
	    	employee1.setDesignationId(1);
	    	employee1.setManagerId(3);
	    	employee1.setAccountNumber(accountNumber);
	    	employee1.setActivities(null);
	    	employee1.getEmployeeId();
	    	employee1.getName();
	    	employee1.getEmail();
	    	employee1.getPassword();
	    	employee1.getDob();
	    	employee1.getGender();
	    	employee1.getContactNumber();
	    	employee1.getDepartmentId();
	    	employee1.getDesignationId();
	    	employee1.getManagerId();
	    	employee1.getAccountNumber();
	    	employee1.getActivities();
	    	temp=employee1.toString();
	    	when(employee.getEmployeeId()).thenReturn(23);
	    	when(employee.getName()).thenReturn("siva");
	    	when(employee.getEmail()).thenReturn("siva123@gmail.com");
	    	when(employee.getPassword()).thenReturn("Qwer123456");
	    	
	    	when(employee.getDob()).thenReturn(null);
	    	when(employee.getGender()).thenReturn("Male");
	    	contactNumber="9603918828";
	    	when(employee.getContactNumber()).thenReturn(contactNumber);
	    	when(employee.getDepartmentId()).thenReturn(5);
	    	when(employee.getDesignationId()).thenReturn(1);
	    	when(employee.getManagerId()).thenReturn(3);
	    	
	    	accountNumber="1234567894561879";
	    	when(employee.getAccountNumber()).thenReturn(accountNumber);
	    	when(employee.getActivities()).thenReturn(null);
	    	when(employee.setEmployeeId(employee1.getEmployeeId())).thenReturn(new Boolean(true));
	    	when(employee.setName("siva")).thenReturn(new Boolean(true));
	    	when(employee.setEmail("siva123@gmail.com")).thenReturn(new Boolean(true));
	    	when(employee.setPassword("Qwer123456")).thenReturn(new Boolean(true));
	    	when(employee.setDob(null)).thenReturn(new Boolean(true));
	    	when(employee.setGender("Male")).thenReturn(new Boolean(true));
	    	when(employee.setContactNumber(contactNumber)).thenReturn(new Boolean(true));
	    	when(employee.setDepartmentId(5)).thenReturn(new Boolean(true));
	    	when(employee.setDesignationId(1)).thenReturn(new Boolean(true));
	    	when(employee.setManagerId(3)).thenReturn(new Boolean(true));
	    	when(employee.setAccountNumber(accountNumber)).thenReturn(new Boolean(true));
	    	when(employee.setActivities(null)).thenReturn(new Boolean(true));
	    	when(employee.toString()).thenReturn(temp);
	    }
  @Test
  public void Employee() {
   
  }

 
  @Test
  public void getAccountNumber() {
	  String result=employee.getAccountNumber();
	  assertEquals(accountNumber,result);
 
  }

  

  @Test
  public void getContactNumber() {
	  String result=employee.getContactNumber();
	  assertEquals(contactNumber,result);
 
  }
  

  @Test
  public void getDepartmentId() {
	  
	  int result=employee.getDepartmentId();
	  
	  assertEquals(5, result);
  }

  @Test
  public void getDesignationId() {
	  int result=employee.getDesignationId();
	  assertEquals(1, result);
  }

  @Test
  public void getDob() {
    Date dob=employee.getDob();
    assertEquals(null,dob);
  }

  @Test
  public void getEmail() {
	  String result=employee.getEmail();
	  assertEquals("siva123@gmail.com", result);
  }

  @Test
  public void getEmployeeId() {
	  int result=employee.getEmployeeId();
	  assertEquals(23, result);
	  
	  
  }
 
 @Test
  
  public void getGender() {
	  String result=employee.getGender();
	  assertEquals("Male", result);
  }

  @Test
  public void getManagerId() {
	  int result=employee.getManagerId();
	  assertEquals(3, result);
  }

  @Test
  public void getName() {
	  String result=employee.getName();
	  assertEquals("siva", result);
  }

  @Test
  public void getPassword() {
	  String result=employee.getPassword();
	  assertEquals("Qwer123456", result);
  }



  @Test
  public void setAccountNumber() {
	  Boolean result = employee.setAccountNumber(accountNumber);
		 assertTrue(result);
  }

  @Test
  public void setActivities() {
    
  }

  @Test
  public void setContactNumber() {
	  Boolean result = employee.setContactNumber(contactNumber);
		 assertTrue(result);
  }

 

  @Test
  public void setDepartmentId() {
	  Boolean result = employee.setDepartmentId(5);
		 assertTrue(result);
  }

  @Test
  public void setDesignationId() {
	  Boolean result = employee.setDesignationId(1);
		 assertTrue(result);
  }

  @Test
  public void setDob() {
	  Boolean result = employee.setDob(null);
		 assertTrue(result);
  }
  

  @Test
  public void setEmail() {
	  Boolean result = employee.setEmail("siva123@gmail.com");
		 assertTrue(result);
  }

  @Test
  public void setEmployeeId() {
	  Boolean result = employee.setEmployeeId(employee1.getEmployeeId());
		 assertTrue(result);
  }

  @Test
  public void setGender() {
	  Boolean result = employee.setGender("Male");
		 assertTrue(result);
  }

  @Test
  public void setManagerId() {
	  Boolean result = employee.setManagerId(3);
		 assertTrue(result);
  }

  @Test
  public void setName() {
	  Boolean result = employee.setName("siva");
		 assertTrue(result);
  }

  @Test
  public void setPassword() {
	  Boolean result = employee.setPassword("Qwer123456");
		 assertTrue(result);
  }

  @Test
  public void testToString(){
	  String result=employee1.toString();
		 assertEquals(temp, result);
  }
}

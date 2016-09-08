package com.virtusa.eems.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


@SuppressWarnings("unused")
public class DepartmentTest {
	private Department department,department1,department2;
	private int departmentId;
	private String departmentName;
    String temp;
	
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    @Before
	public void setUp() throws Exception {
    	
    	department = mock(Department.class);
    	department2=new Department(1,"IT");
    	department1=new Department();
    	
    	department1.setDepartmentId(3);
    	department1.setDepartmentName("IT");
    	department1.getDepartmentId();
    	department1.getDepartmentName();
    	temp=department1.toString();
    	when(department.getDepartmentId()).thenReturn(3);
    	when(department.getDepartmentName()).thenReturn("IT");
    	when(department.setDepartmentId(2)).thenReturn(new Boolean(true));
    	when(department.setDepartmentName("IT")).thenReturn(new Boolean(true));
    	when(department.toString()).thenReturn(temp);
    }

  @Test
  public void getDepartmentId() {
int result=department.getDepartmentId();
	  
	  assertEquals(3, result);;
	  
  }

  @Test
  public void getDepartmentName() {
	  String result=department.getDepartmentName();
	  assertEquals("IT",result);
  }

  @Test
  public void setDepartmentId() {
	  Boolean result = department.setDepartmentId(2);
		 assertTrue(result);
    
  }

  @Test
  public void setDepartmentName() {
	  Boolean result = department.setDepartmentName("IT");
		 assertTrue(result);
  }
  @Test
  public void testToString(){
	  String result=department1.toString();
		 assertEquals(temp, result);
  }
}

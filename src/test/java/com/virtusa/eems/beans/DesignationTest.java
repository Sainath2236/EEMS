package com.virtusa.eems.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


@SuppressWarnings("unused")
public class DesignationTest {
	private Designation designation,designation1;
	private Integer designationId;
	private String designationName;
	private Activity activity1,activity2;
	private List<Activity> activities;
	
	
	 @BeforeClass
	    public static void setUpBeforeClass() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
	    
	    @Before
		public void setUp() throws Exception {
	    	
	    	designation = mock(Designation.class);
	    	activities=new ArrayList<Activity>();
	    	activities.add(activity1);
	    
	    	designation1=new Designation();
	    	designation1.setDesignationId(2);
	    	designation1.setDesignationName("Manager");
	    	designation1.setActivities(null);
	    	designation1.getDesignationId();
	    	designation1.getDesignationName();
	    	designation1.getActivities();
	    	when(designation.getDesignationId()).thenReturn(2);
	    	when(designation.getDesignationName()).thenReturn("Manager");
	    	when(designation.getActivities()).thenReturn(null);
	    	when(designation.setDesignationId(2)).thenReturn(new Boolean(true));
	    	when(designation.setDesignationName("Manager")).thenReturn(new Boolean(true));
	    	when(designation.setActivities(null)).thenReturn(new Boolean(true));
	    	when(designation.toString()).thenReturn(null);
	    }
 

  @Test
  public void getActivities() {
	  List<Activity> activities=designation.getActivities();
	  assertEquals(null, activities);
    
	  
  }

  @Test
  public void getDesignationId() {
int result=designation.getDesignationId();
	  
	  assertEquals(2, result);
  }

  @Test
  public void getDesignationName() {
	  String result=designation.getDesignationName();
	  assertEquals("Manager",result);
  }

  @Test
  public void setActivities() {
	  Boolean result = designation.setActivities(null);
		 assertTrue(result);
   
  }

  @Test
  public void setDesignationId() {
	  Boolean result = designation.setDesignationId(2);
		 assertTrue(result);
       
  }

  @Test
  public void setDesignationName() {
	  Boolean result = designation.setDesignationName("Manager");
		 assertTrue(result);
   
  }
  @Test
  public void testToString(){
	  String result=designation.toString();
		 assertEquals(null, result);
  }
}

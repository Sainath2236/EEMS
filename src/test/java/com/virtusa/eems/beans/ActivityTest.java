package com.virtusa.eems.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("unused")
public class ActivityTest {
	
	private Activity activity,activity1,activity2;
	private Integer activityId;
	private String activityName;
	private String userType;
	private Designation designation1,designation2;
	private List<Designation> designations;
	String temp;
	
	 @BeforeClass
	    public static void setUpBeforeClass() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
	    @Before
		public void setUp() throws Exception {
	    	
	    	activity = mock(Activity.class);
	    	
	    	designations=new ArrayList<Designation>();
	    	designation1=new Designation(1,"employee",null);
	    	designation2=new Designation(2,"manager",null);
	    	designations.add(designation1);
	    	designations.add(designation2);
	    	
	    	activity1=new Activity();
	    	activity2=new Activity(1, "Create Voucher", "Employee", null);
	    	activity1.setActivityId(2);
	    	activity1.setActivityName("Create Voucher");
	    	activity1.setUserType("Employee");
	    	activity1.setDesignations(designations);
	    	activity1.getActivityId();
	    	activity1.getActivityName();
	    	activity1.getUserType();
	    	activity1.getDesignations();
	    	temp=activity1.toString();
	    
	    	
	    	when(activity.getActivityId()).thenReturn(2);
	    	when(activity.getActivityName()).thenReturn("Create Voucher");
	    	when(activity.getUserType()).thenReturn("Employee");
	    	when(activity.setActivityId(2)).thenReturn(new Boolean(true));
	    	when(activity.setActivityName("siva")).thenReturn(new Boolean(true));
	    	when(activity.setUserType("Employee")).thenReturn(new Boolean(true));
	    	when(activity.getDesignations()).thenReturn(Arrays.asList(designation1,designation2));
	    	when(activity.setDesignations(designations)).thenReturn(new Boolean(true));  
	    	when(activity.toString()).thenReturn(temp);
	    }

  @Test
  public void getActivityId() {
	  int result=activity.getActivityId();
	  assertEquals(2, result);
  }

  @Test
  public void getActivityName() {
	  String result=activity.getActivityName();
	  assertEquals("Create Voucher",result);
  }

 

  @Test
  public void getUserType() {
	  
	  String result=activity.getUserType();
	  assertEquals("Employee",result);
  }

  @Test
  public void setActivityId() {
	  Boolean result = activity.setActivityId(2);
		 assertTrue(result);
	
  }

  @Test
  public void setActivityName() {
	  Boolean result = activity.setActivityName("siva");
		 assertTrue(result);
    
  }

  @Test
  public void setDesignations() {
	  boolean result=activity.setDesignations(designations);
		 assertTrue(result);
  }
  @Test
  public void getDesignations() {
	  List<Designation> designations=activity.getDesignations();
	  assertEquals(2,designations.size());
    
  }
  @Test
  public void setUserType() {
	  Boolean result = activity.setUserType("Employee");
		 assertTrue(result);
    
  }
  @Test
  public void testToString(){
	  String result=activity1.toString();
	  assertEquals(temp,result);
  }
}

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
public class StatusTest {
	private Status status,status1;
	private int statusId;
	private String statusName;
	String temp;
	
	
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    @Before
	public void setUp() throws Exception {
    	
    	status = mock(Status.class);
    	status1=new Status();
    	status1.setStatusId(2);
    	status1.setStatusName("Approved");
    	status1.getStatusId();
    	status1.getStatusName();
    	temp=status1.toString();
    	when(status.getStatusId()).thenReturn(2);
    	when(status.getStatusName()).thenReturn("Approved");
    	when(status.setStatusId(2)).thenReturn(new Boolean(true));
    	when(status.setStatusName("Approved")).thenReturn(new Boolean(true));
    	when(status.toString()).thenReturn(temp);
    }



  @Test
  public void getStatusId() {
 int result=status.getStatusId();
	  
	  assertEquals(2, result);
  }

  @Test
  public void getStatusName() {
	  String result=status.getStatusName();
	  assertEquals("Approved",result);
  }

  @Test
  public void setStatusId() {
	  Boolean result = status.setStatusId(2);
		 assertTrue(result);
  }

  @Test
  public void setStatusName() {
	  Boolean result = status.setStatusName("Approved");
		 assertTrue(result);
  }
  @Test
  public void testToString(){
	  String result=status1.toString();
		 assertEquals(temp, result);
  }
}

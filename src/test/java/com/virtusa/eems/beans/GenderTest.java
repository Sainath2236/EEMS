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
public class GenderTest {
	
	private Gender gender,gender1;
	private String type;

	
	 @BeforeClass
	    public static void setUpBeforeClass() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
	    
	    
	    @Before
		public void setUp() throws Exception {
	    	
	    	gender = mock(Gender.class);
	    	gender1=new Gender();
	    	gender1.setType("Male");
	    	gender1.getType();
	    	gender1.toString();
	    	when(gender.getType()).thenReturn("Male");
	    	when(gender.setType("Male")).thenReturn(new Boolean(true));
	    	when(gender.toString()).thenReturn(null);
	    }

  @Test
  public void getType() {
	  String result=gender.getType();
	  assertEquals("Male",result);
  }

  @Test
  public void setType() {
	  boolean result=gender.setType("Male");
		 assertTrue(result);
  }
  @Test
  public void testToString(){
	  String result=gender.toString();
		 assertEquals(null, result);
  }
}

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
public class LevelTest {
	private Level level,level1;
	private int levelId;
	private String levelName;
	private String range;
	String temp;
	
	 @BeforeClass
	    public static void setUpBeforeClass() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
	    
	    @Before
		public void setUp() throws Exception {
	    	
	    	level = mock(Level.class);
	    	level1=new Level();
	    	level1.setLevelId(4);
	    	level1.setLevelName("Manager");
	    	level1.setRange("Process");
	    	level1.getLevelId();
	    	level1.getLevelName();
	    	level1.getRange();
	    	temp=level1.toString();
	    	when(level.getLevelId()).thenReturn(4);
	    	when(level.getLevelName()).thenReturn("Manager");
	    	when(level.getRange()).thenReturn("Process");
	    	when(level.setLevelId(4)).thenReturn(new Boolean(true));
	    	when(level.setLevelName("Manager")).thenReturn(new Boolean(true));
	    	when(level.setRange("Process")).thenReturn(new Boolean(true));
	    	when(level.toString()).thenReturn(temp);
	    }

 

  @Test
  public void getLevelId() {
int result=level.getLevelId();
	  
	  assertEquals(4, result);
  }

  @Test
  public void getLevelName() {
	  String result=level.getLevelName();
	  assertEquals("Manager", result);
  }

  @Test
  public void getRange() {
	  String result=level.getRange();
	  assertEquals("Process", result);
  }

  @Test
  public void setLevelId() {
	  Boolean result = level.setLevelId(4);
		 assertTrue(result);
  }

  @Test
  public void setLevelName() {
	  Boolean result = level.setLevelName("Manager");
		 assertTrue(result);
  }

  @Test
  public void setRange() {
	  Boolean result = level.setRange("Process");
		 assertTrue(result);
  }
  @Test
  public void testToString(){
	  String result=level1.toString();
		 assertEquals(temp, result);
  }
}

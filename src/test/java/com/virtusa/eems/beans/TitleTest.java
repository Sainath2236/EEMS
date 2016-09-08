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
public class TitleTest {
	private Title title, title1;
	private int titleId;
	private String titleName;
	String temp;
	 @BeforeClass
	    public static void setUpBeforeClass() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
	    
	    @Before
		public void setUp() throws Exception {
	    	
	    	title = mock(Title.class);
	    	title1=new Title();
	    	title1.setTitleId(3);
	    	title1.setTitleName("Mobile Bill");
	    	title1.getTitleId();
	    	title1.getTitleName();
	    	temp=title1.toString();
	    	when(title.getTitleId()).thenReturn(3);
	    	when(title.getTitleName()).thenReturn("Mobile Bill");
	    	when(title.setTitleId(3)).thenReturn(new Boolean(true));
	    	when(title.setTitleName("Mobile Bill")).thenReturn(new Boolean(true));
	    	when(title.toString()).thenReturn(temp);
	    }

 

  @Test
  public void getTitleId() {
	  
	  int result=title.getTitleId();
	  
	  assertEquals(3, result);
  }

  @Test
  public void getTitleName() {
	  String result=title.getTitleName();
	  assertEquals("Mobile Bill",result);
  }

  @Test
  public void setTitleId() {
	  Boolean result = title.setTitleId(3);
		 assertTrue(result);
  }

  @Test
  public void setTitleName() {
	  Boolean result = title.setTitleName("Mobile Bill");
		 assertTrue(result);
  }
  @Test
  public void testToString(){
	  String result=title1.toString();
		 assertEquals(temp, result);
  }
  
}

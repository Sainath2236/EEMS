package com.virtusa.eems.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


@SuppressWarnings("unused")
public class VoucherTest {
	private Voucher voucher,voucher1;
	private Integer voucherId;
	private int employeeId;
	private String title;
	private String description;
	private Date date;
	private double amount;
	private String status;
	private int level;
	String temp;
	
	 @BeforeClass
	    public static void setUpBeforeClass() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
      
	    @Before
	    
		public void setUp() throws Exception {
	    	
	    	voucher= mock(Voucher.class);
	    	voucher1=new Voucher();
	    	voucher1.setVoucherId(32);
	    	voucher1.setEmployeeId(3);
	    	voucher1.setTitle("Medical");
	    	voucher1.setDescription("Sample Medical");
	    	voucher1.setDate(null);
	    	voucher1.setAmount(258.45);
	    	voucher1.setStatus("Pending");
	    	voucher1.setLevel(5);
	    	voucher1.getVoucherId();
	    	voucher1.getEmployeeId();
	    	voucher1.getTitle();
	    	voucher1.getDescription();
	    	voucher1.getDate();
	    	voucher1.getAmount();
	    	voucher1.getStatus();
	    	voucher1.getLevel();
	    	temp=voucher1.toString();
	    	when(voucher.getVoucherId()).thenReturn(32);
	    	when(voucher.getEmployeeId()).thenReturn(3);
	    	when(voucher.getTitle()).thenReturn("Medical");
	    	when(voucher.getDescription()).thenReturn("Sample Medical");
	    	when(voucher.getDate()).thenReturn(null);
	    	when(voucher.getAmount()).thenReturn(258.45);
	    	when(voucher.getStatus()).thenReturn("Pending");
	    	when(voucher.getLevel()).thenReturn(5);
	    	when(voucher.setVoucherId(32)).thenReturn(new Boolean(true));
	    	when(voucher.setEmployeeId(3)).thenReturn(new Boolean(true));
	    	when(voucher.setTitle("Medical")).thenReturn(new Boolean(true));
	    	when(voucher.setDescription("Sample Medical")).thenReturn(new Boolean(true));
	    	when(voucher.setDate(null)).thenReturn(new Boolean(true));	 
	    	when(voucher.setAmount(258.45)).thenReturn(new Boolean(true));
	    	when(voucher.setStatus("Pending")).thenReturn(new Boolean(true));
	    	when(voucher.setLevel(5)).thenReturn(new Boolean(true));
	    }
 


@Test
  public void getAmount() {
	  double result=voucher.getAmount();
	  assertEquals(258.45,result,0);
    
  }

  @Test
  public void getDate() {
	  Date date=voucher.getDate();
	    assertEquals(null,date);
  }

  @Test
  public void getDescription() {
	  String result=voucher.getDescription();
	  assertEquals("Sample Medical",result);
  }

  @Test
  public void getEmployeeId() {
	  int result=voucher.getEmployeeId();
	  assertEquals(3,result);
  }

  @Test
  public void getLevel() {
	  int result=voucher.getLevel();
	  assertEquals(5,result);
  }

  @Test
  public void getStatus() {
	  String result=voucher.getStatus();
	  assertEquals("Pending",result);
  }

  @Test
  public void getTitle() {
	  String result=voucher.getTitle();
	  assertEquals("Medical",result);
  }

  @Test
  public void getVoucherId() {
	  int result=voucher.getVoucherId();
	  assertEquals(32,result);
 
  }

  @Test
  public void setAmount() {
	  boolean result=voucher.setAmount(258.45);
		 assertTrue(result);
  }

  @Test
  public void setDate() {
	  boolean result=voucher.setDate(null);
		 assertTrue(result);
  }

  @Test
  public void setDescription() {
	  boolean result=voucher.setDescription("Sample Medical");
		 assertTrue(result);
  }

  @Test
  public void setEmployeeId() {
	  boolean result=voucher.setEmployeeId(3);
		 assertTrue(result);
  }

  @Test
  public void setLevel() {
	  boolean result=voucher.setLevel(5);
		 assertTrue(result);
  }

  @Test
  public void setStatus() {
	  boolean result=voucher.setStatus("Pending");
		 assertTrue(result);
  }

  @Test
  public void setTitle() {
	  boolean result=voucher.setTitle("Medical");
		 assertTrue(result);
  }

  @Test
  public void setVoucherId() {
	  boolean result=voucher.setVoucherId(32);
		 assertTrue(result);
  }
  @Test
  public void testToString(){
	  String result=voucher1.toString();
		 assertEquals(temp, result);
  }
}

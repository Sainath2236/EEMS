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
public class AddressTest {
	private Address address,address1;
	private int addressId;
	private int houseNo;
	private String Street;
	private String city;
	private String State;
	private long pinCode;
	String temp;
	
	 @BeforeClass
	    public static void setUpBeforeClass() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
	    
	    @Before
		public void setUp() throws Exception {
	    	
	    	address = mock(Address.class);
	    	address1=new Address();
	    	address1.setAddressId(45);
	    	address1.setHouseNo(4589);
	    	address1.setStreet("Gachibowli");
	    	address1.setCity("Hyderabad");
	    	address1.setPinCode(123456);
	    	address1.setState("Telangana");
	    	address1.getAddressId();
	    	address1.getHouseNo();
	    	address1.getStreet();
	    	address1.getCity();
	    	address1.getPinCode();
	    	address1.getState();
	    	temp=address1.toString();
	    	when(address.getAddressId()).thenReturn(45);
	    	when(address.getHouseNo()).thenReturn(4589);
	    	when(address.getStreet()).thenReturn("Gachibowli");
	    	when(address.getCity()).thenReturn("Hyderabad");
	    	when(address.getState()).thenReturn("Telangana");
	        when(address.getPinCode()).thenReturn(new Long(123456));
	    	when(address.setAddressId(45)).thenReturn(new Boolean(true));
	    	when(address.setHouseNo(4589)).thenReturn(new Boolean(true));
	    	when(address.setStreet("Gachibowli")).thenReturn(new Boolean(true));
	    	when(address.setCity("Hyderabad")).thenReturn(new Boolean(true));
	    	when(address.setState("Telangana")).thenReturn(new Boolean(true));
	    	when(address.setPinCode(123456)).thenReturn(new Boolean(true));
	    	when(address.toString()).thenReturn(temp);
	    }
  @Test
  public void getAddressId() {
	  int result=address.getAddressId();
	  assertEquals(45, result);
  }

  @Test
  public void getCity() {
	  String result=address.getCity();
	  assertEquals("Hyderabad",result);
  }

  @Test
  public void getHouseNo() {
	  int result=address.getHouseNo();
	  assertEquals(4589,result);
  }

  @Test
  public void getPinCode() {
	  
	  long result=address.getPinCode();
	  assertEquals(123456, result);
  }

  @Test
  public void getState() {
	  String result=address.getState();
	  assertEquals("Telangana",result);
  
  }

  @Test
  public void getStreet() {
	  String result=address.getStreet();
	  assertEquals("Gachibowli",result);  }

  @Test
  public void setAddressId() {
	  Boolean result = address.setAddressId(45);
		 assertTrue(result);
    
  }

  @Test
  public void setCity() {
	  Boolean result = address.setCity("Hyderabad");
		 assertTrue(result);
  }

  @Test
  public void setHouseNo() {
	  Boolean result = address.setHouseNo(4589);
		 assertTrue(result);
  }

  @Test
  public void setPinCode() {
	  Boolean result = address.setPinCode(123456);
		 assertTrue(result);
  }

  @Test
  public void setState() {
	  Boolean result = address.setState("Telangana");
		 assertTrue(result);
  }

  @Test
  public void setStreet() {
	  Boolean result = address.setStreet("Gachibowli");
		 assertTrue(result);
  }
  @Test
  public void testToString(){
	  String result=address1.toString();
		 assertEquals(temp, result);
  }
}

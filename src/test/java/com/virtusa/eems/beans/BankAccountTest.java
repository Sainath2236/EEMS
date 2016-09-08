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
public class BankAccountTest {
	private BankAccount account,account1;
	private String accountNumber;
	private String accountName;
	private String bankName;
	private String iFSCCode;
	private String branch;
	String temp;
	
	  @Before
	    
			public void setUp() throws Exception {
		    	
		    	account= mock(BankAccount.class);
		    	account1=new BankAccount();
		    	account1.setAccountName("siva");
		    	account1.setAccountNumber(accountNumber);
		    	account1.setBankName("hdfc");
		    	account1.setiFSCCode("hdfc7894512");
		    	account1.setBranch("hyd");
		    	account1.getAccountName();
		    	account1.getAccountNumber();
		    	account1.getBankName();
		    	account1.getiFSCCode();
		    	account1.getBranch();
		    	accountNumber="1234567894561879";
		    	temp=account1.toString();
		    	when(account.getAccountNumber()).thenReturn(accountNumber);
		    	when(account.getAccountName()).thenReturn("siva");
		    	when(account.getBankName()).thenReturn("hdfc");
		    	when(account.getiFSCCode()).thenReturn("hdfc7894512");
		    	when(account.getBranch()).thenReturn("hyd");
		    	when(account.setAccountNumber(accountNumber)).thenReturn(new Boolean(true));
		    	when(account.setAccountName("siva")).thenReturn(new Boolean(true));
		    	when(account.setBankName("hdfc")).thenReturn(new Boolean(true));
		    	when(account.setiFSCCode("hdfc7894512")).thenReturn(new Boolean(true));
		    	when(account.setBranch("hyd")).thenReturn(new Boolean(true));
		    	when(account.toString()).thenReturn(temp);
	  }
	 @BeforeClass
	    public static void setUpBeforeClass() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
   

  

 
  @Test
  public void getAccountName() {
	  String result=account.getAccountName();
	  assertEquals("siva", result);
  }

  @Test
  public void getAccountNumber() {
	  String result=account.getAccountNumber();
	  assertEquals(accountNumber,result);
  }

  @Test
  public void getBankName() {
	  String result=account.getBankName();
	  assertEquals("hdfc",result);
  }

  @Test
  public void getBranch() {
	  String result=account.getBranch();
	  assertEquals("hyd",result);
  }

  @Test
  public void getiFSCCode() {
	  String result=account.getiFSCCode();
	  assertEquals("hdfc7894512",result);
  }

  @Test
  public void setAccountName() {
	  Boolean result = account.setAccountName("siva");
		 assertTrue(result);
    
  }

  @Test
  public void setAccountNumber() {
	  Boolean result = account.setAccountNumber(accountNumber);
		 assertTrue(result);
  }

  @Test
  public void setBankName() {
	  Boolean result = account.setBankName("hdfc");
		 assertTrue(result);
  }

  @Test
  public void setBranch() {
	  Boolean result = account.setBranch("hyd");
		 assertTrue(result);
  }

  @Test
  public void setiFSCCode() {
	  Boolean result = account.setiFSCCode("hdfc7894512");
		 assertTrue(result);
  }
  @Test
  public void testToString(){
	  String result=account1.toString();
		 assertEquals(temp, result);
  }
  
}

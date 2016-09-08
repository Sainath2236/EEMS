package com.virtusa.eems.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.virtusa.eems.beans.Level;
import com.virtusa.eems.beans.Status;
import com.virtusa.eems.beans.Title;
import com.virtusa.eems.beans.Voucher;
import com.virtusa.eems.dao.VoucherDAO;

public class VoucherServiceImplTest {
	VoucherServiceImpl voucherServiceIMPL;
	@Mock
	VoucherDAO voucherDAO;
	private Voucher voucher1;
	private Voucher voucher2;
	
	private Title title1,title2;
	private Status status1,status2;
	private Level level1,level2;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		voucherServiceIMPL = new VoucherServiceImpl();
		voucherServiceIMPL.setVoucherDAO(voucherDAO);
		

		voucher1 = new Voucher(100,"voucher1","desc1",null,1000,"Pending",3,200);
		voucher2 = new Voucher(101,"voucher1","desc1",null,1000,"Pending",3,201);
		
		title1=new Title(1,"Medical Expenses");
		title2=new Title(2,"Travel Expenses");
		
		status1=new Status(1,"status1");
		status2=new Status(2,"status2");
		
		level1=new Level(1, "level1", "500-1000");
		level2=new Level(2, "level2", "1000-2000");
		
		Map<String, String> titles = new LinkedHashMap<String, String>();
		titles.put(title1.getTitleName(),title1.getTitleName());
		titles.put(title2.getTitleName(),title2.getTitleName());
		
		Map<Integer, String> levels = new LinkedHashMap<Integer, String>();
		levels.put(level1.getLevelId(),level1.getRange());
		levels.put(level2.getLevelId(),level2.getRange());
		
		Map<String, String> status = new LinkedHashMap<String, String>();
		status.put(status1.getStatusName(),status1.getStatusName());
		status.put(status2.getStatusName(),status2.getStatusName());
			
		when(voucherDAO.getAllVouchers(200, "Pending")).thenReturn(
				Arrays.asList(voucher1, voucher2));
	
		when(voucherDAO.addVoucher(voucher1)).thenReturn(voucher1);
	
		when(voucherDAO.getListStatus()).thenReturn(
				Arrays.asList(status1, status2));
		when(voucherDAO.getVoucher(100)).thenReturn(voucher1);
		
		when(voucherDAO.updateVoucher(voucher1)).thenReturn(voucher1);
		
		when(voucherDAO.getTitles()).thenReturn(titles);
		when(voucherDAO.getLevels()).thenReturn(levels);
		when(voucherDAO.getMapStatus()).thenReturn(status);
		when(voucherDAO.getVouchers("Pending")).thenReturn(Arrays.asList(voucher1,voucher2));
	}
	@Test
	public void testGetAllVouchersNegative(){
		List<Voucher> allEmp = voucherServiceIMPL.getAllVouchers(300,"Approved");
		assertEquals(0, allEmp.size());
		
	}
	@Test
	public void testGetAllVouchersPositive(){
		List<Voucher> allEmp = voucherServiceIMPL.getAllVouchers(200,"Pending");
		assertEquals(2, allEmp.size());
		
	}
	@Test
	public void testAddVoucherNegative(){
		
		Voucher voucher = voucherServiceIMPL.addVoucher(voucher2);
		assertEquals(null,voucher);
		
	}
	@Test
	public void testAddVoucherPositive(){
		
		Voucher voucher = voucherServiceIMPL.addVoucher(voucher1);
		assertEquals(voucher,voucher);
		
	}
	@Test
	public void testGetListStatus(){
		List<Status> allEmp = voucherServiceIMPL.getListStatus();
		assertEquals(2, allEmp.size());
		
	}

    @Test	
	public void testGetVoucherByIdNegative()
	{
		int voucherId=200;
		Voucher voucher= voucherServiceIMPL.getVoucher(voucherId);
		assertEquals(null,voucher);
	}

    @Test	
	public void testGetVoucherByIdPositive()
	{
		int voucherId=100;
		Voucher voucher= voucherServiceIMPL.getVoucher(voucherId);
		assertEquals(voucher,voucher);
	}
    @Test
    public void testUpdateVoucherNegative()
    {
	   Voucher voucher = voucherServiceIMPL.updateVoucher(voucher2);
		assertEquals(null,voucher);
    }
   @Test
    public void testUpdateVoucherPositive()
    {
	   Voucher voucher = voucherServiceIMPL.updateVoucher(voucher1);
		assertEquals(voucher,voucher);
    }
	@Test
	public void testGetTitle(){
		Map<String,String> allTitles=voucherServiceIMPL.getTitles();
		assertEquals(2, allTitles.size());
		
	}
	@Test
	public void testGetMapStatus(){
		Map<String,String> allStatus=voucherServiceIMPL.getMapStatus();
		assertEquals(2, allStatus.size());
		
	}
	@Test
	public void testGetLevel(){
		Map<Integer,String> allLevels=voucherServiceIMPL.getLevels();
		assertEquals(2, allLevels.size());
		
	}
	@Test
	public void testGetVoucherNegative(){
		List<Voucher> vouchers=voucherServiceIMPL.getVouchers("Approved");
		assertEquals(0, vouchers.size());
		
	}
	@Test
	public void testGetVoucherPositive(){
		List<Voucher> vouchers=voucherServiceIMPL.getVouchers("Pending");
		assertEquals(2, vouchers.size());
		
	}
	

}

package com.virtusa.eems.DAO;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.eems.beans.Level;
import com.virtusa.eems.beans.Status;
import com.virtusa.eems.beans.Title;
import com.virtusa.eems.beans.Voucher;
import com.virtusa.eems.dao.VoucherDAOImpl;





public class VoucherDAOIMPLTest {
	private VoucherDAOImpl mockedVoucherDao;
	private Voucher voucher1;
	private Voucher voucher2;
	
	private Title title1,title2;
	private Status status1,status2;
	private Level level1,level2;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception {
		mockedVoucherDao = mock(VoucherDAOImpl.class);
		
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
			
		when(mockedVoucherDao.getAllVouchers(200, "Pending")).thenReturn(
				Arrays.asList(voucher1, voucher2));
	
		when(mockedVoucherDao.addVoucher(voucher1)).thenReturn(voucher1);
	
		when(mockedVoucherDao.getListStatus()).thenReturn(
				Arrays.asList(status1, status2));
		when(mockedVoucherDao.getVoucher(100)).thenReturn(voucher1);
		
		when(mockedVoucherDao.updateVoucher(voucher1)).thenReturn(voucher1);
		
		when(mockedVoucherDao.getTitles()).thenReturn(titles);
		when(mockedVoucherDao.getLevels()).thenReturn(levels);
		when(mockedVoucherDao.getMapStatus()).thenReturn(status);
		when(mockedVoucherDao.getVouchers("Pending")).thenReturn(Arrays.asList(voucher1,voucher2));
		
		
	}
	@Test
	public void testGetAllVouchersNegative(){
		List<Voucher> allEmp = mockedVoucherDao.getAllVouchers(300,"Approved");
		assertEquals(0, allEmp.size());
		
	}

	@Test
	public void testGetAllVouchersPositive(){
		List<Voucher> allEmp = mockedVoucherDao.getAllVouchers(200,"Pending");
		assertEquals(2, allEmp.size());
		
	}
	@Test
	public void testAddVoucherNegative(){
		
		Voucher voucher = mockedVoucherDao.addVoucher(voucher2);
		assertEquals(null, voucher);
		}
	@Test
	public void testAddVoucherPositive(){
		
		Voucher voucher = mockedVoucherDao.addVoucher(voucher1);
		assertEquals(voucher,voucher);
		}
	@Test
	public void testGetListStatus(){
		List<Status> allEmp = mockedVoucherDao.getListStatus();
		assertEquals(2, allEmp.size());
		
	}
	@Test	
	public void testGetVoucherByIdNegative()
	{
		int voucherId=200;
		Voucher voucher= mockedVoucherDao.getVoucher(voucherId);
		assertEquals(null,voucher);
	}


    @Test	
	public void testGetVoucherByIdPositive()
	{
		int voucherId=100;
		Voucher voucher= mockedVoucherDao.getVoucher(voucherId);
		assertEquals(voucher,voucher);
	}
    @Test
    public void testUpdateVoucherNegative()
    {
	   Voucher voucher = mockedVoucherDao.updateVoucher(voucher2);
		assertEquals(null,voucher);
    }
   @Test
    public void testUpdateVoucherPositive()
    {
	   Voucher voucher = mockedVoucherDao.updateVoucher(voucher1);
		assertEquals(voucher,voucher);
    }
	@Test
	public void testGetTitle(){
		Map<String,String> allTitles=mockedVoucherDao.getTitles();
		assertEquals(2, allTitles.size());
		
	}
	@Test
	public void testGetMapStatus(){
		Map<String,String> allStatus=mockedVoucherDao.getMapStatus();
		assertEquals(2, allStatus.size());
		
	}
	@Test
	public void testGetLevel(){
		Map<Integer,String> allLevels=mockedVoucherDao.getLevels();
		assertEquals(2, allLevels.size());
		
	}
	@Test
	public void testGetVoucherNegative(){
		List<Voucher> vouchers=mockedVoucherDao.getVouchers("Approved");
		assertEquals(0, vouchers.size());
		
	}
	@Test
	public void testGetVoucherPositive(){
		List<Voucher> vouchers=mockedVoucherDao.getVouchers("Pending");
		assertEquals(2, vouchers.size());
		
	}
	
}

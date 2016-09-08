package com.virtusa.eems.service;

import java.util.List;
import java.util.Map;

import com.virtusa.eems.beans.Status;
import com.virtusa.eems.beans.Voucher;

public interface VoucherService {
	public Map<String,String> getTitles();
	public Map<Integer,String> getLevels();
	public Voucher addVoucher(Voucher voucher);
	public List<Voucher> getAllVouchers(int employeeId,String status);
	public Map<String,String> getMapStatus();
	public List<Status> getListStatus();
	public Voucher getVoucher(int voucherId);
	public Voucher updateVoucher(Voucher voucher);
	public List<Voucher> getVouchers(String status);
}

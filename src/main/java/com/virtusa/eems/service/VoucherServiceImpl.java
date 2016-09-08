package com.virtusa.eems.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.eems.beans.Status;
import com.virtusa.eems.beans.Voucher;
import com.virtusa.eems.dao.VoucherDAO;

@Service
@Transactional
public class VoucherServiceImpl implements VoucherService {
	@Autowired
	private VoucherDAO voucherDAO;

	static Logger log = Logger.getLogger(VoucherServiceImpl.class);

	public void setVoucherDAO(VoucherDAO voucherDAO) {
		this.voucherDAO = voucherDAO;
	}

	public Map<String, String> getTitles() {
		log.info("*** getting titles in VoucherService ***");
		return voucherDAO.getTitles();
	}

	public Map<Integer, String> getLevels() {
		log.info("*** getting levels in VoucherService ***");
		return voucherDAO.getLevels();
	}

	public Voucher addVoucher(Voucher voucher) {
		log.info("*** adding voucher in VoucherService ***");
		return voucherDAO.addVoucher(voucher);
	}

	public List<Voucher> getAllVouchers(int employeeId, String status) {
		log.info("*** getting all vouchers in VoucherService  ***");
		return voucherDAO.getAllVouchers(employeeId, status);
	}

	public Map<String, String> getMapStatus() {
		log.info("*** getting status as map in VoucherService  ***");
		return voucherDAO.getMapStatus();
	}

	public List<Status> getListStatus() {
		log.info("*** getting status as list in VoucherService ***");
		return voucherDAO.getListStatus();
	}

	public Voucher getVoucher(int voucherId) {
		log.info("*** getting voucher by voucher id in VoucherService ***");
		return voucherDAO.getVoucher(voucherId);
	}

	public Voucher updateVoucher(Voucher voucher) {
		log.info("*** updating voucher in VoucherService ***");
		return voucherDAO.updateVoucher(voucher);
	}

	
	public List<Voucher> getVouchers(String status) {
		return voucherDAO.getVouchers(status);
	}

}

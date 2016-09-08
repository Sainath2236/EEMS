package com.virtusa.eems.dao;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.eems.beans.Level;
import com.virtusa.eems.beans.Status;
import com.virtusa.eems.beans.Title;
import com.virtusa.eems.beans.Voucher;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class VoucherDAOImpl implements VoucherDAO {
	@Autowired
	private SessionFactory sessionFactory;

	static Logger log = Logger.getLogger(VoucherDAOImpl.class);

	public Map<String, String> getTitles() {
		log.info("*** before getting titles as map in voucherDao ***");
		Session session = sessionFactory.getCurrentSession();
		List<Title> title = session.createQuery("From Title").list();
		Map<String, String> titles = new LinkedHashMap<String, String>();
		titles.put("0", "Not Selected");
		for (Title t : title) {
			titles.put(t.getTitleName(), t.getTitleName());
		}
		log.info("*** after getting titles as map in voucherDao ***");
		return titles;
	}

	public Map<Integer, String> getLevels() {
		log.info("*** before getting levels as map in voucherDao ***");
		Session session = sessionFactory.getCurrentSession();
		List<Level> level = session.createQuery("From Level").list();
		Map<Integer, String> levels = new LinkedHashMap<Integer, String>();
		levels.put(0, "Not Selected");
		for (Level l : level) {
			levels.put(l.getLevelId(), l.getRange());
		}
		log.info("*** after getting levels as map in voucherDao ***");
		return levels;
	}

	public Voucher addVoucher(Voucher voucher) {
		log.info("*** adding vouchers in voucherDao ***");
		Session session = sessionFactory.getCurrentSession();
		List<Level> levels = session.createQuery("From Level").list();
		log.info("*** retrieving levels as list to set in voucher ***");
		String[] levelAmount;
		for (Level level : levels) {
			levelAmount = level.getRange().split("-");
			if (voucher.getAmount() >= Double.parseDouble(levelAmount[0])
					&& voucher.getAmount() <= Double
							.parseDouble(levelAmount[1])) {
				voucher.setLevel(level.getLevelId());
				log.info("*** setting level for newly created voucher ***");
			}
		}
		voucher.setDate(new Date());
		voucher.setStatus("Pending");
		session.save(voucher);
		log.info("*** voucher created successfully ***");
		return voucher;
	}

	public List<Voucher> getAllVouchers(int employeeId, String status) {
		log.info("*** before geting all vouchers by employee id and status in voucherDao ***");
		List<Voucher> vouchers = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Voucher where employee_id = " + employeeId
								+ " and Voucher_status = '" + status + "'")
				.list();
		log.info("*** after geting all vouchers by employee id and status in voucherDao ***");
		return vouchers;
	}

	public Map<String, String> getMapStatus() {
		log.info("*** before geting status as map in voucherDao ***");
		List<Status> status = sessionFactory.getCurrentSession()
				.createQuery("From Status").list();
		Map<String, String> statusMap = new LinkedHashMap<String, String>();
		for (Status status1 : status) {
			statusMap.put(status1.getStatusName(), status1.getStatusName());
		}
		log.info("*** after geting status as map in voucherDao ***");
		return statusMap;
	}

	public List<Status> getListStatus() {
		log.info("*** before geting status as list in voucherDao ***");
		List<Status> status = sessionFactory.getCurrentSession()
				.createQuery("From Status").list();
		log.info("*** after geting status as list in voucherDao ***");
		return status;
	}

	@Transactional
	public Voucher getVoucher(int voucherId) {
		log.info("*** before geting voucher by voucher id in voucherDao***");
		Voucher voucher = (Voucher) sessionFactory.getCurrentSession().get(
				Voucher.class, voucherId);
		log.info("*** after geting voucher by voucher id in voucherDao ***");
		return voucher;

		/*
		 * List<Voucher> vouchers =
		 * sessionFactory.getCurrentSession().createQuery
		 * ("From Voucher where voucher_id = "+voucherId).list(); return
		 * vouchers.get(0);
		 */
	}

	public Voucher updateVoucher(Voucher voucher) {
		log.info("*** before updating voucher in voucherDao ***");
		sessionFactory.getCurrentSession().update(voucher);
		log.info("*** after updating voucher in voucherDao ***");
		return voucher;
	}

	
	public List<Voucher> getVouchers(String status) {
		log.info("*** before getting vouchers in voucherDao ***");
		List<Voucher> vouchers = sessionFactory.getCurrentSession()
				.createQuery("From Voucher where status='" + status + "'")
				.list();
		log.info("*** after getting vouchers in voucherDao ***");
		return vouchers;
	}

}

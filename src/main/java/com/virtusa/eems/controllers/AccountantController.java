package com.virtusa.eems.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.eems.beans.Employee;
import com.virtusa.eems.beans.Status;
import com.virtusa.eems.beans.Voucher;
import com.virtusa.eems.service.EmployeeService;
import com.virtusa.eems.service.VoucherService;

@Controller
@RequestMapping("/Accountant")
public class AccountantController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private VoucherService voucherService;

	@Autowired
	HttpSession httpSession;

	static Logger log = Logger.getLogger(ManagerController.class);

	@RequestMapping("/home")
	public ModelAndView employeeLogin(ModelAndView modelAndView,
			HttpServletRequest request) {
		httpSession = request.getSession();
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(ModelAndView modelAndView) {
		httpSession.invalidate();
		modelAndView.addObject("employee", new Employee());
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}

	@RequestMapping("/{activity}/{status}/{voucherId}")
	public ModelAndView cancelVoucher(ModelAndView modelAndView,
			HttpServletRequest request,
			@PathVariable("activity") String activity,
			@PathVariable("status") String status,
			@PathVariable("voucherId") int voucherId) {
		// httpSession = request.getSession();
		log.info("*** ***");
		if (httpSession != null) {
			String designation = (String) httpSession
					.getAttribute("designation");
			Voucher voucher = voucherService.getVoucher(voucherId);
			voucher.setStatus(status);
			voucherService.updateVoucher(voucher);
			modelAndView.setViewName("redirect:/" + designation + "/"
					+ activity + "/" + status);
			log.info("*** redirected to /" + designation + "/" + activity + "/"
					+ status + " controller ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping("/Process Payment")
	public ModelAndView processPayments(ModelAndView modelAndView) {
		log.info("*** Process Payment Controller ***");
		if (httpSession != null) {
			List<Status> statusList = voucherService.getListStatus();
			modelAndView.addObject("statusList", statusList);
			modelAndView.setViewName("processpayments");
			log.info("*** returned processpayments page ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping("/Process Payment/{status}")
	public ModelAndView getVouchers(@PathVariable("status") String status,
			ModelAndView modelAndView) {
		log.info("*** Process Payment Controller ***");
		if (httpSession != null) {
			List<Status> statusList = voucherService.getListStatus();
			modelAndView.addObject("statusList", statusList);
			List<Voucher> vouchers = (List<Voucher>) voucherService
					.getVouchers(status);
			modelAndView.addObject("vouchers", vouchers);
			modelAndView.setViewName("processpayments");

			log.info("*** returned processpayments page ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

}

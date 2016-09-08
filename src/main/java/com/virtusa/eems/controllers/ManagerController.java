package com.virtusa.eems.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
@RequestMapping("/Manager")
public class ManagerController {

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
			HttpServletRequest request, @PathVariable("activity") String activity, @PathVariable("status") String status,
			@PathVariable("voucherId") int voucherId) {
		// httpSession = request.getSession();
		log.info("*** ***");
		if (httpSession != null) {
			String designation = (String) httpSession
					.getAttribute("designation");
			Voucher voucher = voucherService.getVoucher(voucherId);
			voucher.setStatus(status);
			voucherService.updateVoucher(voucher);
			modelAndView.setViewName("redirect:/" + designation
					+ "/"+activity+"/" + status);
			log.info("*** redirected to /" + designation + "/"+activity+"/"
					+ status + " controller ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}


	@RequestMapping(value = "/Manage Vouchers")
	public ModelAndView manageVouchers(ModelAndView modelAndView) {

		log.info("*** Manage Voucher Controller ***");
		if (httpSession != null) {
			List<Status> statusList = voucherService.getListStatus();
			modelAndView.addObject("statusList", statusList);
			modelAndView.setViewName("manageVouchers");
			log.info("*** returned manageVouchers page ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/Manage Vouchers/{status}")
	public ModelAndView getManagerVouchers(
			@PathVariable("status") String status, ModelAndView modelAndView) {
		log.info("*** Manage Voucher/ Status Controller ***");
		if (httpSession != null) {
			List<Status> statusList = voucherService.getListStatus();
			modelAndView.addObject("statusList", statusList);
			Employee employee = (Employee) httpSession.getAttribute("employee");
			List<Employee> employees = employeeService
					.getEmployeesByMID(employee.getEmployeeId());
			List<Voucher> pendingVouchers = new ArrayList<Voucher>();
			for (Employee employee1 : employees) {

				Set<Voucher> vouchers = employee1.getVouchers();
				for (Voucher voucher : vouchers) {
					if (voucher.getStatus().equals(status)) {
						pendingVouchers.add(voucher);
					}
				}
			}
			modelAndView.addObject("vouchers", pendingVouchers);
			log.info("*** returned manageVouchers page ***");
			modelAndView.setViewName("manageVouchers");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

}

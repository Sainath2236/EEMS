package com.virtusa.eems.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.eems.beans.Employee;
import com.virtusa.eems.beans.Status;
import com.virtusa.eems.beans.Voucher;
import com.virtusa.eems.service.EmployeeService;
import com.virtusa.eems.service.VoucherService;
import com.virtusa.eems.validations.CreateVoucherValidator;
import com.virtusa.eems.validations.UpdateVoucherValidator;

@Controller
@RequestMapping("/{designation}/Voucher")
public class VoucherController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private VoucherService voucherService;

	@Autowired
	static HttpSession httpSession;

	@Autowired
	private Validator validator;

	static Logger log = Logger.getLogger(VoucherController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new CreateVoucherValidator());
		binder.addValidators(new UpdateVoucherValidator());
	}

	@RequestMapping("/Create Voucher")
	public ModelAndView voucherCreation(HttpServletRequest request) {
		httpSession = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		if (httpSession != null) {
			log.info("*** Create Voucher Controller ***");
			// httpSession = request.getSession();
			Map<String, String> title = new LinkedHashMap<String, String>();
			Map<Integer, String> level = new LinkedHashMap<Integer, String>();

			title = voucherService.getTitles();
			log.info("*** Titles Returned ***");

			level = voucherService.getLevels();
			log.info("*** Levels Returned ***");

			modelAndView.addObject("voucher", new Voucher());

			modelAndView.addObject("titleList", title);
			modelAndView.addObject("levelList", level);
			modelAndView.setViewName("createVoucher");
			log.info("*** createVoucher Page Returned ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping("/addVoucher")
	public ModelAndView saveVoucher(
			@Validated @ModelAttribute("voucher") Voucher voucher,
			BindingResult result) {
		// httpSession = request.getSession();
		System.out.println("dummi");
		ModelAndView modelAndView = new ModelAndView();
		log.info("*** addVoucher Controller ***");

		if (httpSession != null) {

			if (result.hasErrors()) {
				Map<String, String> title = new LinkedHashMap<String, String>();
				title = voucherService.getTitles();
				log.info("*** Titles Returned ***");
				modelAndView.addObject("titleList", title);
				modelAndView.setViewName("createVoucher");

			} else {
				Employee employee = (Employee) httpSession
						.getAttribute("employee");
				voucher.setEmployeeId(employee.getEmployeeId());

				Voucher voucher1 = voucherService.addVoucher(voucher);
				httpSession.setAttribute("voucher", voucher1);
				String designation = (String) httpSession
						.getAttribute("designation");
				modelAndView.setViewName("redirect:/" + designation
						+ "/Voucher/voucherCreated");
				log.info("*** voucher created successfully and redirected to voucherCreated controller ***");
			}

		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping("/voucherCreated")
	public ModelAndView voucherSuccess() {
		ModelAndView modelAndView = new ModelAndView();
		if (httpSession != null) {
			modelAndView.setViewName("voucherSuccess");
			log.info("*** voucher created successfully and voucherSuccess page returned ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping("/View Vouchers")
	public ModelAndView viewVouchers(HttpServletRequest request) {
		// httpSession = request.getSession();
		// Employee employee = (Employee)httpSession.getAttribute("employee");
		ModelAndView modelAndView = new ModelAndView();
		log.info("*** View Voucher Controller ***");
		httpSession = request.getSession();
		if (httpSession != null) {
			List<Status> statusList = voucherService.getListStatus();
			modelAndView.addObject("statusList", statusList);
			modelAndView.setViewName("viewVouchers");
			log.info("*** returned viewVouchers page ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping("/View Vouchers/{status}")
	public ModelAndView viewSelectedVouchers(
			@PathVariable("status") String status, HttpServletRequest request) {
		// httpSession = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		log.info("*** View Vouchers/" + status + " ***");
		if (httpSession != null) {
			Employee employee = (Employee) httpSession.getAttribute("employee");

			List<Status> statusList = voucherService.getListStatus();
			modelAndView.addObject("statusList", statusList);
			List<Voucher> vouchers = (List<Voucher>) voucherService
					.getAllVouchers(employee.getEmployeeId(), status);
			modelAndView.addObject("vouchers", vouchers);
			modelAndView.setViewName("viewVouchers");
			log.info("***Returned viewVouchers Page with " + status
					+ " vouchers ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	/*
	 * @RequestMapping("/Update Voucher") public ModelAndView
	 * voucherUpdation(HttpServletRequest request){ httpSession =
	 * request.getSession(); Employee employee =
	 * (Employee)httpSession.getAttribute("employee");
	 * 
	 * List<Voucher> vouchers
	 * =voucherService.getAllVouchers(employee.getEmployeeId(),"Rejected");
	 * modelAndView.addObject("vouchers",vouchers);
	 * 
	 * modelAndView.addObject("voucher",new Voucher());
	 * 
	 * modelAndView.setViewName("updateVoucher"); return modelAndView; }
	 */

	@RequestMapping("/update/{voucherId}")
	public ModelAndView voucherUpdation2(
			@PathVariable("voucherId") int voucherId, HttpServletRequest request) {
		// httpSession = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		log.info("*** update/" + voucherId + " controller  ***");

		if (httpSession != null) {
			// Employee employee =
			// (Employee)httpSession.getAttribute("employee");

			Voucher voucher = voucherService.getVoucher(voucherId);

			modelAndView.addObject("voucher", voucher);

			modelAndView.setViewName("updateVoucher");
			log.info("*** returned updateVoucher page ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping("/update")
	public ModelAndView voucherUpdation3(@Validated @ModelAttribute("voucher") Voucher voucher,
			BindingResult result) {
		// httpSession = request.getSession();
		log.info("*** ***");
		ModelAndView modelAndView = new ModelAndView();
		if (httpSession != null) {
			if(result.hasErrors()) {
				modelAndView.setViewName("updateVoucher");
			} else {
				Voucher voucher1 = voucherService
						.getVoucher(voucher.getVoucherId());
				voucher1.setDescription(voucher.getDescription());
				voucher1.setAmount(voucher.getAmount());
				voucher1.setStatus("Pending");
				Voucher voucher2 = voucherService.updateVoucher(voucher1);

				modelAndView.addObject("voucher", voucher2);

				modelAndView.setViewName("updateVoucherSuccess");
				log.info("*** returned updateVoucherSuccess ***");
			}
			
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping("/{status}/{voucherId}")
	public ModelAndView cancelVoucher(HttpServletRequest request,
			@PathVariable("status") String status,
			@PathVariable("voucherId") int voucherId) {
		// httpSession = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		log.info("*** ***");
		if (httpSession != null) {
			String designation = (String) httpSession
					.getAttribute("designation");
			Voucher voucher = voucherService.getVoucher(voucherId);
			voucher.setStatus(status);
			voucherService.updateVoucher(voucher);
			modelAndView.setViewName("redirect:/" + designation
					+ "/Voucher/View Vouchers/" + status);
			log.info("*** redirected to /" + designation + "/View Vouchers/"
					+ status + " controller ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}
}

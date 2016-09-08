package com.virtusa.eems.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.eems.beans.Employee;
import com.virtusa.eems.service.EmployeeService;
import com.virtusa.eems.service.VoucherService;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private VoucherService voucherService;

	@Autowired
	static HttpSession httpSession;

	static Logger log = Logger.getLogger(EmployeeController.class);

	@RequestMapping("/home")
	public ModelAndView employeeLogin(ModelAndView modelAndView,
			HttpServletRequest request) {
		log.info("***Employee Home***");
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


}

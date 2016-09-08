package com.virtusa.eems.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.eems.beans.BankAccount;
import com.virtusa.eems.beans.Employee;
import com.virtusa.eems.service.EmployeeService;
import com.virtusa.eems.service.VoucherService;
import com.virtusa.eems.validations.BankAccountValidator;

@Controller
@RequestMapping("/{designation}/Bank")
public class BankAccountController {
	@Autowired
	private Validator validator;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private VoucherService voucherService;

	@Autowired
	static HttpSession httpSession;

	static Logger log = Logger.getLogger(BankAccountController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new BankAccountValidator());
	}

	@RequestMapping("/Bank Account")
	public ModelAndView addBankAccount(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		httpSession = request.getSession();
		if (httpSession != null) {
			log.info("*** Bank Account Conroller ***");
			Employee employee = (Employee) httpSession.getAttribute("employee");

			if (employee.getAccountNumber() == null) {
				modelAndView.addObject("bankAccount", new BankAccount());
				modelAndView.setViewName("bankaccount");
			} else {
				String designation = (String) httpSession
						.getAttribute("designation");
				modelAndView.setViewName("redirect:/" + designation
						+ "/Bank/bankAccount");
			}
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}

		return modelAndView;

	}

	@RequestMapping("/addBankAccount")
	public ModelAndView insertBankAccount(
			@Validated @ModelAttribute("bankAccount") BankAccount bankAccount,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (httpSession != null) {
			if (result.hasErrors()) {
				modelAndView.setViewName("bankaccount");
			} else {
				Employee employee = (Employee) httpSession
						.getAttribute("employee");
				employee.setAccountNumber(bankAccount.getAccountNumber());
				employeeService.addBankAccount(bankAccount);
				employeeService.updateEmployee(employee);
				// httpSession.setAttribute("bankAccount", bankAccount2);
				String designation = (String) httpSession
						.getAttribute("designation");
				modelAndView.setViewName("redirect:/" + designation
						+ "/Bank/bankAccount");
				log.info("*** redirected to /" + designation
						+ "/Bank/bankAccount controller ***");
			}
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		// bService.updateBankAccount(account);
		return modelAndView;
	}

	@RequestMapping("/bankAccount")
	public ModelAndView bankAccountSuccess() {
		ModelAndView modelAndView = new ModelAndView();
		if (httpSession != null) {
			Employee employee = (Employee) httpSession.getAttribute("employee");
			BankAccount bankAccount = employeeService.getBankAccount(employee
					.getAccountNumber());
			modelAndView.addObject("bankAccount", bankAccount);
			modelAndView.setViewName("bankaccountSuccess");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}

		return modelAndView;
	}

	@RequestMapping("/Bank Account/update")
	public ModelAndView updateBankAccount() {
		ModelAndView modelAndView = new ModelAndView();
		if (httpSession != null) {
			Employee employee = (Employee) httpSession.getAttribute("employee");
			BankAccount bankAccount = employeeService.getBankAccount(employee
					.getAccountNumber());
			modelAndView.addObject("bankAccount", bankAccount);
			modelAndView.setViewName("bankaccount");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}

		return modelAndView;

	}

	@RequestMapping("/updateBankAccount")
	public ModelAndView updateBankAccount(
			@Validated @ModelAttribute("bankAccount") BankAccount bankAccount,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (httpSession != null) {
			if (result.hasErrors()) {
				modelAndView.setViewName("bankaccount");
			} else {
				Employee employee = (Employee) httpSession
						.getAttribute("employee");

				if (employee.getAccountNumber().equals(
						bankAccount.getAccountNumber())) {
					employeeService.updateBankAccount(bankAccount);
				} else {
					BankAccount bankAccount1 = employeeService
							.getBankAccount(employee.getAccountNumber());
					employeeService.deleteBankAccount(bankAccount1);
					employee.setAccountNumber(bankAccount.getAccountNumber());

					employeeService.addBankAccount(bankAccount);
					employeeService.updateEmployee(employee);
				}
				// httpSession.setAttribute("bankAccount", bankAccount2);
				String designation = (String) httpSession
						.getAttribute("designation");
				modelAndView.setViewName("redirect:/" + designation
						+ "/Bank/bankAccount");
				log.info("*** redirected to /" + designation
						+ "/Bank/bankAccount controller ***");
			}

		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		// bService.updateBankAccount(account);
		return modelAndView;
	}

}

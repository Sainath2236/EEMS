package com.virtusa.eems.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.eems.beans.Activity;
import com.virtusa.eems.beans.Designation;
import com.virtusa.eems.beans.Employee;
import com.virtusa.eems.service.EmployeeService;
import com.virtusa.eems.validations.RegistrationValidator;

@Controller
@RequestMapping("/")
public class LoginAndRegistrationControllers {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private Validator validator;

	@Autowired
	static HttpSession httpSession;

	static Logger log = Logger.getLogger(LoginAndRegistrationControllers.class);

	@RequestMapping("/")
	public ModelAndView getIndex(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employee", new Employee());
		modelAndView.setViewName("index");
		log.info("*** Home Page ***");
		return modelAndView;
	}

	@RequestMapping("/registration")
	public ModelAndView register() {
		log.info("*** Registration Controller ***");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView = toGenerateView();
		modelAndView.addObject("employee", new Employee());
		modelAndView.setViewName("registration");
		log.info("*** returned registration page ***");
		return modelAndView;
	}

	@RequestMapping(value = "/checkemail", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Employee checkEmail(HttpServletRequest request, Model model,@RequestParam("email") String email) {
		System.out.println("email value.................." + email);
		Employee employee = employeeService.getEmployee(email);
		System.out.println("..........................." + employee);
		return employee;
	}

	@RequestMapping(value = "/checkemployeeId", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	Employee checkEmployeeId(HttpServletRequest request, Model model,@RequestParam("employeeId") int employeeId) {
		System.out.println("email value.................."
				+ employeeId);
		Employee employee = employeeService.getEmployee(employeeId);
		System.out.println("..........................." + employee);
		return employee;
	}

	public ModelAndView toGenerateView() {
		ModelAndView modelAndView = new ModelAndView();
		Map<Integer, String> departments = employeeService.getDepartments();
		departments.put(0, "Select");
		Map<Integer, String> designations = employeeService.getDesignations();
		designations.put(0, "Select");
		Map<String, String> genders = employeeService.getGender();
		modelAndView.addObject("designations", designations);
		modelAndView.addObject("departments", departments);
		modelAndView.addObject("genders", genders);
		return modelAndView;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new RegistrationValidator());
	/*	binder.addValidators(new LoginValidator());
		binder.addValidators(new CreateVoucherValidator());*/
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerEmployee(HttpServletRequest request,
			@Validated @ModelAttribute("employee") Employee employee,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView = toGenerateView();
			modelAndView.setViewName("registration");
			return modelAndView;

		} else {
			httpSession = request.getSession();
			log.info("*** register controller ***");
			List<Employee> employees = employeeService.getEmployees();
			for (Employee employee1 : employees) {
				log.info("*** checking for availability of employee id ***");
				if (employee1.getEmployeeId() == employee.getEmployeeId()
						|| employee1.getEmail().equals(employee.getEmail())) {
					modelAndView = register();
					modelAndView.addObject("employee", employee);
					if (employee1.getEmployeeId().intValue() == employee
							.getEmployeeId().intValue()) {
						modelAndView
								.addObject("status",
										"Employee Id is unavailable or already registered");
						log.info("*** Employee Id is unavailable or already registered and returned to registration page ***");
					} else if (employee1.getEmail().equals(employee.getEmail())) {
						modelAndView
								.addObject("status",
										"Email ID is unavailable or already registered");
						log.info("*** Email ID is unavailable or already registered and returned to registration page ***");
					}
					modelAndView.setViewName("registration");

					return modelAndView;
				}
			}
			log.info("*** Employee Id is available ***");
			String status = "";
			Employee employee2 = employeeService.getManager(
					employee.getDepartmentId(), 8020000);
			if (employee2 != null) {
				employee.setManagerId(employee2.getEmployeeId());
			}
			status = employeeService.registerEmployee(employee);
			/*
			 * } catch (RegistrationConstraintException e) { modelAndView
			 * .addObject("Status",
			 * "Employee Id is unavailable or email id is already registered");
			 * modelAndView.addObject("employee", employee);
			 * modelAndView.setViewName("registration"); log.info(
			 * "*** email or employeeId is not available and returned to registration page ***"
			 * ); return modelAndView; }
			 */
			httpSession.setAttribute("status", status);
			modelAndView.setViewName("redirect:/registrationSuccess");
			log.info("*** registration success and redirected to registrationSuccess Controller ***");
			return modelAndView;
		}
	}

	@RequestMapping("/registrationSuccess")
	public ModelAndView registrationSuccess() {
		ModelAndView modelAndView = new ModelAndView();
		if (httpSession != null) {
			modelAndView.setViewName("success");
			log.info("*** registration success and returned to success page ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping("/login")
	public String intialPage(Model model) {
		log.info("*** login Controller ***");
		model.addAttribute("employee", new Employee());
		return "login";

	}

	@RequestMapping("/loginFailed")
	public ModelAndView login(@ModelAttribute Employee employee,
			HttpServletRequest request) {
		log.info("*** Checking login credentials ***");
		ModelAndView modelAndView = new ModelAndView();
		httpSession = request.getSession();
		modelAndView.addObject("employee", new Employee());

		if (employee.getEmployeeId() != null) {
			log.info("*** before checking credentials ***");
			Employee employeeTemp = employeeService.login(
					employee.getEmployeeId(), employee.getPassword());
			if (employeeTemp != null) {
				log.info("*** after checking credentials ***");
				employeeTemp.getEmployeeId();
				List<Activity> activities = employeeService
						.getEmployeeActivities(employeeTemp.getEmployeeId());
				System.out.println(activities);
				Designation designation = employeeService
						.getDesignation(employeeTemp.getEmployeeId());
				httpSession.setAttribute("designationId",
						designation.getDesignationId());
				httpSession.setAttribute("designation",
						designation.getDesignationName());
				httpSession.setAttribute("employee", employeeTemp);
				httpSession.setAttribute("activities", activities);
				// modelAndView.addObject("activities", activities);

				modelAndView.setViewName("redirect:/"
						+ designation.getDesignationName() + "/home");
				log.info("*** login success and redirected to /"
						+ designation.getDesignationName()
						+ "/home controller  ***");
				return modelAndView;

			} else {

				modelAndView.addObject("message",
						"Invalid Employee Id or Password");
				modelAndView.setViewName("index");
				log.info("*** Invalid login credentials and returned to index or login page ***");
				return modelAndView;
			}
		} else {
			modelAndView.addObject("message",
					"Employee Id or Password can't be empty");
			modelAndView.setViewName("index");
			log.info("*** Password or employee id is empty and returned to index or login page ***");
			return modelAndView;
		}
	}
	@RequestMapping("/about")
	public ModelAndView aboutUs() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("about");
		return modelAndView;
	}
	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact");
		return modelAndView;
	}
}

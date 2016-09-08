package com.virtusa.eems.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.virtusa.eems.file.download.CreatePdf;
import com.virtusa.eems.service.EmployeeService;
import com.virtusa.eems.service.VoucherService;

@Controller
@RequestMapping("/Admin")
public class AdminController {

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

	@RequestMapping("/Manage Employee")
	public ModelAndView manageEmployees(ModelAndView modelAndView) {

		if (httpSession != null) {

			List<Employee> employees = employeeService.getEmployees();
			modelAndView.addObject("employees", employees);
			modelAndView.setViewName("manageEmployees");

		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}

		return modelAndView;
	}

	@RequestMapping("/Manage Employee/delete/{employeeId}")
	public ModelAndView removeEmployees(
			@PathVariable("employeeId") int employeeId,
			ModelAndView modelAndView) {

		if (httpSession != null) {
			Employee employee = employeeService.getEmployee(employeeId);
			employeeService.deleteEmployee(employee);
			modelAndView.addObject("status", "Employee deleted successfully");
			List<Employee> employees = employeeService.getEmployees();
			modelAndView.addObject("employees", employees);
			modelAndView.setViewName("manageEmployees");

		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}

		return modelAndView;
	}

	@RequestMapping("/Manage Vouchers")
	public ModelAndView manageVouchers(ModelAndView modelAndView) {
		if (httpSession != null) {

			List<Status> statusList = voucherService.getListStatus();
			modelAndView.addObject("statusList", statusList);
			modelAndView.setViewName("manageVouchersAdmin");
			log.info("*** returned manageVouchersAdmin page ***");

		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}

		return modelAndView;
	}

	@RequestMapping("/Manage Vouchers/{status}")
	public ModelAndView viewSelectedVouchers(ModelAndView modelAndView,
			@PathVariable("status") String status, HttpServletRequest request) {
		// httpSession = request.getSession();
		log.info("*** View Vouchers/" + status + " ***");
		if (httpSession != null) {
			List<Status> statusList = voucherService.getListStatus();
			modelAndView.addObject("statusList", statusList);
			List<Voucher> vouchers = (List<Voucher>) voucherService
					.getVouchers(status);
			modelAndView.addObject("status", status);
			modelAndView.addObject("vouchers", vouchers);
			modelAndView.setViewName("manageVouchersAdmin");
			log.info("***Returned manageVouchersAdmin Page with " + status
					+ " vouchers ***");
		} else {
			modelAndView.setViewName("re-login");
			log.info("*** No session Found  ***");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/Manage Vouchers/{status}/List/{excelName}")
	public ModelAndView downloadExcelVouchers(ModelAndView modelAndView,
			@PathVariable("status") String status) {

		List<Voucher> vouchers = (List<Voucher>) voucherService
				.getVouchers(status);

		modelAndView.addObject("vouchersList", vouchers);
		modelAndView.setViewName("VoucherListExcelBuilder");
		return modelAndView;
	}

	@RequestMapping(value = "/Manage Vouchers/{voucherId}/One/{excelName}")
	public ModelAndView downloadExcelVoucher(ModelAndView modelAndView,
			@PathVariable("voucherId") int voucherId) {

		Voucher voucher = voucherService.getVoucher(voucherId);

		modelAndView.addObject("voucher", voucher);
		modelAndView.setViewName("VoucherExcelBuilder");
		return modelAndView;
	}

	@RequestMapping(value = "/Manage Vouchers/{voucherId}/downloadPDF")
	public void downloadPDF(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("voucherId") int voucherId) throws IOException {
		if (httpSession != null) {
			final ServletContext servletContext = httpSession
					.getServletContext();
			final File tempDirectory = (File) servletContext
					.getAttribute("javax.servlet.context.tempdir");
			final String temperotyFilePath = tempDirectory.getAbsolutePath();

			String fileName = "Voucher-" + voucherId;
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName);
			Voucher voucher = voucherService.getVoucher(voucherId);
			try {
				CreatePdf createPdf = new CreatePdf();
				createPdf.createPDF(temperotyFilePath + "\\" + fileName,
						voucher);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos = createPdf
						.convertPDFToByteArrayOutputStream(temperotyFilePath
								+ "//" + fileName);
				OutputStream os = response.getOutputStream();
				baos.writeTo(os);
				os.flush();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

}

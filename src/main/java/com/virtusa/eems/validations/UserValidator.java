package com.virtusa.eems.validations;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.virtusa.eems.beans.Employee;

public class UserValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$";
	String passwordExp = "^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z]).{10}$";
	String employeeIdExp = "^(?=.*[0-9]).{7}$";
	String PHONE_PATTERN = "^[978]{1}[0-9]{9}$";
	String STRING_PATTERN = "[a-zA-Z]+";
	String DOBPattern = "^[0-9]{2}[0-9]{2}[0-9]{4}$";

	public boolean supports(Class<?> clazz) {
		// register your class your validation
		System.out.println("user validator support method*****");
		return Employee.class.equals(clazz);
	}

	@SuppressWarnings("deprecation")
	public void validate(Object object, Errors errors) {// our validation
		System.out.println("user validator valid method********");
		Employee employee = (Employee) object;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId",
				"required.employeeId", "employeeId cannot  be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"required.name", "name cannot  be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender",
				"required.gender", "gender is not selected");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "email cannot be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "password cannot be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber",
				"required.contactNumber", "contact number cannot be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob",
				"required.dob", "dob cannot be empty");
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designationId",
				"required.designationId", "designationId cannot be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departmentId",
				"required.departmentId", "departmentId cannot be empty");*/

		if (!(employee.getEmployeeId() != null)
				&& (employee.getEmployeeId().toString().isEmpty())) {
			pattern = Pattern.compile(employeeIdExp);
			matcher = pattern.matcher(employee.getEmployeeId().toString());
			if (!matcher.matches()) {
				errors.rejectValue("employeeId", "employeeId.incorrect",
						"Employee Id must be number only");
			} else if (employee.getEmployeeId().toString().length() != 7) {
				errors.rejectValue("employeeId", "employeeId.exceed",
						"Employee Id length must be 7");
			}
		}
		
		if (!(employee.getName() != null && employee.getName().isEmpty())) 
		 {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(employee.getName());  
			   if (!matcher.matches())
			   {  
			    errors.rejectValue("name", "name.containNonChar",  
			      "Name must be Characters");  
		       }  
		 }

		if (!(employee.getEmail() != null && employee.getEmail().isEmpty())) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(employee.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "email.incorrect",
						"Email should in the format example@mail.com");
			}
		}

		if (!((employee.getPassword()!= null) && (employee.getPassword().isEmpty()))) {  
			pattern = Pattern.compile(passwordExp);  
		    matcher = pattern.matcher(employee.getPassword());  
		    if (!matcher.matches()) 
		    {  
				 errors.rejectValue("password", "password.incorrect","Enter a correct password");  
			} else if(employee.getPassword().toString().length() != 10){
		    	 errors.rejectValue("password", "password.exceed","Password length must be 10");
		     }
		 }
		

		if (!(employee.getContactNumber() != null && employee.getContactNumber().toString().isEmpty())) {
			pattern = Pattern.compile(PHONE_PATTERN);
			matcher = pattern.matcher(employee.getContactNumber());
			if (!matcher.matches()) {
				errors.rejectValue("contactNumber", "contactNumber.incorrect",
						"Contact Number should be number only and of length 10");
			}
		}
		
		if (!(employee.getDob() != null && employee.getDob().toString().isEmpty())) {
			pattern = Pattern.compile(DOBPattern);
			matcher = pattern.matcher(employee.getDob().toString());
			if (!matcher.matches()) {
				errors.rejectValue("dob", "dob.incorrect",
						"Invalid date");
			} else {
				int dayfield = Integer.parseInt(employee.getDob().toString().split("/")[0]);
				int monthfield = Integer.parseInt(employee.getDob().toString().split("/")[1]);
				int yearfield = Integer.parseInt(employee.getDob().toString().split("/")[2]);
				Date dayobj = new Date(yearfield, monthfield - 1, dayfield);
				if (((dayobj.getMonth() + 1) != monthfield)
						|| (dayobj.getDate() != dayfield)
						|| (dayobj.getYear() != yearfield)) {
					//alertString += "Invalid Day, Month, or Year range detected. Please correct and submit again.\n";
					errors.rejectValue("dob", "dob.incorrect",
							"Invalid Day, Month, or Year range detected. Please correct and submit again.");
				}
			}
		}
		
		if ((employee.getDepartmentId() == 0)){
                    errors.rejectValue("departmentId", "departmentId.incorrect",
						"department id is not selected");
			}
		
		if ((employee.getDesignationId() == 0)){
            errors.rejectValue("designationId", "designationId.incorrect",
				"designation id is not selected");
	}
		}
	}


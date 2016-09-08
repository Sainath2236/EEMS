package com.virtusa.eems.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.virtusa.eems.beans.Employee;

public class LoginValidator implements Validator {

	private Pattern pattern;  
	 private Matcher matcher; 
  
	String passwordExp="^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z]).{10}$";
	String employeeIdExp = "^(?=.*[0-9]).{7}$";
	
	public boolean supports(Class<?> clazz)
	{
		//register your class your validation
		System.out.println("user validator support method*****");
		return Employee.class.equals(clazz);
	}

	public void validate(Object object, Errors errors)
	{//our validation
		System.out.println("user validator valid method********");
		Employee employee=(Employee)object;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "required.employeeId","Employee Id cannot be empty\n");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","required.password","password cannot  be empty\n");
		
		if (!(employee.getEmployeeId()!= null) && (employee.getEmployeeId().toString().isEmpty())) {  
			pattern = Pattern.compile(employeeIdExp);  
		    matcher = pattern.matcher(employee.getEmployeeId().toString());  
		    if (!matcher.matches()) 
		    {  
				 errors.rejectValue("employeeId", "employeeId.incorrect","Enter a correct Employee Id");  
			} 
		    else if(employee.getEmployeeId().toString().length() != 7){
		    	 errors.rejectValue("employeeId", "employeeId.exceed","Employee Id length must be 7");
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
		
	 }
}

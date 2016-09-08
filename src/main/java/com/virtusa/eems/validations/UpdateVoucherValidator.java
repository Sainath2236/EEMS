package com.virtusa.eems.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.virtusa.eems.beans.Voucher;

public class UpdateVoucherValidator implements Validator {

	
	public boolean supports(Class<?> clazz)
	{
		
		System.out.println("user validator support method*****");
		return Voucher.class.equals(clazz);
	}

	public void validate(Object object, Errors errors)
	{
		System.out.println("user validator valid method********");
		Voucher voucher = (Voucher) object;
		ValidationUtils.rejectIfEmpty(errors, "description", "required.description","description cannot be empty\n");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"amount","required.amount","amount cannot  be empty\n");
		
		
		if (voucher.getDescription().length() == 1) {
			if (voucher.getDescription().charAt(0) == ' ') {
				errors.rejectValue("description", "description.incorrect",
						"Description cannot be empty");
			}
		}
		
		if (voucher.getAmount() == 0) {  
			
			 errors.rejectValue("amount", "amount.incorrect","Amount cannot be 0.0");   
		    
		 }else if(voucher.getAmount() < 0) {  
			
			 errors.rejectValue("amount", "amount.incorrect","Amount cannot be Negative");
			 
		 } else if(voucher.getAmount() > 1000000) {  
			
			 errors.rejectValue("amount", "amount.incorrect","You cannot claim more than 10 lakhs");
		 }
		
	 }
}


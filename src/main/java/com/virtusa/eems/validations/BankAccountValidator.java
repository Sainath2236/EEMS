package com.virtusa.eems.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.virtusa.eems.beans.BankAccount;

public class BankAccountValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	String passwordExp = "^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z]).{10}$";
	String accountNumberExp = "[0-9]+";
	String STRING_PATTERN = "[a-zA-Z]+";
	String IFSC_PATTERN = "^[A-Z]{4}[0-9]{7}$";

	public boolean supports(Class<?> clazz) {
		// register your class your validation
		System.out.println("user validator support method*****");
		return BankAccount.class.equals(clazz);
	}

	public void validate(Object object, Errors errors) {// our validation
		System.out.println("user validator valid method********");
		BankAccount bankAccount = (BankAccount) object;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountNumber",
				"required.accountNumber", "Account Number cannot be empty\n");
		ValidationUtils.rejectIfEmpty(errors, "accountName",
				"required.accountName", "Account Name cannot  be empty\n");
		ValidationUtils.rejectIfEmpty(errors, "bankName", "required.bankName",
				"Bank Name cannot be empty\n");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "iFSCCode",
				"required.iFSCCode", "IFSC Code cannot be empty\n");
		ValidationUtils.rejectIfEmpty(errors, "branch", "required.branch",
				"Branch cannot be empty");

		if (!(bankAccount.getAccountNumber() != null && bankAccount.getAccountNumber().isEmpty())) {
			pattern = Pattern.compile(accountNumberExp);
			//String tempEmpId = bankAccount.getAccountNumber().toString();
			matcher = pattern.matcher(bankAccount.getAccountNumber().toString());
			if (!matcher.matches()) {
				errors.rejectValue("accountNumber", "accountNumber.incorrect",
						"Account Number must be number only");
			} else if (bankAccount.getAccountNumber().length() != 16) {
				errors.rejectValue("accountNumber", "accountNumber.exceed",
						"Account Number length must be 16");
			}
		}
		
		if (!(bankAccount.getAccountName() != null && bankAccount
				.getAccountName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(bankAccount.getAccountName());
			if (!matcher.matches()) {
				errors.rejectValue("accountName", "accountName.containNonChar",
						"Account Name must be Characters");
			}
		}
		if (!(bankAccount.getBankName() != null && bankAccount.getBankName()
				.isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(bankAccount.getBankName());
			if (!matcher.matches()) {
				errors.rejectValue("bankName", "bankName.containNonChar",
						"Bank Name must be Characters");
			}
		}
		if (!(bankAccount.getiFSCCode() != null && bankAccount.getiFSCCode()
				.isEmpty())) {
			pattern = Pattern.compile(IFSC_PATTERN);
			matcher = pattern.matcher(bankAccount.getiFSCCode());
			if (!matcher.matches()) {
				errors.rejectValue("iFSCCode", "iFSCCode.containNonChar",
						"IFSC Code  must be alpha numberic only");
			}
		}
		if (!(bankAccount.getBranch() != null && bankAccount.getBranch()
				.isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(bankAccount.getBranch());
			if (!matcher.matches()) {
				errors.rejectValue("branch", "branch.containNonChar",
						"Branch must be Characters");
			}
		}

	}
}

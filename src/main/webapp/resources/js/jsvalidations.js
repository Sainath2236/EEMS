//Registration Form Validations
function validateRegistration() {
	var employeeId = document.getElementById("employeeId").value;
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("confirmPassword").value;
	var contactNumber = document.getElementById("contactNumber").value;
	var dob = document.getElementById("dob").value;
	var departmentId = document.getElementById("departmentId").value;
	var designationId = document.getElementById("designationId").value;
	var alertString = "";

	var emailRegex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{10}$/;

	if (employeeId.length == 0) {
		alertString += "Employee Id cannot be Empty\n";
	} else if (employeeId.charAt(0) == " ") {
		alertString += "Employee Id Should not have spaces\n";
	} else if (isNaN(employeeId)) {
		alertString += "Employee Id must be number only\n";
	} else if (employeeId.length != 7) {
		alertString += "Employee Id must be of length 7 only \n";
	}

	if (name.length == 0) {
		alertString += "Name cannot be Empty\n";
	} else if (name.charAt(0) == " ") {
		alertString += "Name cannot start with a space\n";
	}

	if ((document.EmployeeRegistration.gender[0].checked == false)
			&& (document.EmployeeRegistration.gender[1].checked == false)) {
		alertString += "Please choose your Gender: Male or Female\n";
	}

	if (email.length == 0) {
		alertString += "Email cannot be empty\n";
	} else if (!emailRegex.test(email)) {
		alertString += "Email should in the format example@mail.com\n";
	} else if (email.charAt(0) == " ") {
		alertString += "Email should not start with space\n";
	}

	if (password.length == 0) {
		alertString += "Password cannot be empty\n";
	} else if (!passwordRegex.test(password)) {
		alertString += "Password should contain atlest lower,upper case and a number and must be length more than 5\n";
	}

	if (password != confirmPassword) {
		alertString += "Password do not match\n";
	}

	if (contactNumber.length == 0) {
		alertString += "Contact Number cannot be empty\n";
	} else if (isNaN(contactNumber)) {
		alertString += "Contact Number should be number only\n";
	} else if (contactNumber.length != 10) {
		alertString += "Contact Number should contain 10 digits only\n";
	}

	if (dob.length == 0) {
		alertString += "DOB cannot be empty\n";
	} else {
		var validformat = /^\d{2}\/\d{2}\/\d{4}$/;
		if (!validformat.test(dob)) {
			alertString += "Invalid Date Format. Please correct and submit again.\n";
		} else {

			var dayfield = parseInt(dob.split("/")[1]);
			var monthfield = parseInt(dob.split("/")[0]);
			var yearfield = parseInt(dob.split("/")[2]);
			var dayobj = new Date(yearfield, monthfield - 1, dayfield);
			if (((dayobj.getMonth() + 1) != monthfield)
					|| (dayobj.getDate() != dayfield)
					|| (dayobj.getFullYear() != yearfield)) {
				alertString += "Invalid Day, Month, or Year range detected. Please correct and submit again.\n";
			}

		}
	}

	if (departmentId == 0) {
		alertString += "Department not selected\n";
	}

	if (designationId == 0) {
		alertString += "Designation not selected\n";
	}

	if (alertString.length != 0) {
		alert(alertString);
		return false;
	} else {
		return true;
	}

}

// Voucher Form Validations.
function voucherValidations() {
	var amount = document.getElementById("amount").value;
	var description = document.getElementById("description").value;
	var title = document.getElementById("title").value;

	var msg = "";
	var c = 0;

	if (amount == 0.0) {
		msg += "amount can't be empty(Enter your amount)\n";
		c++;
	} else if (amount < 0) {
		msg += "amount should be positive value\n";
		c++;
	} else if (isNaN(amount)) {
		msg += "amount must be number\n";
		c++;
	} else if (amount > 10000000.0) {
		msg += "You can't claim more than Rs 10,00,000\n";
		c++;
	}

	if (description.length == 0) {
		msg += "Description field can't be empty\n";
		c++;
	}

	if (title == 0) {
		msg += "select a valid title\n";
		c++;
	}

	if (c > 0) {
		alert(msg);
		return false;
	} else {
		return true;
	}

}

// Update Voucher form validations
function updateVoucherValidations() {
	var amount = document.getElementById("amount").value;
	var description = document.getElementById("description").value;
	var msg = "";
	var c = 0;

	if (description.length == 0) {
		msg += "Description field can't be empty\n";
		c++;
	}

	if (amount == 0.0) {
		msg += "amount can't be empty(Enter your amount)\n";
		c++;
	} else if (amount < 0) {
		msg += "amount should be positive value\n";
		c++;
	} else if (isNaN(amount)) {
		msg += "amount must be number\n";
		c++;
	} else if (amount > 10000000.0) {
		msg += "You can't claim more than Rs 10,00,000\n";
		c++;
	}

	if (c > 0) {
		alert(msg);
		return false;
	} else {
		return true;
	}

}

// Bank Account Form Validations
function validateAccount() {
	var accountNumber = document.getElementById("accountNumber").value;
	var accountName = document.getElementById("accountName").value;
	var bankName = document.getElementById("bankName").value;
	var iFSCCode = document.getElementById("iFSCCode").value;
	var branch = document.getElementById("branch").value;
	var alertString = "";

	var iFSCCodeRegex = /^[A-Za-z]{4}[0-9]{7}$/;

	if (accountNumber.length == 0) {
		alertString += "Account Number cannot be Empty\n";
	} else if (accountNumber.charAt(0) == " ") {
		alertString += "Account Number Should not have spaces\n";
	} else if (isNaN(accountNumber)) {
		alertString += "Account Number must be number only\n";
	} else if (accountNumber.length != 16) {
		alertString += "Account Number must be of length 16 only \n";
	}
	if (accountName.length == 0) {
		alertString += "AccountName cannot be Empty\n";
	} else if (accountName.charAt(0) == " ") {
		alertString += "AccountName cannot start with a space\n";
	}
	if (bankName.length == 0) {
		alertString += "BankName cannot be Empty\n";
	} else if (bankName.charAt(0) == " ") {
		alertString += "BankName cannot start with a space\n";
	}
	if (iFSCCode.length == 0) {
		alertString += "iFSCCode cannot be Empty\n";
	} else if (iFSCCode.charAt(0) == " ") {
		alertString += "iFSCCode shouldnot have spaces\n";
	} else if (!iFSCCodeRegex.test(iFSCCode)) {
		alertString += "iFSCCode should be in the format ABCD1234567";
	}

	if (branch.length == 0) {
		alertString += "BranchName cannot be Empty\n";
	} else if (bankName.charAt(0) == " ") {
		alertString += "BranchName cannot start with a space\n";
	}
	if (alertString.length != 0) {
		alert(alertString);
		return false;
	} else {
		return true;
	}
}
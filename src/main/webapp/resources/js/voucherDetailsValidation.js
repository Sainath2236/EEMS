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
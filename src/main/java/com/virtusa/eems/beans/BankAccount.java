package com.virtusa.eems.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BankAccount")
public class BankAccount {
	@Id
	@Column(name = "account_Number", length = 17)
	private String accountNumber;
	@Column(name = "account_Name")
	private String accountName;
	@Column(name = "bank_Name")
	private String bankName;
	@Column(name = "iFSC_Code")
	private String iFSCCode;
	@Column(name = "branch")
	private String branch;

	public BankAccount() {
	}

	public BankAccount(String accountNumber, String accountName,
			String bankName, String iFSCCode, String branch) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.bankName = bankName;
		this.iFSCCode = iFSCCode;
		this.branch = branch;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Boolean setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return true;
	}

	public String getAccountName() {
		return accountName;
	}

	public Boolean setAccountName(String accountName) {
		this.accountName = accountName;
		return true;
	}

	public String getBankName() {
		return bankName;
	}

	public Boolean setBankName(String bankName) {
		this.bankName = bankName;
		return true;
	}

	public String getiFSCCode() {
		return iFSCCode;
	}

	public Boolean setiFSCCode(String iFSCCode) {
		this.iFSCCode = iFSCCode;
		return true;
	}

	public String getBranch() {
		return branch;
	}

	public Boolean setBranch(String branch) {
		this.branch = branch;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountName="
				+ accountName + ", bankName=" + bankName + ", iFSCCode="
				+ iFSCCode + ", branch=" + branch + "]";
	}

}

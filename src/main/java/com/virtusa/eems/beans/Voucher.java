package com.virtusa.eems.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Voucher")
@SequenceGenerator(name = "voucher")
public class Voucher {
	@Id
	@Column(name = "voucher_Id", length = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voucher_id_s")
	@SequenceGenerator(name = "voucher_id_s", sequenceName = "voucher_id_s")
	private Integer voucherId;
	@Column(name = "employee_id", length = 10)
	private int employeeId;
	@Column(name = "Voucher_title", length = 40)
	private String title;
	@Column(name = "description", length = 255)
	private String description;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "Voucher_Date")
	private Date date;
	@Column(name = "amount", length = 10)
	private double amount;
	@Column(name = "Voucher_status", length = 40)
	private String status;
	@Column(name = "Voucher_level", length = 10)
	private int level;

	public Voucher() {
	}

	public Voucher(Integer voucherId, String title, String description,
			Date date, double amount, String status, int level, int employeeId) {
		super();
		this.voucherId = voucherId;
		this.employeeId = employeeId;
		this.title = title;
		this.description = description;
		this.date = date;
		this.amount = amount;
		this.status = status;
		this.level = level;
	}

	public String getTitle() {
		return title;
	}

	public Boolean setTitle(String title) {
		this.title = title;
		return true;
	}

	public String getDescription() {
		return description;
	}

	public Boolean setDescription(String description) {
		this.description = description;
		return true;
	}

	public Date getDate() {
		return date;
	}

	public Boolean setDate(Date date) {
		this.date = date;
		return true;
	}

	public double getAmount() {
		return amount;
	}

	public Boolean setAmount(double amount) {
		this.amount = amount;
		return true;
	}

	public String getStatus() {
		return status;
	}

	public Boolean setStatus(String status) {
		this.status = status;
		return true;
	}

	public int getLevel() {
		return level;
	}

	public Boolean setLevel(int level) {
		this.level = level;
		return true;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public Boolean setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return true;
	}

	public Boolean setVoucherId(Integer voucherId) {
		this.voucherId = voucherId;
		return true;
	}

	public Integer getVoucherId() {
		return voucherId;
	}

	@Override
	public String toString() {
		return "Voucher [voucherId=" + voucherId + ", employeeId=" + employeeId
				+ ", title=" + title + ", description=" + description
				+ ", date=" + date + ", amount=" + amount + ", status="
				+ status + ", level=" + level + "]";
	}

}

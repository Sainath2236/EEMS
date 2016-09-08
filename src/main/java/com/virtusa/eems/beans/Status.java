package com.virtusa.eems.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Voucher_Status")
public class Status {
	@Id
	@Column(name = "status_Id", length = 10)
	private int statusId;
	@Column(name = "status_Name", length = 40)
	private String statusName;

	public Status() {
	}

	public Status(int statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public int getStatusId() {
		return statusId;
	}

	public Boolean setStatusId(int statusId) {
		this.statusId = statusId;
		return true;
	}

	public String getStatusName() {
		return statusName;
	}

	public Boolean setStatusName(String statusName) {
		this.statusName = statusName;
		return true;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusName=" + statusName
				+ "]";
	}

}

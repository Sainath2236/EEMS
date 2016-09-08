package com.virtusa.eems.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Voucher_Title")
public class Title {
	@Id
	@Column(name = "title_Id", length = 10)
	private int titleId;
	@Column(name = "title_Name", length = 40)
	private String titleName;

	public Title() {
	}

	public Title(int titleId, String titleName) {
		super();
		this.titleId = titleId;
		this.titleName = titleName;
	}

	public int getTitleId() {
		return titleId;
	}

	public Boolean setTitleId(int titleId) {
		this.titleId = titleId;
		return true;
	}

	public String getTitleName() {
		return titleName;
	}

	public Boolean setTitleName(String titleName) {
		this.titleName = titleName;
		return true;
	}

	@Override
	public String toString() {
		return "Title [titleId=" + titleId + ", titleName=" + titleName + "]";
	}

}

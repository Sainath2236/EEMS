package com.virtusa.eems.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Gender")
public class Gender {
	@Id
	@Column(name = "type", length = 7)
	private String type;

	public Gender() {
	}

	public Gender(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public Boolean setType(String type) {
		this.type = type;
		return true;
	}

	@Override
	public String toString() {
		return "Gender [type=" + type + "]";
	}

}

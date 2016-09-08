package com.virtusa.eems.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Designations")
public class Designation {
	@Id
	@Column(name = "designation_Id", length = 10)
	private Integer designationId;
	@Column(name = "designation_Name", length = 40)
	private String designationName;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(name = "Designation_Activity", joinColumns = @JoinColumn(name = "designation_Id"), inverseJoinColumns = @JoinColumn(name = "activity_Id"))
	private List<Activity> activities;

	public Designation() {
		

	}

	public Designation(Integer designationId, String designationName,
			List<Activity> activities) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
		this.activities = activities;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public Boolean setDesignationId(Integer designationId) {
		this.designationId = designationId;
		return true;
	}

	public String getDesignationName() {
		return designationName;
	}

	public Boolean setDesignationName(String designationName) {
		this.designationName = designationName;
		return true;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public Boolean setActivities(List<Activity> activities) {
		this.activities = activities;
		return true;
	}

}

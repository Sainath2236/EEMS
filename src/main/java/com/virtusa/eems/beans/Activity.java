package com.virtusa.eems.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Activity")
public class Activity {
	@Id
	@Column(name = "activity_Id", length = 10)
	private Integer activityId;
	@Column(name = "activity_Name", length = 40)
	private String activityName;
	@Column(name = "user_type", length = 10)
	private String userType;

	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "Designation_Activity", joinColumns = @JoinColumn(name = "activityId"), inverseJoinColumns = @JoinColumn(name = "designation_Id"))
	private List<Designation> designations;

	public Activity() {
	}

	public Activity(Integer activityId, String activityName, String userType,
			List<Designation> designations) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.userType = userType;
		this.designations = designations;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public Boolean setActivityId(Integer activityId) {
		this.activityId = activityId;
		return true;
	}

	public String getActivityName() {
		return activityName;
	}

	public Boolean setActivityName(String activityName) {
		this.activityName = activityName;
		return true;
	}

	public List<Designation> getDesignations() {
		return designations;
	}

	public Boolean setDesignations(List<Designation> designations) {
		this.designations = designations;
		return true;
	}

	public String getUserType() {
		return userType;
	}

	public Boolean setUserType(String userType) {
		this.userType = userType;
		return true;
	}


}

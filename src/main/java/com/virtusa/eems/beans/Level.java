package com.virtusa.eems.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Voucher_Levels")
public class Level {
	@Id
	@Column(name = "level_Id", length = 10)
	private int levelId;
	@Column(name = "level_Name", length = 40)
	private String levelName;
	@Column(name = "range", length = 40)
	private String range;

	public Level() {
	}

	public Level(int levelId, String levelName, String range) {
		super();
		this.levelId = levelId;
		this.levelName = levelName;
		this.range = range;
	}

	public int getLevelId() {
		return levelId;
	}

	public Boolean setLevelId(int levelId) {
		this.levelId = levelId;
		return true;
	}

	public String getLevelName() {
		return levelName;
	}

	public Boolean setLevelName(String levelName) {
		this.levelName = levelName;
		return true;
	}

	public String getRange() {
		return range;
	}

	public Boolean setRange(String range) {
		this.range = range;
		return true;
	}

	@Override
	public String toString() {
		return "Level [levelId=" + levelId + ", levelName=" + levelName
				+ ", range=" + range + "]";
	}

}

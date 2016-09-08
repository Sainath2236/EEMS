package com.virtusa.eems.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@Column(name = "address_Id")
	private int addressId;
	@Column(name = "house_No")
	private int houseNo;
	@Column(name = "Street")
	private String Street;
	@Column(name = "City")
	private String city;
	@Column(name = "State")
	private String State;
	@Column(name = "pin_Code")
	private long pinCode;

	public int getAddressId() {
		return addressId;
	}

	public Boolean setAddressId(int addressId) {
		this.addressId = addressId;
		return true;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public Boolean setHouseNo(int houseNo) {
		this.houseNo = houseNo;
		return true;
	}

	public String getStreet() {
		return Street;
	}

	public Boolean setStreet(String street) {
		Street = street;
		return true;
	}

	public String getCity() {
		return city;
	}

	public Boolean setCity(String city) {
		this.city = city;
		return true;
	}

	public String getState() {
		return State;
	}

	public Boolean setState(String state) {
		State = state;
		return true;
	}

	public long getPinCode() {
		return pinCode;
	}

	public Boolean setPinCode(long pinCode) {
		this.pinCode = pinCode;
		return true;
	}

}

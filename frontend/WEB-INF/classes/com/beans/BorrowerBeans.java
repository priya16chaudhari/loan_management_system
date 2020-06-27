package com.beans;

public class BorrowerBeans {

	int id;
	String name,mobile,vehicleNumber,address,createdDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public BorrowerBeans(int id, String name, String mobile, String vehicleNumber, String address, String createdDate) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.vehicleNumber = vehicleNumber;
		this.address = address;
		this.createdDate = createdDate;
	}
	public BorrowerBeans() {
	
	}
	@Override
	public String toString() {
		return "BorrowerBeans [id=" + id + ", name=" + name + ", mobile=" + mobile + ", vehicleNumber=" + vehicleNumber
				+ ", address=" + address + ", createdDate=" + createdDate + "]";
	}
}

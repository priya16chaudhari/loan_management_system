package com.beans;

public class GauranterBeans {

	String id, name, mobile, address,createdDate;

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public GauranterBeans(String id, String name, String mobile, String address, String createdDate) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.createdDate = createdDate;
	}

	public GauranterBeans() {
	}

	@Override
	public String toString() {
		return "GauranterBeans [id=" + id + ", name=" + name + ", mobile=" + mobile + ", address=" + address
				+ ", createdDate=" + createdDate + "]";
	}

}
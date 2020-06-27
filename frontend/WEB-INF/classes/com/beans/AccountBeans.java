package com.beans;

public class AccountBeans {
	int id;
	String borrowerId, loanAmount, instantDeduction, emi, duration, startDate, endDate, status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getInstantDeduction() {
		return instantDeduction;
	}

	public void setInstantDeduction(String instantDeduction) {
		this.instantDeduction = instantDeduction;
	}

	public String getEmi() {
		return emi;
	}

	public void setEmi(String emi) {
		this.emi = emi;
	}
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	public void setFine(String fine) {
		this.duration = duration;
	}
	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AccountBeans(String borrowerId, String loanAmount, String instantDeduction, String emi, String duration,
			String startDate, String endDate, String status) {

		this.borrowerId = borrowerId;
		this.loanAmount = loanAmount;
		this.instantDeduction = instantDeduction;
		this.emi = emi;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public AccountBeans() {

	}

	@Override
	public String toString() {
		return "AccountBeans [borrowerId=" + borrowerId + ", loanAmount=" + loanAmount + ", instantDeduction="
				+ instantDeduction + ", emi=" + emi + ", duration=" + duration + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}

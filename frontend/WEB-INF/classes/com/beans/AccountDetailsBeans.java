package com.beans;

public class AccountDetailsBeans {
	
	String accountId,dateOfPayment,timeOfPayment,amount,fineCharge;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(String dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public String getTimeOfPayment() {
		return timeOfPayment;
	}

	public void setTimeOfPayment(String timeOfPayment) {
		this.timeOfPayment = timeOfPayment;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getFineCharge() {
		return fineCharge;
	}

	public void setFineCharge(String fineCharge) {
		this.fineCharge = fineCharge;
	}
	public AccountDetailsBeans(String accountId, String dateOfPayment, String timeOfPayment, String amount,String fineCharge) {
		this.accountId = accountId;
		this.dateOfPayment = dateOfPayment;
		this.timeOfPayment = timeOfPayment;
		this.amount = amount;
		this.fineCharge=fineCharge;
	}

	public AccountDetailsBeans() {
		
	}

	@Override
	public String toString() {
		return "AccountDetailsBeans [accountId=" + accountId + ", dateOfPayment=" + dateOfPayment + ", timeOfPayment="
				+ timeOfPayment + ", amount=" + amount + ",fineCharge="+fineCharge+"]";
	}
	
	

}

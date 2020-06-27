package com.lms.lms.dto;

import java.util.Date;

public class BusinessLoanDto {

    private Integer businessLoanId;
    private String name;
    private String address;
    private String cno;
    private Integer loanAmount;
    private Integer returnAmount;
    private Date returnDate;
    private Date currentDate;
    private String status;
    private Double percent;
    private Date alertdate;

    public Date getAlertdate() {
        return alertdate;
    }

    public void setAlertdate(Date alertdate) {
        this.alertdate = alertdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Integer getBusinessLoanId() {
        return businessLoanId;
    }

    public void setBusinessLoanId(Integer businessLoanId) {
        this.businessLoanId = businessLoanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(Integer returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

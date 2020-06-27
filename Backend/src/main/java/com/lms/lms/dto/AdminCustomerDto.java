package com.lms.lms.dto;

import java.util.Date;

public class AdminCustomerDto {

    private Integer customerId;
    private String name;
    private String accNo;
    private Date returnDate;
//    private Integer loanDuration;
    private Integer targetAmt;
    private Integer dailyAmt;
    private String status;
    private Integer remainAmt;

    private Integer totaldailyAmt;

    public Integer getTotaldailyAmt() {
        return totaldailyAmt;
    }

    public void setTotaldailyAmt(Integer totaldailyAmt) {
        this.totaldailyAmt = totaldailyAmt;
    }

    private String newStatus;

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    private Date curDate;
    private Integer emi;

    public Integer getEmi() {
        return emi;
    }

    public void setEmi(Integer emi) {
        this.emi = emi;
    }

    public Date getCurDate() {
        return curDate;
    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }



    public Integer getRemainAmt() {
        return remainAmt;
    }

    public void setRemainAmt(Integer remainAmt) {
        this.remainAmt = remainAmt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDailyAmt() {
        return dailyAmt;
    }

    public void setDailyAmt(Integer dailyAmt) {
        this.dailyAmt = dailyAmt;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

//    public Integer getLoanDuration() {
//        return loanDuration;
//    }
//
//    public void setLoanDuration(Integer loanDuration) {
//        this.loanDuration = loanDuration;
//    }

    public Integer getTargetAmt() {
        return targetAmt;
    }

    public void setTargetAmt(Integer targetAmt) {
        this.targetAmt = targetAmt;
    }
}

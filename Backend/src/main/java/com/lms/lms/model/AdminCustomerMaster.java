package com.lms.lms.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AdminCustomerMaster")
public class AdminCustomerMaster {

    @Id
    @GeneratedValue
    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "customername")
    private String name;


    @Column(name = "borroweraccountNo")
    private String accNo;


    @Column(name="returndate")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

//    @Column(name = "loan_duration")
//    private Integer loanDuration;

    @Column(name = "targetamt")
    private Integer targetAmt;

    @Column(name = "dailyamt")
    private Integer dailyAmt;

    @Column(name = "statusall")
    private String status;


    @Column(name = "remainamt")
    private Integer remainAmt;

//    @Column(name = "pending_days")
//    private Integer pendingdaycnt;


    @Column(name="currrdate")
    @Temporal(TemporalType.DATE)
    private Date curDate;

    @Column(name = "emi")
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

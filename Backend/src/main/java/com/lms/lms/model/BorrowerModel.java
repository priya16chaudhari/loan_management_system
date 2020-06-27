package com.lms.lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BorrowerMaster")
public class BorrowerModel {
    @Id
    @GeneratedValue
    @Column(name = "borrower_id")
    private Integer borrowerId;

    @Column(name = "borrower_name")
    private String name;

    @Column(name = "borrower_contactNo")
    private String cno;

    @Column(name = "borrower_address")
    private String address;

    @Column(name = "borrower_accountNo")
    private String accNo;

    @Column(name = "borrower_vehiclenum")
    private String borrowervehiclenum;

    @Column(name = "borrower_loan_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "guaranteer_name")
    private String gname;

    @Column(name = "guaranteer_contact_No")
    private String gcno;

    @Column(name = "guaranteer_address")
    private String gaddress;


    @Column(name = "account_borrowerLoanAmount")
    private Integer amount;

    @Column(name = "account_borrowerEmi")
    private Integer emi;

    @Column(name = "account_borrowerDeductionAmt")
    private Integer deductionAmount;


    @Column(name="return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @Column(name = "loan_duration")
    private Integer loanDuration;


    @Column(name = "target_amt")
    private Integer targetAmt;

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGcno() {
        return gcno;
    }

    public void setGcno(String gcno) {
        this.gcno = gcno;
    }

    public String getGaddress() {
        return gaddress;
    }

    public void setGaddress(String gaddress) {
        this.gaddress = gaddress;
    }


    public String getBorrowervehiclenum() {
        return borrowervehiclenum;
    }

    public void setBorrowervehiclenum(String borrowervehiclenum) {
        this.borrowervehiclenum = borrowervehiclenum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getEmi() {
        return emi;
    }

    public void setEmi(Integer emi) {
        this.emi = emi;
    }

    public Integer getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(Integer deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(Integer loanDuration) {
        this.loanDuration = loanDuration;
    }

    public Integer getTargetAmt() {
        return targetAmt;
    }

    public void setTargetAmt(Integer targetAmt) {
        this.targetAmt = targetAmt;
    }
}

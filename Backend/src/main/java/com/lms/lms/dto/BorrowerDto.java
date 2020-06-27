package com.lms.lms.dto;

import java.util.Date;

public class BorrowerDto {
    private Integer borrowerId;
    private String name;
    private String cno;
    private String address;
    private String accNo;
    private String borrowervehiclenum;
    private Date date;
    private String gname;

    private String gcno;
    private String gaddress;
    private Integer amount;
    private Integer emi;
    private Integer deductionAmount;
    private Date returnDate;

    private Integer loanDuration;

    private Integer targetAmt;

    public Integer getTargetAmt() {
        return targetAmt;
    }

    public void setTargetAmt(Integer targetAmt) {
        this.targetAmt = targetAmt;
    }

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

    public String getBorrowervehiclenum() {
        return borrowervehiclenum;
    }

    public void setBorrowervehiclenum(String borrowervehiclenum) {
        this.borrowervehiclenum = borrowervehiclenum;
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
}
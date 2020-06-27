package com.lms.lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BusinessLoanModel")
public class BusinessLoanModel {
    @Id
    @GeneratedValue
    @Column(name = "businessLoan_id")
    private Integer businessLoanId;

    @Column(name = "businessLoan_name")
    private String name;

    @Column(name = "businessLoan_address")
    private String address;

    @Column(name = "businessLoan_cno")
    private String cno;

    @Column(name = "businessLoan_amount")
    private Integer loanAmount;

    @Column(name = "businessLoan_returnAmt")
    private Integer returnAmount;

    @Column(name = "businessLoan_returnDate")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @Column(name = "businessLoan_currentDate")
    @Temporal(TemporalType.DATE)
    private Date currentDate;

    @Column(name = "businessLoan_alertdate")
    @Temporal(TemporalType.DATE)
    private Date alertdate;

    @Column(name = "businessLoan_status")
    private String status;

    @Column(name = "businessLoan_percentage")
    private Double percent;


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

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}

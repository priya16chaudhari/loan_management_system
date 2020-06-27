package com.lms.lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BorrowerLoanDates")
public class BorrowerDatesModel {


    @Id
    @GeneratedValue
    @Column(name = "borrowerDate_id")
    private Integer borrowerDateId;

    @Column(name = "dates")
    @Temporal(TemporalType.DATE)
    private Date datess;

    @Column(name = "borrower_name")
    private String borrowerNames;

    @Column(name = "newStatus")
    private String newStatus;

    @Column(name = "amount")
    private Integer amount;





    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getBorrowerDateId() {
        return borrowerDateId;
    }

    public void setBorrowerDateId(Integer borrowerDateId) {
        this.borrowerDateId = borrowerDateId;
    }

    public Date getDatess() {
        return datess;
    }

    public void setDatess(Date datess) {
        this.datess = datess;
    }

    public String getBorrowerNames() {
        return borrowerNames;
    }

    public void setBorrowerNames(String borrowerNames) {
        this.borrowerNames = borrowerNames;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }
}

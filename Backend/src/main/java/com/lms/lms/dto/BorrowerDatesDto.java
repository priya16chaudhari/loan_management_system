package com.lms.lms.dto;

import java.util.Date;

public class BorrowerDatesDto {
    private Integer borrowerDateId;
    private Date datess;
    private String borrowerNames;
    private String newStatus;
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

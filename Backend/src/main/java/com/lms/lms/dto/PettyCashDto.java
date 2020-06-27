package com.lms.lms.dto;

import java.util.Date;

public class PettyCashDto {

    private Integer pettyCashId;
    private Date currentDate;
    private Integer pettyCashAmount;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPettyCashId() {
        return pettyCashId;
    }

    public void setPettyCashId(Integer pettyCashId) {
        this.pettyCashId = pettyCashId;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Integer getPettyCashAmount() {
        return pettyCashAmount;
    }

    public void setPettyCashAmount(Integer pettyCashAmount) {
        this.pettyCashAmount = pettyCashAmount;
    }
}

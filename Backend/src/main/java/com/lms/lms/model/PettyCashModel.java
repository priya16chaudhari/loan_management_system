package com.lms.lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PettyCashMaster")
public class PettyCashModel {
    @Id
    @GeneratedValue
    @Column(name = "pettycashid")
    private Integer pettyCashId;

    @Column(name = "currentdate")
    @Temporal(TemporalType.DATE)
    private Date currentDate;

    @Column(name = "borrowername")
    private String name;

    @Column(name = "pettyCashamount")
    private Integer pettyCashAmount;


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

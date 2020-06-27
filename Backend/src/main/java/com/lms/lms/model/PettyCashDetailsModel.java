package com.lms.lms.model;

import javax.persistence.*;

@Entity
@Table(name = "PettyCashDetailsMaster")
public class PettyCashDetailsModel {
    @Id
    @GeneratedValue
    @Column(name = "pettyCashDetailid")
    private Integer pettyCashDetailId;

    @Column(name = "adminname")
    private String adminName;

    @Column(name = "totalpettyCashamount")
    private Integer finalAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private Integer cash;

    @Column(name = "validreason")
    private String reason;
//
//        @Column(name = "finalAmount")
//        private Integer finalAmount;
//
//    public Integer getFinalAmount() {
//        return finalAmount;
//    }
//
//    public void setFinalAmount(Integer finalAmount) {
//        this.finalAmount = finalAmount;
//    }

    public Integer getPettyCashDetailId() {
        return pettyCashDetailId;
    }

    public void setPettyCashDetailId(Integer pettyCashDetailId) {
        this.pettyCashDetailId = pettyCashDetailId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }


    public Integer getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Integer finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
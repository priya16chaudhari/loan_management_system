package com.lms.lms.model;

import javax.persistence.*;

@Entity
@Table(name = "AdminPettyCashMaster")
public class AdminPettyCashModel {
    @Id
    @GeneratedValue
    @Column(name = "adminPettycashid")
    private Integer adminpettyCashId;

    @Column(name = "finalAmount")
    private Integer finalAmount;

    public Integer getAdminpettyCashId() {
        return adminpettyCashId;
    }

    public void setAdminpettyCashId(Integer adminpettyCashId) {
        this.adminpettyCashId = adminpettyCashId;
    }

    public Integer getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Integer finalAmount) {
        this.finalAmount = finalAmount;
    }
}
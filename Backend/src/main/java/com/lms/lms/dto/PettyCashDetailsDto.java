package com.lms.lms.dto;

public class PettyCashDetailsDto {

    private Integer pettyCashDetailId;
    private String adminName;
    //    private Integer totalPettyCashAmount;
    private String status;
    private Integer finalAmount;
    private Integer cash;
    private String Reason;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Integer finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }
}
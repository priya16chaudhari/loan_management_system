package com.lms.lms.dto;

import com.lms.lms.model.BorrowerModel;

import java.util.List;

public class PieDto {

    private Integer loanCnt;
    private Integer targetCnt;
        private List<BorrowerModel> borrowerModelList1;

    public List<BorrowerModel> getBorrowerModelList1() {
        return borrowerModelList1;
    }

    public void setBorrowerModelList1(List<BorrowerModel> borrowerModelList1) {
        this.borrowerModelList1 = borrowerModelList1;
    }

    public Integer getLoanCnt() {
        return loanCnt;
    }

    public void setLoanCnt(Integer loanCnt) {
        this.loanCnt = loanCnt;
    }

    public Integer getTargetCnt() {
        return targetCnt;
    }

    public void setTargetCnt(Integer targetCnt) {
        this.targetCnt = targetCnt;
    }
}

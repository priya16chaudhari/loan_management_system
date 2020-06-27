package com.lms.lms.service;

import com.lms.lms.dto.BusinessLoanDto;

import java.util.List;

public interface BusinessLoanService {
    boolean insertBusinessCtrl(BusinessLoanDto businessLoanDto);

    List getBusinessCtrl();

    List getBusinessnewctrl();

    List getBusinessCtrl1();

//    boolean updateCtrls(BusinessLoanDto businessLoanDto);
}

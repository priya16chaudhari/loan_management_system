package com.lms.lms.service;

import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.BorrowerDatesDto;
import com.lms.lms.dto.BorrowerDto;

import java.util.List;

public interface BorrowerDatesService {
    boolean insertBorrowerDatesCtrl(BorrowerDto borrowerDto);

    boolean updateCustomerDatesCtrl(AdminCustomerDto adminCustomerDto);

    boolean insertCtrl1(AdminCustomerDto adminCustomerDto);

    List getPendingViewList(String borrowerNames);

    List getPendingViewDetailsAmtcnt(String borrowerNames);

    List getPendingViewDetailsStatus(String borrowerNames);
}

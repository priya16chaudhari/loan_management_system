package com.lms.lms.service;

import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.PieDto;

import java.util.List;

public interface AdminCustomerService {
    boolean insertCtrl(AdminCustomerDto adminCustomerDto);

    AdminCustomerDto getReportMethod(AdminCustomerDto adminCustomerDto);

    boolean updateCustomerCtrl(AdminCustomerDto adminCustomerDto);


    List getAllList();

    List getPendingList();

    List getOverdueList();

    List getCloseList();


    PieDto getAllPieList();
}

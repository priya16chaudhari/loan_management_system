package com.lms.lms.service;

import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.PettyCashDetailsDto;


public interface AdminPettyCashService {

    boolean updatePettyAmountCtrl(AdminCustomerDto adminCustomerDto);

    boolean updateCtrl(PettyCashDetailsDto pettyCashDetailsDto);
}

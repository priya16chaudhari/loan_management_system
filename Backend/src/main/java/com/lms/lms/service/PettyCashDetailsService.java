package com.lms.lms.service;

import com.lms.lms.dto.AdminPettyCashDto;
import com.lms.lms.dto.PettyCashDetailsDto;

import java.util.List;

public interface PettyCashDetailsService {

    AdminPettyCashDto getFinalAmtCtrl();

    boolean insertPettyCashAmountCtrl(PettyCashDetailsDto pettyCashDetailsDto);

    List getCtrl();
}

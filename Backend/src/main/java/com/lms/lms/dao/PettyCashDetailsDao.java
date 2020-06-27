package com.lms.lms.dao;

import com.lms.lms.dto.AdminPettyCashDto;
import com.lms.lms.model.PettyCashDetailsModel;

import java.util.List;

public interface PettyCashDetailsDao {

    AdminPettyCashDto getFinalAmt();

    boolean insertData(PettyCashDetailsModel pettyCashDetailsModel);

    List getDetails();
}

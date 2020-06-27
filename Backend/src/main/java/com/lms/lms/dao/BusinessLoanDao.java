package com.lms.lms.dao;

import com.lms.lms.model.BusinessLoanModel;

import java.util.List;

public interface BusinessLoanDao {
    boolean insertBusinessRecord(BusinessLoanModel businessLoanModel);

    List getBusinessRecords();

    boolean updatedaofun(String name);

    List getBusinessRecords1();

//    boolean updatedaofun(BusinessLoanModel businessLoanModel);
}

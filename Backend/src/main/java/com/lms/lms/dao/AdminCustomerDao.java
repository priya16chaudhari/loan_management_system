package com.lms.lms.dao;

import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.model.AdminCustomerMaster;

import java.util.Date;
import java.util.List;

public interface AdminCustomerDao {
    boolean insertDetails(AdminCustomerMaster adminCustomerMaster);

    AdminCustomerDto getnameWiseDao(String name);

    boolean updateDetails(AdminCustomerMaster adminCustomerMaster);

    List getLists();

    List getPendingLists();

    List getOverdueLists();

    List getCloseLists();

    List getReturnDate();

}

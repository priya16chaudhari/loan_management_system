package com.lms.lms.dao;

import com.lms.lms.model.AdminPettyCashModel;

public interface AdminPettyCashDao {

    int getFinalAmt();

    boolean updatedata(AdminPettyCashModel adminPettyCashModel);
}

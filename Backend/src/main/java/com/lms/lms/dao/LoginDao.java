package com.lms.lms.dao;

import com.lms.lms.model.LoginModel;

import java.util.List;

public interface LoginDao {
    List<LoginModel> getLoginRecords();
}

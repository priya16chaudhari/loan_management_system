package com.lms.lms.service.impl;

import com.lms.lms.dao.LoginDao;
import com.lms.lms.dto.LoginDto;
import com.lms.lms.model.LoginModel;
import com.lms.lms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginDao loginDao;

    @Override
    public LoginDto insertLoginCtrl(LoginDto loginDto) {
        List<LoginModel> loginModelList = loginDao.getLoginRecords();
        System.out.println("Login List:" + loginModelList.size());
        LoginDto loginDto1=new LoginDto();
        for (LoginModel loginModel : loginModelList)
        {
            if (loginDto.getUsername() != null && loginDto.getPassword() != null) {
                if (loginDto.getUsername().equals(loginModel.getUsername()) && loginDto.getPassword().equals(loginModel.getPassword()))
                {
                    //System.out.println("model username="+loginModel.getUsername());
                        loginDto1.setUsername(loginModel.getUsername());
                    //System.out.println("model password="+loginModel.getPassword());
                        loginDto1.setPassword(loginModel.getPassword());
                        loginDto1.setLoginId(loginModel.getLoginId());
                    return loginDto1;
                }
            }

        }

        return loginDto1;
    }
}

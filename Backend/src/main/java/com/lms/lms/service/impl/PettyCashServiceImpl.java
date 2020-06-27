package com.lms.lms.service.impl;

import com.lms.lms.dao.PettyCashDao;
import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.model.AdminPettyCashModel;
import com.lms.lms.model.PettyCashModel;
import com.lms.lms.service.PettyCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PettyCashServiceImpl implements PettyCashService{
    @Autowired
    private PettyCashDao pettyCashDao;


    @Override
    public boolean insertCtrl(AdminCustomerDto adminCustomerDto) {

        PettyCashModel pettyCashModel=new PettyCashModel();


        pettyCashModel.setName(adminCustomerDto.getName());
        pettyCashModel.setCurrentDate(new Date());
        pettyCashModel.setPettyCashAmount(adminCustomerDto.getDailyAmt());

        boolean flag=pettyCashDao.insertDetails(pettyCashModel);
        return flag;




    }
}

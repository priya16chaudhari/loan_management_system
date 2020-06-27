package com.lms.lms.service.impl;

import com.lms.lms.dao.PettyCashDetailsDao;
import com.lms.lms.dto.AdminPettyCashDto;
import com.lms.lms.dto.PettyCashDetailsDto;
import com.lms.lms.model.PettyCashDetailsModel;
import com.lms.lms.service.PettyCashDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PettyCashDetailsServiceIml implements PettyCashDetailsService{
    @Autowired
    private PettyCashDetailsDao pettyCashDetailsDao;


    @Override
    public AdminPettyCashDto getFinalAmtCtrl() {
        AdminPettyCashDto adminPettyCashDto=pettyCashDetailsDao.getFinalAmt();
        return adminPettyCashDto;
    }

    @Override
    public boolean insertPettyCashAmountCtrl(PettyCashDetailsDto pettyCashDetailsDto) {
        PettyCashDetailsModel pettyCashDetailsModel=new PettyCashDetailsModel();

        pettyCashDetailsModel.setAdminName(pettyCashDetailsDto.getAdminName());
        pettyCashDetailsModel.setFinalAmount(pettyCashDetailsDto.getFinalAmount());
        pettyCashDetailsModel.setReason(pettyCashDetailsDto.getReason());

        pettyCashDetailsModel.setStatus(pettyCashDetailsDto.getStatus());
        pettyCashDetailsModel.setCash(pettyCashDetailsDto.getCash());

        boolean flag=pettyCashDetailsDao.insertData(pettyCashDetailsModel);

        return flag;
    }

    @Override
    public List getCtrl() {

        List list=pettyCashDetailsDao.getDetails();


        System.out.println("Borrower list size:"+list.size());
        return list;
    }


}

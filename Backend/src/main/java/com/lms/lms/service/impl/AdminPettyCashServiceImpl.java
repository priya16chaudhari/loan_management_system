package com.lms.lms.service.impl;

import com.lms.lms.dao.AdminPettyCashDao;
import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.AdminPettyCashDto;
import com.lms.lms.dto.PettyCashDetailsDto;
import com.lms.lms.model.AdminPettyCashModel;
import com.lms.lms.service.AdminPettyCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPettyCashServiceImpl implements AdminPettyCashService{
    @Autowired
    private AdminPettyCashDao adminPettyCashDao;


    @Override
    public boolean updatePettyAmountCtrl(AdminCustomerDto adminCustomerDto) {
        AdminPettyCashModel adminPettyCashModel=new AdminPettyCashModel();


        int tempfinal=adminPettyCashDao.getFinalAmt();

        System.out.println("final    "+tempfinal);

        int a=adminCustomerDto.getDailyAmt()+tempfinal;
        adminPettyCashModel.setAdminpettyCashId(1);
        adminPettyCashModel.setFinalAmount(a);

        boolean flag=adminPettyCashDao.updatedata(adminPettyCashModel);

        return flag;

    }

    @Override
    public boolean updateCtrl(PettyCashDetailsDto pettyCashDetailsDto) {
        AdminPettyCashModel adminPettyCashModel=new AdminPettyCashModel();


////        int tempfinal=adminPettyCashDao.getFinalAmt();
////
////        System.out.println("final    "+tempfinal);
//
//        int a=adminCustomerDto.getTotaldailyAmt()+tempfinal;
        adminPettyCashModel.setAdminpettyCashId(1);
        adminPettyCashModel.setFinalAmount(pettyCashDetailsDto.getFinalAmount());


        System.out.println("amountttt"+pettyCashDetailsDto.getFinalAmount());
        boolean flag=adminPettyCashDao.updatedata(adminPettyCashModel);

        return flag;

    }
}

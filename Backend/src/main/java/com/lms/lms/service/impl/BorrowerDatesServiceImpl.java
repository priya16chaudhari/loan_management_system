package com.lms.lms.service.impl;


import com.lms.lms.dao.BorrowerDatesDao;
import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.BorrowerDto;
import com.lms.lms.model.BorrowerDatesModel;
import com.lms.lms.service.BorrowerDatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BorrowerDatesServiceImpl implements BorrowerDatesService{
    @Autowired
    private BorrowerDatesDao borrowerDatesDao;


    @Override
    public boolean insertBorrowerDatesCtrl(BorrowerDto borrowerDto) {

        boolean flagt=borrowerDatesDao.insertDates(borrowerDto);
        return flagt;
    }

    @Override
    public boolean updateCustomerDatesCtrl(AdminCustomerDto adminCustomerDto) {

        BorrowerDatesModel borrowerDatesModel=new BorrowerDatesModel();



        System.out.println("ppppppp"+adminCustomerDto.getCurDate());
        borrowerDatesModel.setBorrowerDateId(adminCustomerDto.getCustomerId());
        borrowerDatesModel.setDatess(adminCustomerDto.getCurDate());
        borrowerDatesModel.setBorrowerNames(adminCustomerDto.getName());
        borrowerDatesModel.setNewStatus(adminCustomerDto.getNewStatus());

        borrowerDatesModel.setAmount(adminCustomerDto.getDailyAmt());

        boolean flag=borrowerDatesDao.updateData(borrowerDatesModel);

        return flag;

    }

    @Override
    public boolean insertCtrl1(AdminCustomerDto adminCustomerDto) {
        BorrowerDatesModel borrowerDatesModel=new BorrowerDatesModel();



        System.out.println("ppppppp"+adminCustomerDto.getCurDate());

        borrowerDatesModel.setDatess(adminCustomerDto.getCurDate());
        borrowerDatesModel.setBorrowerNames(adminCustomerDto.getName());
        borrowerDatesModel.setNewStatus(adminCustomerDto.getNewStatus());

        borrowerDatesModel.setAmount(adminCustomerDto.getDailyAmt());

        boolean flag=borrowerDatesDao.insertDateDao(borrowerDatesModel);

        return flag;
    }

    @Override
    public List getPendingViewList(String borrowerNames) {
        List list=borrowerDatesDao.getNamewiseDetails(borrowerNames);
        return list;
    }

    @Override
    public List getPendingViewDetailsAmtcnt(String borrowerNames) {
        List list=borrowerDatesDao.getAmtwiseDetails(borrowerNames);
        return list;
    }

    @Override
    public List getPendingViewDetailsStatus(String borrowerNames) {
        List list=borrowerDatesDao.getstatuswiseDetails(borrowerNames);
        return list;
    }
}

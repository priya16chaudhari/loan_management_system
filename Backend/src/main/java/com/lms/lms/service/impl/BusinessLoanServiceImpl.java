package com.lms.lms.service.impl;

import com.lms.lms.dao.BusinessLoanDao;
import com.lms.lms.dto.BusinessLoanDto;
import com.lms.lms.model.BusinessLoanModel;
import com.lms.lms.service.BusinessLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BusinessLoanServiceImpl implements BusinessLoanService{
    @Autowired
    private BusinessLoanDao businessLoanDao;


    @Override
    public boolean insertBusinessCtrl(BusinessLoanDto businessLoanDto) {
        BusinessLoanModel businessLoanModel=new BusinessLoanModel();

        businessLoanModel.setName(businessLoanDto.getName());
        businessLoanModel.setAddress(businessLoanDto.getAddress());
        businessLoanModel.setCno(businessLoanDto.getCno());
        businessLoanModel.setLoanAmount(businessLoanDto.getLoanAmount());
        businessLoanModel.setStatus(businessLoanDto.getStatus());
        businessLoanModel.setPercent(businessLoanDto.getPercent());
        businessLoanModel.setReturnAmount(businessLoanDto.getReturnAmount());
        businessLoanModel.setReturnDate(businessLoanDto.getReturnDate());
        businessLoanModel.setCurrentDate(new Date());

        String incDate;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(businessLoanDto.getReturnDate());
        c.add(Calendar.DATE, -3);
        incDate = sdf.format(c.getTime());
        try {
            Date today = sdf.parse(incDate);
            System.out.println("date - 3="+today);
            businessLoanModel.setAlertdate(today);
        }
        catch (ParseException p)
        {
            p.printStackTrace();
        }


        boolean flag=businessLoanDao.insertBusinessRecord(businessLoanModel);
        return flag;

    }

    @Override
    public List getBusinessCtrl() {


              List list=businessLoanDao.getBusinessRecords();



        return list;
    }

    @Override
    public List getBusinessnewctrl() {
        List<BusinessLoanModel> list=new ArrayList<>();
        list=businessLoanDao.getBusinessRecords();
               return list;


    }

    @Override
    public List getBusinessCtrl1() {
            List list=businessLoanDao.getBusinessRecords1();
        return list;

    }


}

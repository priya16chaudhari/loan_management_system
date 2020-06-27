package com.lms.lms.service.impl;

import com.lms.lms.dao.AdminCustomerDao;
import com.lms.lms.dao.BorrowerDao;
import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.PieDto;
import com.lms.lms.model.AdminCustomerMaster;
import com.lms.lms.model.BorrowerModel;
import com.lms.lms.service.AdminCustomerService;
import com.lms.lms.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminCustomerServiceImpl implements AdminCustomerService {


        @Autowired
        private AdminCustomerDao adminCustomerDao;
    @Override
    public boolean insertCtrl(AdminCustomerDto adminCustomerDto) {
        AdminCustomerMaster adminCustomerMaster=new AdminCustomerMaster();

        adminCustomerMaster.setName(adminCustomerDto.getName());

        adminCustomerMaster.setAccNo(adminCustomerDto.getAccNo());


        adminCustomerMaster.setReturnDate(adminCustomerDto.getReturnDate());
//        adminCustomerMaster.setLoanDuration(adminCustomerDto.getLoanDuration());

        adminCustomerMaster.setTargetAmt(adminCustomerDto.getTargetAmt());
        adminCustomerMaster.setDailyAmt(adminCustomerDto.getDailyAmt());

        adminCustomerMaster.setStatus(adminCustomerDto.getStatus());


        adminCustomerMaster.setRemainAmt(adminCustomerDto.getRemainAmt());

        adminCustomerMaster.setCurDate(adminCustomerDto.getCurDate());
        adminCustomerMaster.setEmi(adminCustomerDto.getEmi());

        boolean flag=adminCustomerDao.insertDetails(adminCustomerMaster);
        return flag;
    }

    @Override
    public AdminCustomerDto getReportMethod(AdminCustomerDto adminCustomerDto) {
        System.out.println("hhfhh"+adminCustomerDto.getName());
        AdminCustomerDto adminCustomerDto1=adminCustomerDao.getnameWiseDao(adminCustomerDto.getName());

//        ProductDto productDto=new ProductDto();
//        productDto.setDetailList(selectList);
        return adminCustomerDto1;
    }

    @Override
    public boolean updateCustomerCtrl(AdminCustomerDto adminCustomerDto) {


        AdminCustomerMaster adminCustomerMaster=new AdminCustomerMaster();

        System.out.println("alllll");
        List<BorrowerModel> list=adminCustomerDao.getReturnDate();
        System.out.println("new datea return"+list.size());
        for (BorrowerModel borrowerModel:list)
        {
            System.out.println("name borrowrmodel "+borrowerModel.getName());
            System.out.println("name adminCustomerDto "+adminCustomerDto.getName());

            if(borrowerModel.getName().equalsIgnoreCase(adminCustomerDto.getName()))
            {
                System.out.println("equal names");
        adminCustomerMaster.setReturnDate(borrowerModel.getReturnDate());
                System.out.println("getReturnDate borrowrmodel "+borrowerModel.getReturnDate());

            }
        }
        adminCustomerMaster.setCustomerId(adminCustomerDto.getCustomerId());
//        Date returnDateNew=adminCustomerDao.getReturnDate(adminCustomerDto.getName());

//        System.out.println("New datesss"+returnDateNew);
        adminCustomerMaster.setName(adminCustomerDto.getName());

        adminCustomerMaster.setAccNo(adminCustomerDto.getAccNo());


//        adminCustomerMaster.setReturnDate(returnDateNew);
//        adminCustomerMaster.setLoanDuration(adminCustomerDto.getLoanDuration());

        adminCustomerMaster.setTargetAmt(adminCustomerDto.getTargetAmt());
        adminCustomerMaster.setDailyAmt(adminCustomerDto.getDailyAmt());

        adminCustomerMaster.setStatus(adminCustomerDto.getStatus());

        adminCustomerMaster.setRemainAmt(adminCustomerDto.getRemainAmt());

        adminCustomerMaster.setCurDate(adminCustomerDto.getCurDate());

        adminCustomerMaster.setEmi(adminCustomerDto.getEmi());
        boolean flag=adminCustomerDao.updateDetails(adminCustomerMaster);
        return flag;
    }

    @Override
    public List getAllList() {
        List list=adminCustomerDao.getLists();
        return list;
    }

    @Override
    public List getPendingList() {
        List list=adminCustomerDao.getPendingLists();
        return list;
    }

    @Override
    public List getOverdueList() {
        List list=adminCustomerDao.getOverdueLists();
        return list;
    }

    @Override
    public List getCloseList() {
        List list=adminCustomerDao.getCloseLists();
        System.out.println("close list size="+list.size());
        return list;
    }

    @Override
    public PieDto getAllPieList() {
        List<BorrowerModel> borrowerlist=adminCustomerDao.getReturnDate();
        List<AdminCustomerMaster> adminCustomerList=adminCustomerDao.getLists();
        List<BorrowerModel> loanlist=new ArrayList();
        int totalLoanAmt=0;
        int totalTargetAmt=0;
        PieDto pieDto=new PieDto();
        for (AdminCustomerMaster adminCustomerMaster:adminCustomerList)
        {
            if(adminCustomerMaster.getStatus().equalsIgnoreCase("close"))
            {
                for (BorrowerModel borrowerModel:borrowerlist)
                {
                    if(adminCustomerMaster.getName().equalsIgnoreCase(borrowerModel.getName()))
                    {
                        totalLoanAmt=totalLoanAmt+borrowerModel.getAmount();
                        totalTargetAmt=totalTargetAmt+borrowerModel.getTargetAmt();

                        System.out.println("totalLoanAmt="+totalLoanAmt);
                        System.out.println("totalTargetAmt="+totalTargetAmt);
                        loanlist.add(borrowerModel);

                    }
                }
            }
        }



        System.out.println("outer  totalLoanAmt="+totalLoanAmt);
        System.out.println("outer totalTargetAmt="+totalTargetAmt);


        pieDto.setLoanCnt(totalLoanAmt);
        pieDto.setTargetCnt(totalTargetAmt);
        pieDto.setBorrowerModelList1(loanlist);


return pieDto;
    }


}

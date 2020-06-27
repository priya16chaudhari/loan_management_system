package com.lms.lms.service.impl;

import com.lms.lms.dao.BorrowerDao;
import com.lms.lms.dto.BorrowerDto;
import com.lms.lms.model.BorrowerModel;
import com.lms.lms.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService{
    @Autowired
    private BorrowerDao borrowerDao;

    @Override
    public boolean insertBorrowerCtrl(BorrowerDto borrowerDto)
    {
        BorrowerModel borrowerModel=new BorrowerModel();

        borrowerModel.setName(borrowerDto.getName());
        borrowerModel.setCno(borrowerDto.getCno());
        borrowerModel.setAddress(borrowerDto.getAddress());
        borrowerModel.setAccNo(borrowerDto.getAccNo());
        borrowerModel.setBorrowervehiclenum(borrowerDto.getBorrowervehiclenum());

        borrowerModel.setDate(new Date());
        borrowerModel.setGname(borrowerDto.getGname());
        borrowerModel.setGcno(borrowerDto.getGcno());
        borrowerModel.setGaddress(borrowerDto.getGaddress());

        borrowerModel.setAmount(borrowerDto.getAmount());
        borrowerModel.setEmi(borrowerDto.getEmi());
        borrowerModel.setDeductionAmount(borrowerDto.getDeductionAmount());

        borrowerModel.setReturnDate(borrowerDto.getReturnDate());
        borrowerModel.setLoanDuration(borrowerDto.getLoanDuration());

        borrowerModel.setTargetAmt(borrowerDto.getTargetAmt());


        boolean flag=borrowerDao.insertBorrowerDetails(borrowerModel);
        return flag;
    }

    @Override
    public List getBorrowerCtrl()
    {
        List list=borrowerDao.getBorrowerDetails();


        System.out.println("Borrower list size:"+list.size());
        return list;
    }

    @Override
    public BorrowerDto editBorrowerCtrl(Integer borrowerId) {
        BorrowerDto borrowerDto=borrowerDao.editBorrowerRecord(borrowerId);
        return borrowerDto;
    }

    @Override
    public boolean updateBorrowerCtrl(BorrowerDto borrowerDto) {
        BorrowerModel borrowerModel=new BorrowerModel();

        borrowerModel.setBorrowerId(borrowerDto.getBorrowerId());
        borrowerModel.setName(borrowerDto.getName());
        borrowerModel.setAddress(borrowerDto.getAddress());
        borrowerModel.setCno(borrowerDto.getCno());
        borrowerModel.setBorrowervehiclenum(borrowerDto.getBorrowervehiclenum());
        borrowerModel.setAccNo(borrowerDto.getAccNo());
        borrowerModel.setAmount(borrowerDto.getAmount());
        borrowerModel.setDeductionAmount(borrowerDto.getDeductionAmount());
        borrowerModel.setEmi(borrowerDto.getEmi());
        borrowerModel.setLoanDuration(borrowerDto.getLoanDuration());
        borrowerModel.setDate(new Date());
        borrowerModel.setReturnDate(borrowerDto.getReturnDate());
        borrowerModel.setGname(borrowerDto.getGname());
        borrowerModel.setGcno(borrowerDto.getGcno());
        borrowerModel.setGaddress(borrowerDto.getGaddress());
        borrowerModel.setTargetAmt(borrowerDto.getTargetAmt());

        boolean flag=borrowerDao.updateBorrowerDetails(borrowerModel);
        return flag;

    }

    @Override
    public boolean deleteBorrowerCtrl(Integer borrowerId) {
        boolean flag=borrowerDao.deleteBorrowerRecord(borrowerId);
        return flag;
    }



}

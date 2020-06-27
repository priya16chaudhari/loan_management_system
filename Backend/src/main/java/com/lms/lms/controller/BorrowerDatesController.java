package com.lms.lms.controller;

import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.BorrowerDatesDto;
import com.lms.lms.dto.BorrowerDto;
import com.lms.lms.dto.ResponseVO;
import com.lms.lms.service.BorrowerDatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class BorrowerDatesController {
    @Autowired
    private BorrowerDatesService borrowerDatesService;

    @RequestMapping(value = "/insertDatesDeatails",method = RequestMethod.POST)
    public ResponseVO insertDatesDeatails(@RequestBody BorrowerDto borrowerDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=borrowerDatesService.insertBorrowerDatesCtrl(borrowerDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Borrower dates Details inserted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Borrower dates insertion failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }


    @RequestMapping(value = "/insertBorrowerDateNew",method = RequestMethod.POST)
    public ResponseVO insertBorrowerDateNew(@RequestBody AdminCustomerDto adminCustomerDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=borrowerDatesService.insertCtrl1(adminCustomerDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Borrower Details inserted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Borrower insertion failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/updateBorrowerDatesDetails",method = RequestMethod.POST)
    public ResponseVO updateBorrowerDatesDetails(@RequestBody AdminCustomerDto adminCustomerDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=borrowerDatesService.updateCustomerDatesCtrl(adminCustomerDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Borrower Dates Updated successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Borrower Dates update failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getPendingViewDetails/{borrowerNames}",method = RequestMethod.POST)
    public ResponseVO getPendingViewDetails(@PathVariable String borrowerNames)
    {
        ResponseVO responseVO=new ResponseVO();
        List list=borrowerDatesService.getPendingViewList(borrowerNames);

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Admin Borrower Pending details Record got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Admin Borrower pending record failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getPendingViewDetailsAmt/{borrowerNames}",method = RequestMethod.POST)
    public ResponseVO getPendingViewDetailsAmt(@PathVariable String borrowerNames)
    {
        ResponseVO responseVO=new ResponseVO();
        List list=borrowerDatesService.getPendingViewDetailsAmtcnt(borrowerNames);

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Admin Borrower Pending details Record got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Admin Borrower pending record failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }


    @RequestMapping(value = "/getPendingViewDetailsStatus/{borrowerNames}",method = RequestMethod.POST)
    public ResponseVO getPendingViewDetailsStatus(@PathVariable String borrowerNames)
    {
        ResponseVO responseVO=new ResponseVO();
        List list=borrowerDatesService.getPendingViewDetailsStatus(borrowerNames);

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Admin Borrower Pending details Record got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Admin Borrower pending record failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }
}

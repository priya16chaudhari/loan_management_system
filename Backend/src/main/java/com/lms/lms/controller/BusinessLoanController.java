package com.lms.lms.controller;

import com.lms.lms.dto.BusinessLoanDto;
import com.lms.lms.dto.ResponseVO;
import com.lms.lms.service.BusinessLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class BusinessLoanController {
        @Autowired
        private BusinessLoanService businessLoanService;

        @RequestMapping(value = "/insertBusinessLoanDetails", method = RequestMethod.POST)
        public ResponseVO insertBusinessLoanDetails(@RequestBody BusinessLoanDto businessLoanDto) {
            ResponseVO responseVO = new ResponseVO();
            boolean flag = businessLoanService.insertBusinessCtrl(businessLoanDto);

            if (flag == true) {
                responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
                responseVO.setMessage("BusinessLoan Details inserted successfully");
                responseVO.setResult(flag);
            } else {
                responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
                responseVO.setMessage("BusinessLoan insertion failed");
                responseVO.setResult(flag);
            }
            return responseVO;
        }

    @RequestMapping(value = "/getBusiness",method = RequestMethod.GET)
    public ResponseVO getBusiness()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=businessLoanService.getBusinessCtrl();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Business Record got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Business record failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getBusinessnewwwww",method = RequestMethod.GET)
    public ResponseVO getBusinessnewwwww()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=businessLoanService.getBusinessCtrl1();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Business Record got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Business record failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getBusinessnew",method = RequestMethod.GET)
    public ResponseVO getBusinessnew()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=businessLoanService.getBusinessnewctrl();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Business Record got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Business record failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

//    @RequestMapping(value = "/updateDetailsDatenew",method = RequestMethod.POST)
//    public ResponseVO updateBorrowerDetails(@RequestBody  BusinessLoanDto businessLoanDto)
//    {
//        ResponseVO responseVO=new ResponseVO();
//        boolean flag=businessLoanService.updateCtrls(businessLoanDto);
//
//        if(flag==true)
//        {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
//            responseVO.setMessage("Borrower Updated successfully");
//            responseVO.setResult(flag);
//        }
//        else
//        {
//            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
//            responseVO.setMessage("Borrower update failed");
//            responseVO.setResult(flag);
//        }
//        return responseVO;
//    }

}


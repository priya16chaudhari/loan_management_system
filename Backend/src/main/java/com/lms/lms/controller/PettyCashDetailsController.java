package com.lms.lms.controller;

import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.AdminPettyCashDto;
import com.lms.lms.dto.PettyCashDetailsDto;
import com.lms.lms.dto.ResponseVO;
import com.lms.lms.service.PettyCashDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class PettyCashDetailsController {
    @Autowired
    private PettyCashDetailsService pettyCashDetailsService;

    @RequestMapping(value = "/getFinalAmount",method = RequestMethod.GET)
    public ResponseVO<AdminPettyCashDto> getFinalAmount()
    {
        ResponseVO<AdminPettyCashDto> responseVO=new ResponseVO();
        AdminPettyCashDto adminPettyCashDto =pettyCashDetailsService.getFinalAmtCtrl();

        if(adminPettyCashDto!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Final amount got successfully");
            responseVO.setResult(adminPettyCashDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Final Amount record failed");
            responseVO.setResult(adminPettyCashDto);
        }
        return responseVO;
    }

    @RequestMapping(value = "/insertFinalAmt",method = RequestMethod.POST)
    public ResponseVO insertFinalAmt(@RequestBody PettyCashDetailsDto pettyCashDetailsDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=pettyCashDetailsService.insertPettyCashAmountCtrl(pettyCashDetailsDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Petty cash inserted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Petty cash inserted failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }



    @RequestMapping(value = "/getAllDetailslist",method = RequestMethod.GET)
    public ResponseVO getAllDetailslist()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=pettyCashDetailsService.getCtrl();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Borrower Record got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Borrower record failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

}

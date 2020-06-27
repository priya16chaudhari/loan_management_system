package com.lms.lms.controller;


import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.BorrowerDto;
import com.lms.lms.dto.PettyCashDetailsDto;
import com.lms.lms.dto.ResponseVO;
import com.lms.lms.service.AdminPettyCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class AdminPettyCashController {
    @Autowired
    private AdminPettyCashService adminPettyCashService;

    @RequestMapping(value = "/updatePettyAmount",method = RequestMethod.POST)
    public ResponseVO updatePettyAmountDetails(@RequestBody AdminCustomerDto adminCustomerDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=adminPettyCashService.updatePettyAmountCtrl(adminCustomerDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Petty cash Updated successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Petty cash update failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/updatePettyDetailCashAmount",method = RequestMethod.POST)
    public ResponseVO updatePettyDetailCashAmount(@RequestBody PettyCashDetailsDto pettyCashDetailsDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=adminPettyCashService.updateCtrl(pettyCashDetailsDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Petty cash Updated successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Petty cash update failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

}

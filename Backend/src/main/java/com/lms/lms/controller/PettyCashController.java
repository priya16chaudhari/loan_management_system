package com.lms.lms.controller;


import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.ResponseVO;
import com.lms.lms.service.PettyCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class PettyCashController {
    @Autowired
    private PettyCashService pettyCashService;



    @RequestMapping(value = "/insertPettyCash",method = RequestMethod.POST)
    public ResponseVO insertPettyCash(@RequestBody AdminCustomerDto adminCustomerDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=pettyCashService.insertCtrl(adminCustomerDto);

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
}

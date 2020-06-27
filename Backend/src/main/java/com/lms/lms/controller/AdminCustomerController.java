package com.lms.lms.controller;


import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.PieDto;
import com.lms.lms.dto.ResponseVO;
import com.lms.lms.service.AdminCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class AdminCustomerController {

    @Autowired
    private AdminCustomerService adminCustomerService;

    @RequestMapping(value = "/insertDetails",method = RequestMethod.POST)
    public ResponseVO insertDetails(@RequestBody AdminCustomerDto adminCustomerDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=adminCustomerService.insertCtrl(adminCustomerDto);

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






    @RequestMapping(value = "getDetilsCustomers", method = RequestMethod.POST)
    public ResponseVO<AdminCustomerDto> getDetilsCustomers(@RequestBody AdminCustomerDto adminCustomerDto)
    {
        ResponseVO<AdminCustomerDto> responseVO = new ResponseVO<AdminCustomerDto>();


        AdminCustomerDto adminCustomerDto1 = adminCustomerService.getReportMethod(adminCustomerDto);
        if (adminCustomerDto1!= null) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get Successfully");
            responseVO.setResult(adminCustomerDto1);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Not Successfully");
            responseVO.setResult(adminCustomerDto1);
        }
        return responseVO;
    }




    @RequestMapping(value = "/updateCustoemrDetails",method = RequestMethod.POST)
    public ResponseVO updateCustoemrDetails(@RequestBody AdminCustomerDto adminCustomerDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=adminCustomerService.updateCustomerCtrl(adminCustomerDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Borrower Updated successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Borrower update failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getAllDetails",method = RequestMethod.GET)
    public ResponseVO getAllDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=adminCustomerService.getAllList();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Admin Borrower all Record got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Admin Borrower all record failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getPendingDetails",method = RequestMethod.GET)
    public ResponseVO getPendingDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=adminCustomerService.getPendingList();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Admin Borrower Pending Record got successfully");
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

    @RequestMapping(value = "/getOverdueDetails",method = RequestMethod.GET)
    public ResponseVO getOverdueDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=adminCustomerService.getOverdueList();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Admin Borrower overdue Record got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Admin Borrower overdue record failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getCloseDetails",method = RequestMethod.GET)
    public ResponseVO getCloseDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=adminCustomerService.getCloseList();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Admin Borrower close Record got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Admin Borrower close record failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getPieDetails",method = RequestMethod.GET)
    public ResponseVO<PieDto> getPieDetails()
    {
        ResponseVO<PieDto> responseVO=new ResponseVO();
        PieDto pieDto=adminCustomerService.getAllPieList();

        if(pieDto!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("pie Record got successfully");
            responseVO.setResult(pieDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("pie record failed");
            responseVO.setResult(pieDto);
        }
        return responseVO;
    }

}

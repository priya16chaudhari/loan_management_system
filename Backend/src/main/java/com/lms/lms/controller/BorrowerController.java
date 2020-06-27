package com.lms.lms.controller;

import com.lms.lms.dto.BorrowerDto;
import com.lms.lms.dto.ResponseVO;
import com.lms.lms.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class BorrowerController {
    @Autowired
    private BorrowerService borrowerService;

    @RequestMapping(value = "/insertBorrowerDetails",method = RequestMethod.POST)
    public ResponseVO insertBorrower(@RequestBody BorrowerDto borrowerDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=borrowerService.insertBorrowerCtrl(borrowerDto);

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

    @RequestMapping(value = "/getBorrower",method = RequestMethod.GET)
    public ResponseVO getBorrowerDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=borrowerService.getBorrowerCtrl();

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

    @RequestMapping(value = "/editBorrowerDetails/{borrowerId}",method = RequestMethod.POST)
    public ResponseVO editBorrowerRecord(@PathVariable Integer borrowerId)
    {
        ResponseVO responseVO=new ResponseVO();
        BorrowerDto borrowerDto=borrowerService.editBorrowerCtrl(borrowerId);

        if(borrowerDto!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Edit Borrower record successfully");
            responseVO.setResult(borrowerDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Edit Borrower record failed");
            responseVO.setResult(borrowerDto);
        }
        return responseVO;
    }

    @RequestMapping(value = "/updateBorrower",method = RequestMethod.POST)
    public ResponseVO updateBorrowerDetails(@RequestBody BorrowerDto borrowerDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=borrowerService.updateBorrowerCtrl(borrowerDto);

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

    @RequestMapping(value = "/deleteBorrower/{borrowerId}",method = RequestMethod.DELETE)
    public ResponseVO deleteBorrowerDetails(@PathVariable Integer borrowerId)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=borrowerService.deleteBorrowerCtrl(borrowerId);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Borrower record deleted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Borrower record not deleted");
            responseVO.setResult(flag);
        }
        return responseVO;
    }


}

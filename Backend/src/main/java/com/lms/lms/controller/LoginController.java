package com.lms.lms.controller;

import com.lms.lms.dto.LoginDto;
import com.lms.lms.dto.ResponseVO;
import com.lms.lms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/insertLogin", method = RequestMethod.POST)
    public ResponseVO<LoginDto> insertLoginRecord(@RequestBody LoginDto loginDto) {
        ResponseVO<LoginDto> responseVO = new ResponseVO();
        // Integer result=loginService.insertLoginCtrl(login2Dto);
        LoginDto loginDto1 = loginService.insertLoginCtrl(loginDto);

        if (loginDto1 != null) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("username return");
            responseVO.setResult(loginDto1);
        } else {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("username incorrect");
            responseVO.setResult(loginDto1);
        }
        return responseVO;

    }
}
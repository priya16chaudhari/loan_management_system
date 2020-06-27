package com.lms.lms.service;

import com.lms.lms.dto.BorrowerDto;

import java.util.List;

public interface BorrowerService {
    boolean insertBorrowerCtrl(BorrowerDto borrowerDto);

    List getBorrowerCtrl();

    BorrowerDto editBorrowerCtrl(Integer borrowerId);

    boolean updateBorrowerCtrl(BorrowerDto borrowerDto);

    boolean deleteBorrowerCtrl(Integer borrowerId);
}

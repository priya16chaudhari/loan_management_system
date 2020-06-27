package com.lms.lms.dao;

import com.lms.lms.dto.BorrowerDto;
import com.lms.lms.model.BorrowerModel;

import java.util.List;

public interface BorrowerDao {
    boolean insertBorrowerDetails(BorrowerModel borrowerModel);

    List getBorrowerDetails();

    BorrowerDto editBorrowerRecord(Integer borrowerId);

    boolean updateBorrowerDetails(BorrowerModel borrowerModel);

    boolean deleteBorrowerRecord(Integer borrowerId);

}

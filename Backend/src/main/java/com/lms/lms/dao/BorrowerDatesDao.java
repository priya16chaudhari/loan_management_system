package com.lms.lms.dao;

import com.lms.lms.dto.BorrowerDto;
import com.lms.lms.model.BorrowerDatesModel;

import java.util.List;

public interface BorrowerDatesDao {
    boolean insertDates(BorrowerDto borrowerDto);

    boolean updateData(BorrowerDatesModel borrowerDatesModel);

    boolean insertDateDao(BorrowerDatesModel borrowerDatesModel);

    List getNamewiseDetails(String borrowerNames);

    List getAmtwiseDetails(String borrowerNames);

    List getstatuswiseDetails(String borrowerNames);
}

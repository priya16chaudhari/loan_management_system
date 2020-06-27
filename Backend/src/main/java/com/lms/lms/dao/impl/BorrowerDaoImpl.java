package com.lms.lms.dao.impl;

import com.lms.lms.dao.BorrowerDao;
import com.lms.lms.dto.BorrowerDto;
import com.lms.lms.model.BorrowerModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class BorrowerDaoImpl implements BorrowerDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean insertBorrowerDetails(BorrowerModel borrowerModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(borrowerModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public List getBorrowerDetails()
    {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from BorrowerModel");
            list=query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;

    }

    @Override
    public BorrowerDto editBorrowerRecord(Integer borrowerId) {
        Session session=null;
        BorrowerDto borrowerDto=new BorrowerDto();

        try
        {
            session=sessionFactory.openSession();
            BorrowerModel borrowerModel=session.load(BorrowerModel.class,borrowerId);

            borrowerDto.setBorrowerId(borrowerModel.getBorrowerId());
            borrowerDto.setName(borrowerModel.getName());
            borrowerDto.setAddress(borrowerModel.getAddress());
            borrowerDto.setCno(borrowerModel.getCno());
            borrowerDto.setBorrowervehiclenum(borrowerModel.getBorrowervehiclenum());
            borrowerDto.setAccNo(borrowerModel.getAccNo());
            borrowerDto.setAmount(borrowerModel.getAmount());
            borrowerDto.setDeductionAmount(borrowerModel.getDeductionAmount());
            borrowerDto.setEmi(borrowerModel.getEmi());
            borrowerDto.setLoanDuration(borrowerModel.getLoanDuration());
            borrowerDto.setDate(new Date());
            borrowerDto.setReturnDate(borrowerModel.getReturnDate());
            borrowerDto.setGname(borrowerModel.getGname());
            borrowerDto.setGcno(borrowerModel.getGcno());
            borrowerDto.setGaddress(borrowerModel.getGaddress());
            borrowerDto.setTargetAmt(borrowerModel.getTargetAmt());


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return borrowerDto;

    }

    @Override
    public boolean updateBorrowerDetails(BorrowerModel borrowerModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(borrowerModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean deleteBorrowerRecord(Integer borrowerId) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            Query query=session.createQuery("delete from BorrowerModel as bm where bm.borrowerId=:borrowerId");
            query.setParameter("borrowerId",borrowerId);
            query.executeUpdate();
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

}

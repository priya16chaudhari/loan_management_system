package com.lms.lms.dao.impl;

import com.lms.lms.dao.PettyCashDetailsDao;
import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.dto.AdminPettyCashDto;
import com.lms.lms.model.PettyCashDetailsModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PettyCashDetailsDaoImpl implements PettyCashDetailsDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public AdminPettyCashDto getFinalAmt() {
        Session session=null;
//        List list=null;
        AdminPettyCashDto adminPettyCashDto=new AdminPettyCashDto();
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select am.finalAmount as finalAmount from AdminPettyCashModel as am");
            Integer finalAmt=(Integer)query.uniqueResult();

            adminPettyCashDto.setFinalAmount(finalAmt);

            return adminPettyCashDto;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return adminPettyCashDto;
    }

    @Override
    public boolean insertData(PettyCashDetailsModel pettyCashDetailsModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(pettyCashDetailsModel);
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
    public List getDetails() {
        Session session=null;
        List list=null;

        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from PettyCashDetailsModel");
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
}

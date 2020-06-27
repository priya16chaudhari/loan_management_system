package com.lms.lms.dao.impl;

import com.lms.lms.dao.AdminPettyCashDao;
import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.model.AdminPettyCashModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminPettyCashDaoImpl implements AdminPettyCashDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public int getFinalAmt()
    {
        Session session=null;

        Integer famt=0;
        try {

            session=sessionFactory.openSession();
            Query query5 = session.createQuery("select cm.finalAmount as finalAmount from AdminPettyCashModel as cm");
             famt = (Integer) query5.uniqueResult();

            return famt;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return famt;

    }

    @Override
    public boolean updatedata(AdminPettyCashModel adminPettyCashModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(adminPettyCashModel);
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

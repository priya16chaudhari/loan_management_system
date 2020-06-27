package com.lms.lms.dao.impl;

import com.lms.lms.dao.PettyCashDao;
import com.lms.lms.model.PettyCashModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PettyCashDaoImpl implements PettyCashDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean insertDetails(PettyCashModel pettyCashModel) {

        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(pettyCashModel);
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

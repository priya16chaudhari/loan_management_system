package com.lms.lms.dao.impl;

import com.lms.lms.dao.LoginDao;
import com.lms.lms.model.LoginModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<LoginModel> getLoginRecords()
    {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from LoginModel");
//                query.setParameter("status",status);
            // query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
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

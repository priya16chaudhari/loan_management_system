package com.lms.lms.dao.impl;

import com.lms.lms.dao.AdminCustomerDao;
import com.lms.lms.dto.AdminCustomerDto;
import com.lms.lms.model.AdminCustomerMaster;
import com.lms.lms.model.BorrowerModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class AdminCustomerDaoImpl implements AdminCustomerDao {

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public boolean insertDetails(AdminCustomerMaster adminCustomerMaster) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(adminCustomerMaster);
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
    public AdminCustomerDto getnameWiseDao(String name) {
        Session session=null;
        List list=null;
        AdminCustomerDto adminCustomerDto=new AdminCustomerDto();
        try {

            session=sessionFactory.openSession();


            Query query5 = session.createQuery("select cm.customerId as customerId from AdminCustomerMaster as cm where cm.name=:name");
            query5.setParameter("name", name);
            Integer cid = (Integer) query5.uniqueResult();

            adminCustomerDto.setCustomerId(cid);


            Query query = session.createQuery("select cm.name as name from AdminCustomerMaster as cm where cm.name=:name");
            query.setParameter("name", name);
            String bname = (String) query.uniqueResult();

            adminCustomerDto.setName(bname);

            Query query1 = session.createQuery("select cm.accNo as accNo from AdminCustomerMaster as cm where cm.name=:name");
            query1.setParameter("name", name);
            String actno = (String) query1.uniqueResult();

            adminCustomerDto.setAccNo(actno);


            Query query2 = session.createQuery("select cm.returnDate as returnDate from AdminCustomerMaster as cm where cm.name=:name");
            query2.setParameter("name", name);
            Date radate = (Date) query2.uniqueResult();

            adminCustomerDto.setReturnDate(radate);

            Query query3 = session.createQuery("select cm.remainAmt as remainAmt from AdminCustomerMaster as cm where cm.name=:name");
            query3.setParameter("name", name);
            Integer remainAmt = (Integer) query3.uniqueResult();

            adminCustomerDto.setRemainAmt(remainAmt);

            Query query4 = session.createQuery("select cm.targetAmt as targetAmt from AdminCustomerMaster as cm where cm.name=:name");
            query4.setParameter("name", name);
            Integer targetAmt = (Integer) query4.uniqueResult();

            adminCustomerDto.setTargetAmt(targetAmt);


            Query query78 = session.createQuery("select cm.status as status from AdminCustomerMaster as cm where cm.name=:name");
            query78.setParameter("name", name);
            String status = (String) query78.uniqueResult();

            adminCustomerDto.setStatus(status);

            Query query8 = session.createQuery("select cm.emi as emi from AdminCustomerMaster as cm where cm.name=:name");
            query8.setParameter("name", name);
            Integer emi = (Integer) query8.uniqueResult();

            adminCustomerDto.setEmi(emi);

            return adminCustomerDto;
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return adminCustomerDto;
    }

    @Override
    public boolean updateDetails(AdminCustomerMaster adminCustomerMaster) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(adminCustomerMaster);
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
    public List getLists() {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from AdminCustomerMaster");
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
    public List getPendingLists() {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from AdminCustomerMaster as am where am.status='pending'");
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
    public List getOverdueLists() {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from AdminCustomerMaster as am where am.status='overdue'");
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
    public List getCloseLists() {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from AdminCustomerMaster as am where am.status='close'");
//            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
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
    public List getReturnDate() {

        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from BorrowerModel");
//            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            list=query.list();
            System.out.println("sizeeeee"+list.size());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;
//        Session session=null;
//        List list=null;
//        Date rdate=null;
//        try {
//            session=sessionFactory.openSession();
//            Query query=session.createQuery("select am.returnDate as returnDate from BorrowerModel as am where am.name=:name");
//            query.setParameter("name",name);
//;            //            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//             rdate=(Date)query.uniqueResult();
//             System.out.println("dao ///"+rdate);
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }
//        return rdate;


    }

}

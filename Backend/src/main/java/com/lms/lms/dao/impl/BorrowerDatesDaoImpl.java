package com.lms.lms.dao.impl;

import com.lms.lms.dao.BorrowerDatesDao;
import com.lms.lms.dto.BorrowerDto;
import com.lms.lms.model.BorrowerDatesModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class BorrowerDatesDaoImpl implements BorrowerDatesDao{
    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public boolean insertDates(BorrowerDto borrowerDto) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();

            BorrowerDatesModel borrowerDatesModel=new BorrowerDatesModel();

            String incDate;
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());

            borrowerDatesModel.setDatess(new Date());
            borrowerDatesModel.setBorrowerNames(borrowerDto.getName());
            borrowerDatesModel.setNewStatus("unpaid");
            borrowerDatesModel.setAmount(00);
            session.save(borrowerDatesModel);

        BorrowerDatesModel[] borrowerDatesModel1 = new BorrowerDatesModel[50];
        for( int i=1; i<50; i++)
        {

            c.add(Calendar.DATE, 1);
            incDate = sdf.format(c.getTime());
            borrowerDatesModel1[i] = new BorrowerDatesModel();

            borrowerDatesModel1[i].setBorrowerNames(borrowerDto.getName());
//            System.out.println("name"+borrowerDto.getName());
            borrowerDatesModel1[i].setNewStatus("unpaid");
            borrowerDatesModel1[i].setAmount(00);
//            System.out.println("unpaid");
            try {

                Date today = sdf.parse(incDate);
//                System.out.println("Date is gggggg: " + today);
                borrowerDatesModel1[i].setDatess(today);
                session.save(borrowerDatesModel1[i]);

            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
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
    public boolean updateData(BorrowerDatesModel borrowerDatesModel) {

//        Session session=null;
//        try
//        {
//            session=sessionFactory.openSession();
//            Transaction tr=session.beginTransaction();
//            session.update(borrowerDatesModel);
//            tr.commit();
//            return true;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return false;
//
//        }
//        finally {
//            session.close();
//        }

        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
//            session.update(companyModel);

            Query query=session.createQuery("update BorrowerDatesModel as am set am.amount=:amount,am.newStatus=:newStatus where am.datess=:datess and am.borrowerNames=:borrowerNames");
            query.setParameter("datess",borrowerDatesModel.getDatess());
            query.setParameter("borrowerNames",borrowerDatesModel.getBorrowerNames());
            query.setParameter("newStatus",borrowerDatesModel.getNewStatus());
            query.setParameter("amount",borrowerDatesModel.getAmount());
//            query.setParameter("companyId",+companyId);
            query.executeUpdate();
            tr.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean insertDateDao(BorrowerDatesModel borrowerDatesModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(borrowerDatesModel);
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
    public List getNamewiseDetails(String borrowerNames) {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
//            Query query=session.createQuery("select bdm.datess as datess,bdm.newStatus as newStatus,bdm.amount as amount from BorrowerDatesModel as bdm where bdm.borrowerNames=:borrowerNames");
//            query.setParameter("borrowerNames",borrowerNames);
//

            Query query=session.createQuery("select bdm.datess as datess from BorrowerDatesModel as bdm where bdm.borrowerNames=:borrowerNames");
            query.setParameter("borrowerNames",borrowerNames);

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
    public List getAmtwiseDetails(String borrowerNames) {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
//            Query query=session.createQuery("select bdm.datess as datess,bdm.newStatus as newStatus,bdm.amount as amount from BorrowerDatesModel as bdm where bdm.borrowerNames=:borrowerNames");
//            query.setParameter("borrowerNames",borrowerNames);
//

            Query query=session.createQuery("select bdm.amount as amount from BorrowerDatesModel as bdm where bdm.borrowerNames=:borrowerNames");
            query.setParameter("borrowerNames",borrowerNames);

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
    public List getstatuswiseDetails(String borrowerNames) {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
//            Query query=session.createQuery("select bdm.datess as datess,bdm.newStatus as newStatus,bdm.amount as amount from BorrowerDatesModel as bdm where bdm.borrowerNames=:borrowerNames");
//            query.setParameter("borrowerNames",borrowerNames);
//

            Query query=session.createQuery("select bdm.newStatus as newStatus from BorrowerDatesModel as bdm where bdm.borrowerNames=:borrowerNames");
            query.setParameter("borrowerNames",borrowerNames);

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


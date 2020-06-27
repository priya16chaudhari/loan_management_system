package com.lms.lms.dao.impl;

import com.lms.lms.dao.BusinessLoanDao;
import com.lms.lms.model.BusinessLoanModel;
import javassist.bytecode.stackmap.BasicBlock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class BusinessLoanDaoImpl implements BusinessLoanDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public boolean insertBusinessRecord(BusinessLoanModel businessLoanModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(businessLoanModel);
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
    public List getBusinessRecords() {
        Session session=null;
        List<BusinessLoanModel> list=new ArrayList<>();

        List<BusinessLoanModel> updatedList=new ArrayList<>();
        try
        {
            session=sessionFactory.openSession();

            Query query=session.createQuery("from BusinessLoanModel");
            list=query.list();


                            String i;
                            String pp;
                            Date today = new Date();
                            Date todaydate=new Date();
                            Date datetoday = null;
                            String formatteddatetoday = null;
                            DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
                            SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("yyyy-MM-dd");
                            String todaydates = DATE_FORMAT1.format(todaydate);


                                datetoday = df1.parse(todaydates);

                                System.out.println("datetoday date" + datetoday);

                                formatteddatetoday = df1.format(datetoday);
                                System.out.println("datetoday date without time" + formatteddatetoday);


                                 BusinessLoanModel businessLoanModel1=new BusinessLoanModel();

                                    for (BusinessLoanModel businessLoanModel:list)
                                    {
                                        if (datetoday.compareTo(businessLoanModel.getAlertdate()) == 0)
                                        {

                                            System.out.println("nameeeeeeeeee" + businessLoanModel.getName());
                                            System.out.println("getAlertdate" + businessLoanModel.getAlertdate());

                                            Date alert = businessLoanModel.getAlertdate();

                                            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
                                            String date = DATE_FORMAT.format(today);
                                            String datett = DATE_FORMAT.format(alert);
                                            System.out.println("Today in dd-MM-yyyy format : " + date);
                                            System.out.println("Today in dd-MM-yyyy format : " + datett);

                                            Date date1 = null;
                                            Date date2 = null;
                                            String formatteddate = null;
                                            String formatteddate2 = null;
                                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");



                                                date1 = df.parse(date);
                                                date2 = df.parse(datett);
                                                System.out.println("new date" + date1);
                                                System.out.println("alert date" + date2);
                                                formatteddate = df.format(date1);
                                                formatteddate2 = df.format(date2);
                                                System.out.println("new formatteddate without time" + formatteddate);
                                                System.out.println("new formatteddate2 without time" + formatteddate2);

                                                Date tempDate=date2;
                                            Calendar c1 = Calendar.getInstance();
                                            c1.setTime(tempDate);
                                            c1.add(Calendar.DATE, 1);
                                            pp = DATE_FORMAT.format(c1.getTime());

                                            tempDate = DATE_FORMAT.parse(pp);
                                            System.out.println("tempdate =" + tempDate);
                                                if (businessLoanModel.getAlertdate().compareTo(businessLoanModel.getReturnDate()) <= 0)
                                                {

                                                    Date date4;
                                                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                                                    Calendar c = Calendar.getInstance();
                                                    c.setTime(businessLoanModel.getAlertdate());
                                                    c.add(Calendar.DATE, 1);
                                                    i = sdf.format(c.getTime());

                                                    date4 = sdf.parse(i);
                                                    System.out.println("date 1=" + date4);

                                                    Transaction tr = session.beginTransaction();
                                                    businessLoanModel.setBusinessLoanId(businessLoanModel.getBusinessLoanId());
                                                    businessLoanModel.setAlertdate(date4);
                                                    businessLoanModel.setName(businessLoanModel.getName());
                                                    businessLoanModel.setAddress(businessLoanModel.getAddress());
                                                    businessLoanModel.setCno(businessLoanModel.getCno());
                                                    businessLoanModel.setLoanAmount(businessLoanModel.getLoanAmount());
                                                    businessLoanModel.setStatus(businessLoanModel.getStatus());
                                                    businessLoanModel.setPercent(businessLoanModel.getPercent());
                                                    businessLoanModel.setReturnAmount(businessLoanModel.getReturnAmount());
                                                    businessLoanModel.setReturnDate(businessLoanModel.getReturnDate());
                                                    businessLoanModel.setCurrentDate(businessLoanModel.getCurrentDate());

                                                    updatedList.add(businessLoanModel);

                                                    if(tempDate.compareTo(date1)==0)
                                                    {
                                                        System.out.println("tempdate and date1(current)");
                                                        System.out.println("tempdate="+tempDate);
                                                        System.out.println("date1 current="+date1);
                                                        session.update(businessLoanModel);
                                                        tr.commit();
                                                    }


                                                }
                                            }

                                        }





            }

        catch(ParseException g)
        {
            g.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return updatedList;

    }

    @Override
    public boolean updatedaofun(String name) {

        System.out.println("pppppppppp"+name);
        return true;
    }

    @Override
    public List getBusinessRecords1() {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from BusinessLoanModel");
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

//    @Override
//    public boolean updatedaofun(BusinessLoanModel businessLoanModel) {
//
//        Session session=null;
//        try
//        {
//            session=sessionFactory.openSession();
//            Transaction tr=session.beginTransaction();
//            session.update(businessLoanModel);
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
//
//
//    }
}

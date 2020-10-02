/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.dao.dashboarddao;

import com.struts2.model.inputbeans.UserInputBean;
import com.struts2.util.mapping.Onlineaccount;
import com.struts2.util.hibernateUtil.NewHibernateUtil;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.struts2.model.login.LoginModelClass;
import com.struts2.model.user.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.struts2.util.mapping.Onlineaccount;

/**
 *
 * @author yomal_m
 */
public class DashboardDAO {
    public List<LoginModelClass> gettingDataFromDB(){
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session s = factory.openSession();
       
       
        //String sql = "from Hib as u where u.lastName='"+model.getUsername()+"' and u.firstName='"+model.getPassword()+"'";
       //Query query = s.createQuery(sql);
        String sql = "from Onlineaccount";
        Query query = s.createQuery(sql);

        List<LoginModelClass> userTalbe = query.list();
        
        s.clear();
        s.close();
        return userTalbe;
        
    }
    
    public List<User> gettingJsonData(int inputbean){
        
        List<User> userData = new ArrayList<>();
        long count=0;
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session s = factory.openSession();
        Transaction txn = null;
       
       txn = s.beginTransaction();
        //String sql = "from Hib as u where u.lastName='"+model.getUsername()+"' and u.firstName='"+model.getPassword()+"'";
       //Query query = s.createQuery(sql);
        String sql = "select count(userId) from Onlineaccount";
        Query query = s.createQuery(sql);

        Iterator userTalbe = query.iterate();
        if(userTalbe.hasNext()){
            count = (long) userTalbe.next();
            System.out.println("Count" +count);
        }
        
        if(count>0){
            String sqlRe = "from Onlineaccount";    
            Query queryRe = s.createQuery(sqlRe);
            Iterator itRe = queryRe.iterate();
            while(itRe.hasNext()){
                User dataBean = new User();
                Onlineaccount agenttmp = (Onlineaccount) itRe.next();
                dataBean.setId(agenttmp.getUserId());
                dataBean.setUsername(agenttmp.getUserName());
                dataBean.setMobileNumber(agenttmp.getMobileNumber());
                dataBean.setGender(agenttmp.getGender());
                
                userData.add(dataBean);

                
            }

            
        }
        txn.commit();
        s.clear();
        s.close();
        
        return userData;
        
    }
    
    
    public Onlineaccount findUserById(int userId){
        Onlineaccount account = null;
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session s = factory.openSession();
        
        account = (Onlineaccount) s.get(Onlineaccount.class, userId);
        
        s.clear();
        s.close();
        return account;
        
    } 
    
}

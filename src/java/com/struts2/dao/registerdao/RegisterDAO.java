/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.dao.registerdao;

import com.struts2.model.inputbeans.UserInputBean;
import com.struts2.model.user.User;
import com.struts2.util.hibernateUtil.NewHibernateUtil;
import com.struts2.util.mapping.Onlineaccount;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author yomal_m
 */
public class RegisterDAO {
    public void registerUser(UserInputBean usermodel){
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session s = factory.openSession();
        Transaction transaction = s.beginTransaction();
        Onlineaccount account = new Onlineaccount();
        account.setUserName(usermodel.getUsername());
        account.setMobileNumber(usermodel.getMobileNumber());
        account.setGender(usermodel.getGender());
        account.setPassword(usermodel.getPassword());
        
        s.save(account);
        s.getTransaction().commit();
        s.close();
        
       
        //String sql = "from Hib as u where u.lastName='"+model.getUsername()+"' and u.firstName='"+model.getPassword()+"'";
       //Query query = s.createQuery(sql);
//        String sql = "insert into Onlineaccount s set s.userName=:user_name, s.mobileNumber=:mobile_number, s.gender=:gender, s.password=password";
//        Query query = s.createQuery(sql);
//        query.setParameter("user_name", usermodel.getUsername());
//        query.setParameter("mobile_number", usermodel.getMobileNumber());
//        query.setParameter("gender", usermodel.getGender());
//        query.setParameter("password", usermodel.getPassword());
//        query.executeUpdate();
        
        
    }
}

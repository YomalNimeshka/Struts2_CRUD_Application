/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.dao.deletedao;

import com.struts2.model.user.User;
import com.struts2.util.hibernateUtil.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author yomal_m
 */
public class DeleteDAO {
    public void deleteUserFromDB(int usermodel){
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session s = factory.openSession();
         Transaction transaction = s.beginTransaction();
       
       
        //String sql = "from Hib as u where u.lastName='"+model.getUsername()+"' and u.firstName='"+model.getPassword()+"'";
       //Query query = s.createQuery(sql);
        String sql = "delete Onlineaccount s where s.id=:acc_id";
        Query query = s.createQuery(sql);
        query.setParameter("acc_id", usermodel);
        query.executeUpdate();
        transaction.commit();
        s.clear();
        s.close();
    }
}

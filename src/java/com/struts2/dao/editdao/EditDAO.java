/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.dao.editdao;

import com.struts2.model.inputbeans.UserInputBean;
import com.struts2.model.login.LoginModelClass;
import com.struts2.model.user.User;
import com.struts2.util.hibernateUtil.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author yomal_m
 */
public class EditDAO {
    public List<User> gettingDataFromDB(int userId){
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session s = factory.openSession();
       
       
        //String sql = "from Hib as u where u.lastName='"+model.getUsername()+"' and u.firstName='"+model.getPassword()+"'";
       //Query query = s.createQuery(sql);
        String sql = "from Onlineaccount s where userId=:acc_id";
        Query query = s.createQuery(sql).setInteger("acc_id", userId );
        //System.out.println("Edit data --------------------");
        List<User> userTalbe = query.list();

        s.clear();
        s.close();
        return userTalbe;
        
    }
    
    public void UpdateTheDataBase(UserInputBean usermodel){
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session s = factory.openSession();
         Transaction transaction = s.beginTransaction();
       
       
        //String sql = "from Hib as u where u.lastName='"+model.getUsername()+"' and u.firstName='"+model.getPassword()+"'";
       //Query query = s.createQuery(sql);
        String sql = "update Onlineaccount s set s.userName=:user_name, s.mobileNumber=:mobile_number, s.gender=:gender where s.id=:acc_id";
        Query query = s.createQuery(sql);
        query.setParameter("user_name", usermodel.getUsername());
        query.setParameter("mobile_number", usermodel.getMobileNumber());
        query.setParameter("gender", usermodel.getGender());
        query.setParameter("acc_id", usermodel.getId());
        query.executeUpdate();
        transaction.commit();
        s.clear();
        s.close();
    }
}

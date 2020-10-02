/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.dao.logindao;

import com.struts2.util.mapping.Onlineaccount;
import com.struts2.util.hibernateUtil.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import com.struts2.model.login.LoginModelClass;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author yomal_m
 */
public class LoginDAO {
    
    public int LoginAuth(LoginModelClass model){
        int dataAvailable=0;
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session s = factory.openSession();
        List<Onlineaccount> userroleList = new ArrayList<>();
       
        //String sql = "from Hib as u where u.lastName='"+model.getUsername()+"' and u.firstName='"+model.getPassword()+"'";
       //Query query = s.createQuery(sql);
        String sql = "from Onlineaccount as u where u.userName=:user_name and u.password=:password";
        Query query = s.createQuery(sql).setString("user_name", model.getUsername()).setString("password", model.getPassword());
        
        java.util.List list = query.list();
        System.out.println("List size : "+list.size());
        if(list.size()>0){
            return dataAvailable =1;
        }else if(list.isEmpty()){
            return dataAvailable = 0;
        }
        return dataAvailable;   
    }
    
}

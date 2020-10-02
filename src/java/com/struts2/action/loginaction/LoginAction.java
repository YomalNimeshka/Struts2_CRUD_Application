/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.action.loginaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts2.dao.logindao.LoginDAO;
import com.struts2.model.login.LoginModelClass;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author yomal_m
 */
public class LoginAction extends ActionSupport implements ModelDriven, SessionAware {

    private LoginModelClass model = new LoginModelClass();
    private LoginDAO loginDao = new LoginDAO();
    private Map<String, Object> session;
    

   
    

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public LoginModelClass getLoginModelClass() {
        return model;
    }

    public void setLoginModelClass(LoginModelClass model) {
        this.model = model;
    }

    public LoginAction() {
    }

    public String execute() throws Exception {
        return null;
    }
    
    public String Check(){
        System.out.println(">>>>>>>>>>>>>>  Login Called ");
        int connected = loginDao.LoginAuth(model);
        System.out.println("Login Action username : " + model.getUsername());
        if (connected == 1) {
            this.session = ActionContext.getContext().getSession();
            session.put("loginId", model.getUsername());
            System.out.println(">>>>>>>>>>>>>>  Login SUCCESS ");
            
            return "getdash";
        } else {
            System.out.println(">>>>>>>>>>>>>>  Login FAILED ");
            return "loginpage";
        }
       
    }
    
    public String Add(){
        return "add";
    }
    
    

    @Override
    public Object getModel() {
        return model;
    }

}

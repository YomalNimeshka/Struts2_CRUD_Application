/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.action.registeraction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts2.dao.registerdao.RegisterDAO;
import com.struts2.model.inputbeans.UserInputBean;
import com.struts2.model.user.User;

/**
 *
 * @author yomal_m
 */
public class RegisterAction extends ActionSupport implements ModelDriven{
   
    private RegisterDAO dao = new RegisterDAO();
    
    private UserInputBean inputbean = new UserInputBean();
    
    public RegisterAction() {
    }
    
    public String execute() throws Exception {
        return null;
    }
    
   
    
    public String User(){
        System.out.println(">>>>>>>>>>>>>>  Register Called ");
        dao.registerUser(inputbean);
        System.out.println(">>>>>>>>>>>>>>  Registed User " +inputbean.getUsername());

        return "add";
    }

    @Override
    public Object getModel() {
        return inputbean;
    }
    
    
}

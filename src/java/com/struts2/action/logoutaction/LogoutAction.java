/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.action.logoutaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author yomal_m
 */
public class LogoutAction extends ActionSupport {
    private Map<String,Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
    
    public LogoutAction() {
    }
    
    public String execute() throws Exception {
        
        return SUCCESS;
    }
    
}

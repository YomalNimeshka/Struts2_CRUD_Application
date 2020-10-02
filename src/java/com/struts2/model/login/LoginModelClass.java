/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.model.login;

/**
 *
 * @author yomal_m
 */
public class LoginModelClass {
    private String username;
    private String password;

    public LoginModelClass(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

    public LoginModelClass() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}

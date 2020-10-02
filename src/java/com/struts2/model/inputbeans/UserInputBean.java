/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.model.inputbeans;

import com.struts2.model.login.LoginModelClass;
import com.struts2.model.user.User;
import java.util.List;

/**
 *
 * @author yomal_m
 */
public class UserInputBean {
    private int id;
    private String username;
    private String mobileNumber;
    private String gender;
    private String password;

 
    private List<LoginModelClass> dashboardData;
    private List<User> viewEditData;
    
    private List<User> gridModel;

   
    
    
    
      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public List<LoginModelClass> getDashboardData() {
        return dashboardData;
    }

    public void setDashboardData(List<LoginModelClass> dashboardData) {
        this.dashboardData = dashboardData;
    }

   

    public List<User> getViewEditData() {
        return viewEditData;
    }

    public void setViewEditData(List<User> viewEditData) {
        this.viewEditData = viewEditData;
    }

    public List<User> getGridModel() {
        return gridModel;
    }

    public void setGridModel(List<User> gridModel) {
        this.gridModel = gridModel;
    }
    
    
    
    
}

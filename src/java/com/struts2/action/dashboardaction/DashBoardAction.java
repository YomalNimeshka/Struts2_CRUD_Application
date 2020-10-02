/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.action.dashboardaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts2.dao.dashboarddao.DashboardDAO;
import com.struts2.dao.deletedao.DeleteDAO;
import com.struts2.dao.editdao.EditDAO;
import com.struts2.model.inputbeans.UserInputBean;
import java.util.ArrayList;
import java.util.List;
import com.struts2.model.login.LoginModelClass;
import com.struts2.model.user.User;
import com.struts2.util.mapping.Onlineaccount;
import java.util.Map;

/**
 *
 * @author yomal_m
 */
public class DashBoardAction extends ActionSupport implements ModelDriven<Object>{
    
    private UserInputBean inputbean = new UserInputBean();
    
    private Map<String,Object> session;
    

    private EditDAO editDao = new EditDAO();
    private DashboardDAO dashboardDao = new DashboardDAO();
    private DeleteDAO deleteDao = new DeleteDAO();

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

   
    

    public DashBoardAction() {
    }

    @Override
    public String execute() throws Exception {
        return null;
    }

    //View the DashBoard Data
    public String View() {
        System.out.println(">>>>>>>>>>>>>>  View Dashboard Called ");
        List<LoginModelClass> dashboardDataList = dashboardDao.gettingDataFromDB();        
        inputbean.setDashboardData(dashboardDataList);
        //list = dashboardDao.gettingDataFromDB();

        System.out.println(">>>>>>>>>>>>>>  View Showed ");
        return "view";

    }
    
    //Edit the users in the dashboard
    public String Edit(){
        System.out.println(">>>>>>>>>>>>>>  Edit Dashboard Called ");
        List<User> editValues = editDao.gettingDataFromDB(inputbean.getId());
        System.out.println("input bean user model : " +inputbean.getId());
        inputbean.setViewEditData(editValues);
        System.out.println(">>>>>>>>>>>>>>  Edit Dashboard Details snet ");
        return "edit";
    }
    
    //edited users in the dashboard
    public String Edited(){
        System.out.println(">>>>>>>>>>>>>>  User Edited ");
        editDao.UpdateTheDataBase(inputbean);
        return "edited";
    }
    
    public String Delete(){
        System.out.println(">>>>>>>>>>>>>>  Deleted Called ");
        deleteDao.deleteUserFromDB(inputbean.getId());
        System.out.println(">>>>>>>>>>>>>>  User Deleted " );
        return "deleted";
    }
    
    public String Logout(){
        System.out.println(">>>>>>>>>>>>>>  Logout Called ");
        this.session = ActionContext.getContext().getSession();
        session.remove("loginId");
        System.out.println(">>>>>>>>>>>>>>  Logout Ended ");
        return "logout";
    }

    public String Listt() {
        System.out.println("List() called");
        List<User> newDataList = dashboardDao.gettingJsonData(inputbean.getId());
        inputbean.setGridModel(newDataList);
        
        return "list";

    }
    
    public String Find(){
        Onlineaccount user = new DashboardDAO().findUserById(inputbean.getId());
        
        inputbean.setId(user.getUserId());
        inputbean.setUsername(user.getUserName());
        inputbean.setMobileNumber(user.getMobileNumber());
        inputbean.setGender(user.getGender());
        
        return "find";
    }
    
    public String EditJ(){
        System.out.println(">>>>>>>>>>>>>> Edit J Called");
        editDao.UpdateTheDataBase(inputbean);
        
        return "editj";
    }
    
    public String DeleteJ(){
        System.out.println(">>>>>>>>>>>>>> Delete J Called");
        deleteDao.deleteUserFromDB(inputbean.getId());
        return "deletej";
    }
    
    

    @Override
    public Object getModel() {
        return inputbean;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts2.util.interceptor;

import com.opensymphony.xwork2.ActionInvocation;  
import com.opensymphony.xwork2.interceptor.Interceptor;  
import com.opensymphony.xwork2.util.ValueStack;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author yomal_m
 */
public class InterceptorClass implements Interceptor {

    @Override
    public void destroy() {
         System.out.println("-------------Access Control Interceptor : Destroyed-------------");
    }

    @Override
    public void init() {
         System.out.println("-------------Access Control Interceptor : Initialized-------------");
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Map<String, Object> sessionAttributes = ai.getInvocationContext().getSession();
        String result="";
        System.out.println("-------Access Control Interceptor : Started-------");
        try{
            HttpServletResponse response = ServletActionContext.getResponse();
            // Set standard HTTP/1.1 no-cache headers.
            response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            
            //New Header to avoid MIME type sniffing
            response.setHeader("X-Content-Type-Options", "nosniff");
            
            
            if(sessionAttributes == null || sessionAttributes.get("loginId") ==null){
                System.out.println("----------No Session available-----------");
                return  result = "login";
            
            }else{
                if(!((String)sessionAttributes.get("loginId")).equals(null)){
                    System.out.println("-------Session login id : " +(String)sessionAttributes.get("loginId")+"--------");
                   System.out.println("-------Access Control Interceptor : Ended-------");
                    return result= ai.invoke();
                
            }else{
                return result="login";
            }}
        }catch(Exception e){
                e.printStackTrace();
        }
         
         return result;
            
        }
        
        
//       try{
//            System.out.println("-------Access Control Interceptor : Started-------");
//            String className = ai.getAction().getClass().getName();
//            System.out.println("Access Control Interceptor : Intercepted " + className);
//            result=ai.invoke();
//       }catch(Exception e){
//           e.printStackTrace();
//       }       
//        System.out.println("-------Access Control Interceptor : Stopped-------");
        //return result;
    
    
}

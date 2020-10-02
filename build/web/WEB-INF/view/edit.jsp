<%-- 
    Document   : edit
    Created on : Sep 25, 2020, 7:19:40 AM
    Author     : yomal_m
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
        <h1>Edit</h1>
        
        <s:form action="EditedDashBoard" method="post">
             <s:iterator value="getViewEditData()">
             <s:textfield label="ID" key="id" value="%{userId}" readonly="true"></s:textfield>
             <s:textfield label="User Name" key="username" value="%{userName}" ></s:textfield>
             <s:textfield label="Mobile Number" key="mobileNumber" value="%{mobileNumber}" ></s:textfield>
             <s:textfield label="Gender" value="%{gender}" readonly="true"></s:textfield>
             <s:select label="Gender" list="#{'male':'male', 'female':'female'}" key="gender" required="required"/>
             </s:iterator>
            <s:submit/>
        </s:form>
        
    </body>
</html>

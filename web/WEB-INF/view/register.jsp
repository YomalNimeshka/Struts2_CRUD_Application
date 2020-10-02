<%-- 
    Document   : register
    Created on : Sep 25, 2020, 10:40:22 AM
    Author     : yomal_m
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <s:form method="post" action="UserRegister">
            <s:textfield label="USERNAME" key="username" ></s:textfield>
            <s:textfield label="MOBILE NUMBER" key="mobileNumber" ></s:textfield>
            <s:select label="Gender" list="#{'male':'male', 'female':'female'}" key="gender" required="required"/>
            <s:password label="PASSWORD"  key="password"  ></s:password>
            <s:submit/>
        </s:form>
    </body>
</html>

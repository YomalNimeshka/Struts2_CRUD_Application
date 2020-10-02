<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title><s:text name="Login"/></title>
        
    </head>

    <body>
        <h2>Login</h2>

        <s:form method="post" action="CheckUserLogin" namespace="/">
            <s:textfield label="USERNAME" key="username" ></s:textfield>
            <s:password label="PASSWORD"  key="password"  ></s:password>
            <s:submit/>
        </s:form>
       
        <s:a action="AddUserLogin" namespace="/">Register</s:a>
        
         

    </body>
</html>


<%-- 
    Document   : retriveList
    Created on : Sep 29, 2020, 10:13:15 AM
    Author     : yomal_m
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjc" uri="/struts-jquery-chart-tags"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<!--            <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>-->
<!--        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/highchart/modules/exporting.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/highchart/modules/export-data.js"></script>-->
        <script type="text/javascript">


        </script>
    <body>
        <h1>List Retrive</h1>
       <div id="websparrow">
            <s:url var="listurl" action="Listt"/>
                    <sjg:grid
                        id="datatable"
                        caption="Users"
                        dataType="json"
                        href="%{listurl}"
                        pager="false"
                        autowidth="true"
                        gridModel="dataList"
                                                   
                        >
                        <sjg:gridColumn name="username" index="username" title="Info"  sortable="false" frozen="true" />
                                      
                    </sjg:grid> 
            
        </div>
    </body>
</html>

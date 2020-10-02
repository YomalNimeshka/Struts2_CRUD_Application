

<%-- 
    Document   : loginSuccess
    Created on : Sep 21, 2020, 1:43:00 PM
    Author     : yomal_m
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@taglib uri="/struts-jquery-grid-tags" prefix="sjg" %>

<!DOCTYPE html>
<html>
    <head>
        <sj:head jqueryui="true" jquerytheme="redmond" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logged in</title>
        <style>
            table, th, td {    
                border: 1px solid black;
                width: 50%;
            }


            #formstyle{
                padding: 10px;
                border:1px solid #DFDFDF;
                min-height: 115px;
                font-weight: inherit;
                margin-left:10px;
                margin-bottom: 5px;
                margin-top: 10px;
                width:95%;  
                border-radius:5px;
                /*    box-shadow: 0 1px 2px rgba(0,0,0,0.5);*/
                border: 1px solid #9d9d9d;

            }

            #formstyle-customfields{
                min-height: 150px;
                font-weight: inherit;
                margin-bottom: 10px;
                margin-top: 10px;
                width:95%;  
            }

            #tablediv{
                margin-left:10px;
                width:95%;
                /*width: 1065px;*/
                margin-bottom: 30px;
            }
            #tabledivDual{
                margin-left:10px;
                width:95%;
                /*width: 1065px;*/
                margin-bottom: 30px;
            }
            #divmsg{
                margin-left:10px;
                width:95%;  
            }
        </style>
        <script type="text/javascript">
            function editformatter(cellvalue, options, rowObject) {
                return "<a href='javascript:void(0)' title='Edit' onClick='javascript:editjUser(&#34;" + cellvalue + "&#34;)'><img class='ui-icon ui-icon-pencil' style='display:inline-table;border:none;'/></a>";
            }

            function deleteformatter(cellvalue, options, rowObject) {
                return "<a href='javascript:void(0)' title='Delete' onClick='javascript:deletejUser(&#34;" + cellvalue + "&#34;)'><img class='ui-icon ui-icon-trash' style='display:inline-table;border:none;' /></a>";
            }

            function editjUser(keyval) {

                $.ajax({
                    url: '${pageContext.request.contextPath}/FindDashBoard.blb',
                    data: {id: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        $('#editj').empty();
                        var msg = data.message;
                        if (msg) {
                            alert(msg);
                        } else {
                            $('#editform').show();
                            $('#id').val(keyval);
                            $('#username').val(data.username);
                            $('#mobileNumber').val(data.mobileNumber);
                            $('#gender').val(data.gender);

                        }
                    },
                    error: function (data) {
                        alert("No data on editj");
                        window.location = "${pageContext.request.contextPath}/LogoutDashBoard.blb?";
                    }
                });
            }

            function deletejUser(keyval) {
                $('#deletej').empty();
                $("#deletedialog").data('keyval', keyval).dialog('open');
                $("#deletedialog").html('Are you sure you want to delete user ' + keyval + ' ?');
                return false;
            }

            function deletejUserAjax(keyval) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/DeleteJDashBoard.blb',
                    data: {id: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        $('#deletej').empty();
                        if (data.delsuccess == 1) {
                            $("#deletesuccdialog").dialog('open');
                            $("#deletesuccdialog").html(data.message);
                        } else {
                            $("#deleteerrordialog").dialog('open');
                            $("#deleteerrordialog").html(data.message);
                        }
                        window.onclick(location.reload(true));
                    },
                    error: function (data) {
                        
                    }
                });
            }

        </script>    


    </head>

    <body>
        <h1>DashBoard</h1>
        <s:set var="vupdate"><s:property value="vupdate" default="true"/></s:set>
        <s:set var="vdelete"><s:property value="vdelete" default="true"/></s:set>


            <!-- Start delete confirm dialog box -->
        <sj:dialog 
            id="deletedialog" 
            buttons="{ 
            'OK':function() { deletejUserAjax($(this).data('keyval'));$( this ).dialog( 'close' ); 
            onclick='location.reload(true)'; },
            'Cancel':function() { $( this ).dialog( 'close' );} 
            }" 
            autoOpen="false" 
            modal="true" 
            title="Delete Agent"
            position="center"
            width="400"
            height="300"
            />
        <!-- End delete confirm dialog box -->
        <!-- Start delete successfully dialog box -->
        <sj:dialog 
            id="deletesuccdialog" 
            buttons="{
            'OK':function() { $( this ).dialog( 'close' );} 
            }"  
            autoOpen="false" 
            modal="true" 
            title="Deleted Successfully" 
            position="center"
            width="400"
            height="300"
            />
        <!-- End delete successfully dialog box -->
        
        

        <div id="formstyle">

            <s:form action="DashBoard" theme="simple" method="post" id="editform"  cssStyle="display:none">
                <table>
                    <tr><td></td></tr>
                    <tr><td>User ID </td><td><s:textfield id="id" name="id" maxLength="15" readonly="true"/></td></tr>                 
                    <tr><td>User Name <span style="color: red">*</span></td><td><s:textfield id="username" name="username" maxLength="64" onkeyup="$(this).val($(this).val().replace(/[^a-zA-Z0-9 ]/g,''))" /></td></tr>
                    <tr><td>User Mobile Number <span style="color: red">*</span></td><td><s:textfield id="mobileNumber" name="mobileNumber" maxLength="64" onkeyup="$(this).val($(this).val().replace(/[^a-zA-Z0-9 ]/g,''))" /></td></tr>
                    <tr><td>User Gender <span style="color: red">*</span></td><td><s:select  id="gender" list="#{'male':'male', 'female':'female'}"  name="gender" headerKey="" headerValue="--Select Gender--" /></td></tr>

                    <tr>
                        <td></td>
                        <td>
                            <s:url var="editurl" action="EditJDashBoard"/>
                            <sj:submit 
                                button="true" 
                                value="Update" 
                                href="%{editurl}" 
                                id="updatebut" 
                                targets="message" 
                                onclick="location.reload(true)"
                                />

                        </td>
                    </tr>

                </table>
            </s:form>
        </div>

        <!--Display the jquery grid-->
        <div id="tablediv">
            <s:url var="listurl" action="ListtDashBoard"></s:url>
            <sjg:grid
                id="gridtable"
                caption="Users"
                dataType="json"
                href="%{listurl}"
                pager="true"
                gridModel="gridModel"
                rowList="10,15,20,25"
                rowNum="20"
                autowidth="true"
                rownumbers="true"
                onCompleteTopics="completetopics"
                onPagingTopics="onPaging"
                rowTotal="false"
                viewrecords="true"
                shrinkToFit="false"  
                sortname="username"
                sortorder="desc"

                >
                <sjg:gridColumn name="id" index="id" title="ID"  sortable="true"  width="250" />
                <sjg:gridColumn name="username" index="username" title="Name"  sortable="false"  width="250" />
                <sjg:gridColumn name="mobileNumber" index="mobileNumber" title="Mobile Number"  sortable="true"  width="250" />
                <sjg:gridColumn name="gender" index="gender" title="Gender"  sortable="true"  width="250"/>
                <sjg:gridColumn name="id" index="id" title="Edit" width="30" align="center"  formatter="editformatter"   sortable="false"/>
                <sjg:gridColumn name="id" index="id" title="Delete" width="40" align="center"  formatter="deleteformatter"  sortable="false"/>  
            </sjg:grid> 

        </div>

        <br/>
        <br/>
        <br/>
        <br/>
        <br/>



<!--        <table>
            <tr>
                <th>ID</th>
                <th>User Name</th>
                <th>Mobile Number</th>
                <th>Gender</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <%--<s:iterator value="getDashboardData()">
                <tr> 
                    <td> <s:property value="userId"/>   </td>
                    <td> <s:property value="userName"/> </td>
                    <td> <s:property value="mobileNumber"/> </td>
                    <td> <s:property value="gender"/> </td>
                    <td> <s:a action="EditDashBoard" > <s:param name="id" ><s:property value="userId" /></s:param> Edit</s:a>
                            </td>
                            <td> <s:a action="DeleteDashBoard" onclick="return confirm('Are You sure you want to delete this user?');" ><s:param name="id" value="userId"/>Delete</s:a></td>


                    </tr>
            </s:iterator>--%>        
        </table>-->

        <br/>

        <s:a action="LogoutDashBoard"> Log Out </s:a>

    </body>

    <script>

    </script>
</html>

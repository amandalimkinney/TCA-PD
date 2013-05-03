<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Edit Account"/>
        </jsp:include>
    </head>
    <body>
        <div id="header">
                <%@include file="../WEB-INF/jspf/header.jspf" %>
        </div>

        <div id="sideBar">
            <%@include file="../WEB-INF/jspf/sidebar.jspf" %>
        </div>
        <div id="pageBody">
             
                    <form name="EditAccountForm" method="POST" action="/TCA_Professional_Development/admin/editaccount.jsp--submit" style="margin: 20px 20px 20px 20px;">
                    <table> 
                    <h1>Edit Accounts</h1>
                        
                        <tr>
                            <td>
                                <strong>First Name</strong>
                            </td>
                            <td>
                                <strong>Last Name</strong>
                            </td>
                            <td>
                                <strong>E-mail Address</strong>
                            </td>
                            <td>
                                <strong>Role</strong>
                            </td>
                            <td>
                                <strong>Delete</strong>
                            </td>
                        </tr>
                        <%@page import="java.sql.*" %>
                        <%@page import="Data_Access.*" %>
                        <%
                        String[][] accounts = AccountManagement.getAccounts();
                        if(accounts != null)
                        {
                            for(int i =0;i<accounts.length;i++)
                            {
                                String toOut = "<tr>" +
                                    "<td><input type=\"text\" value=\""+accounts[i][0]+"\" name=\"firstName"+i+"\" size=\"10\" style=\"\"/></td>" +
                                    "<td><input type=\"text\" value=\""+accounts[i][1]+"\" name=\"lastName"+i+"\" size=\"10\" style=\"\"/></td>" +
                                    "<td><input type=\"text\" value=\""+accounts[i][2]+"\" name=\"email"+i+"\" size=\"15\" style=\"\"/ readonly></td>" +
                                    "<td><select name=\"Role"+i+"\" multiple required >";
                                toOut += "<option value=\"admin\" ";if(accounts[i][3].contains("admin")){toOut+="selected";};toOut+=">Administrator</option>" ;
                                toOut += "<option value=\"headofschool\" ";if(accounts[i][3].contains("headofschool")){toOut+="selected";};toOut+=">Head of School</option>" ;
                                toOut += "<option value=\"teacher\" ";if(accounts[i][3].contains("teacher")){toOut+="selected";};toOut+=">Teacher</option>" ;
                                toOut += "<option value=\"instructor\" ";if(accounts[i][3].contains("instructor")){toOut+="selected";};toOut+=">Instructor</option>" ;
                                toOut += "<option value=\"default\" ";if(accounts[i][3].contains("default")){toOut+="selected";};toOut+=">Default</option>" ;
                                
                                toOut+="</select></td>" +
                                    "<td><input type=\"checkbox\" name=\"delete"+i+"\" value=\"Delete Account\"></td>" +
                                "</tr>";
                                
                                out.print(toOut);
                            }
                            
                        }
                        %>
                        <tr>
                            <td>
                                <input type="submit" value="Submit" style="margin: 25px 0 0 0;"/>
                            </td>
                        </tr>
                    </table>
                    </form>

                    
                    
                    <p>&nbsp;</p>
        </div>
        <div id="footer">
                <%@include file="../WEB-INF/jspf/footer.jspf" %>
            </div>
    </body>
</html>
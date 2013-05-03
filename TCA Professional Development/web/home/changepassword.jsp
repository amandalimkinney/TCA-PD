<%-- 
    Document   : newjsp
    Created on : May 2, 2013, 7:41:03 PM
    Author     : Jeff
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Main page"/>
        </jsp:include>
    </head>

    <body>
        <div id="main">
            <div id="header">
                <%@include file="../WEB-INF/jspf/header.jspf" %>
            </div>

            <div id="sideBar">
                <%@include file="../WEB-INF/jspf/sidebar.jspf" %>
            </div>

            <div id="pageBody" >
                
                
                    
                    
                    <form name="loginForm" method="POST" action="/TCA_Professional_Development/home/changepassword.jsp--submit" style="margin: 20px 20px 20px 20px;">
                    <table>
                        <h1>Change Password</h1>
                        <%
                    String errorMessage = request.getParameter("ERROR");
                    if( errorMessage != null)
                    {
                        out.print("<tr><p>" + errorMessage + "</p></tr>");
                    }
                    else
                    {
                    }
                    %>
                        <tr>
                        <td valign="top">
                            <label>Current Password: </label>
                        </td>
                        <td>
                            <input type="password" size="25" name="password" /><br/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top">
                            <label>New Password: </label>
                        </td>
                        <td>
                            <input type="password" size="25" name="password1" /><br/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top">
                            <label>Re-Enter New Password: </label>
                        </td>
                        <td>
                            <input type="password" size="25" name="password2" /><br/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit" />
                            <input type="reset" value="Reset" />
                        </td>
                    </tr>
                    </table>
                    </form>
                    
                    
                
            </div>

            <div id="footer">
                <%@include file="../WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

    </body>
</html>

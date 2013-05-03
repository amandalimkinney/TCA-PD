<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
              <title>TCA Professional Development Home</title>
        <link rel="stylesheet" type="text/css" href="../css/TCAProfDev.css" />
    </head>
    <body>
        <div id="main">
            <div id="header">
                <%@include file="/WEB-INF/jspf/indexheader.jspf" %>
            </div>
            <div id="pageBody">
                <h1>Password Reset</h1>
                <%
                if(request.getParameter("ERROR") != null )
                {
                    out.print(request.getParameter("ERROR"));
                }
                if(request.getParameter("USER") == null && request.getParameter("Message") == null)
                    {
                    out.print(
                        "<p>Please Enter Your E-Mail Address" +
                        "<form name=\"resetPasswordForm\" method=\"POST\" action=\"/TCA_Professional_Development/home/resetPassword.jsp--submit\" style=\"margin: 20px 0 0 0;\">" +
                        "<strong>E-Mail: </strong>" +
                        "<input type=\"text\" name=\"j_username\" size=\"25\" style=\"margin: 0 0 0 10px;\"/><br/><br/>" +
                        "<input type=\"submit\" value=\"Submit\" style=\"margin: 25px 0 0 0;\"/>" +
                        "</form>");
                    }
                               else if(request.getParameter("Message") == null)
                                       {
                    out.print(
                        "<form name=\"resetPasswordForm\" method=\"POST\" action=\"/TCA_Professional_Development/home/resetPassword.jsp--submit2\" style=\"margin: 20px 0 0 0;\">" +
                        "<table>"+
                        "<tr>" +
                        "<td>" +
                        "<strong>E-Mail: </strong>" +
                        "</td>" +
                        "<td>" +
                        "<input type=\"text\" name=\"username\" size=\"25\" value=\""+request.getParameter("USER")+"\" readonly style=\"margin: 0 0 0 10px;\"/><br/><br/>" +
                        "</td>" +
                        "</tr>" +
                        ""+
                        "<tr>" +
                        "<td>" +
                        "<strong>Reset Code: </strong>" +
                        "</td>" +
                        "<td>" +
                        "<input type=\"text\" name=\"code\" size=\"25\" style=\"margin: 0 0 0 10px;\"/><br/><br/>" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td>" +
                        "<input type=\"submit\" value=\"Submit\" style=\"margin: 25px 0 0 0;\"/>" +
                        "</td>" +
                        "</tr>" +
                        "</table>"+
                        "</form>");
                }
                else
                                       {
                    out.print(
                            "<Strong>"+request.getParameter("Message")+"</Strong><br>"+
                            "<a href=\"/TCA_Professional_Development/home/login.jsp\">Login Page</a>"
                            );
                }
                    %>
            </div>

            <div id="footer">
                <%@include file="../WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>
    </body>
</html>
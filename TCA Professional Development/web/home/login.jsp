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

            <div id="page1div">
                    
                    <h1>Log-in</h1>
                    <%
                    String errorMessage = request.getParameter("ERROR");
                    if( errorMessage != null)
                    {
                        out.print("<p>" + errorMessage + "</p>");
                    }
                    else
                    {
                        out.print("<p>This site requires authentication. Please enter your credentials to continue.</p>");
                    }
                    %>
                    <table>
                    <form name="loginForm" method="POST" action="/TCA_Professional_Development/home/doLogin.jsp" style="margin: 20px 0 0 0;">
                    <tr>
                        <td valign="top">
                            <label>Username: </label>
                        </td>
                        <td>
                            <input type="text" size="25" name="j_username" /><br/><br/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top">
                            <label>Password: </label>
                        </td>
                        <td>
                            <input type="password" size="25" name="j_password" /><br/><br/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit" />
                            <input type="reset" value="Reset" />
                        </td>
                    </tr>
                    </form>
                    
                    <tr>
                        <td>
                            <a href="/TCA_Professional_Development/home/RegisterAccount.jsp">Register Account</a>
                        </td>
                        <td>
                            <a href="/TCA_Professional_Development/home/resetPassword.jsp">Reset Password</a>
                        </td>
                    </tr>
                    </table>
                    <p>&nbsp;</p>
                    

                
            </div>
            <div id="footer">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

    </body>
</html>
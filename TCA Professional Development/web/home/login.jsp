<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
              <title>TCA Professional Development Home</title>
        <link rel="stylesheet" type="text/css" href="css/TCAProfDev.css" />
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
                    
                    <form name="loginForm" method="POST" action="/TCA_Professional_Development/home/doLogin.jsp" style="margin: 20px 0 0 0;">
                    <strong>Username: </strong>
                    <input type="text" name="j_username" size="25" style="margin: 0 0 0 10px;"/><br/><br/>
                    <strong>Password: </strong>
                    <input type="password" size="25" name="j_password" style="margin: 0 0 0 17px;"/><br/><br/>
                    <input type="submit" value="Submit" style="margin: 25px 0 0 0;"/>
                    <input type="reset" value="Reset" style="margin: 25px 0 0 0;"/>
                    </form>
                    
                    <a href="/TCA_Professional_Development/home/RegisterAccount.jsp">Register Account</a>
                    
                    <p>&nbsp;</p>
                    

                
            </div>
            <div id="footer">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

    </body>
</html>
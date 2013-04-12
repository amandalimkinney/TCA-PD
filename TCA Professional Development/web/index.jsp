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
                <%@include file="/WEB-INF/jspf/header.jspf" %>
            </div>

            <div id="page1div">


                    
                    <h1>Login</h1>
                    <p>This site requires authentication. Please enter your credentials to continue.</p>

                    <form name="frmLogin" onSubmit="return validate();" action="doLogin.jsp" method="post">
                    <strong>User Name</strong> <input type="text" name="sUserName" /><br />
                    <strong>Password</strong><input type="password" name="sPwd" /><br />
                    <input type="submit" name="sSubmit" value="Submit" style="margin: 5px 0 0 0;"/>
                    </form>            
                    
                    <p>&nbsp;</p>
                    

                
            </div>
            <div id="footer">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

    </body>
</html>
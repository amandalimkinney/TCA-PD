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
                    User Name <input type="text" name="sUserName" /><br />
                    Password <input type="password" name="sPwd" /><br />
                    <p>&nbsp;</p>
                    <input type="submit" name="sSubmit" value="Submit" />
                    </form>            
                    
                    <p>&nbsp;</p>
                    

                
            </div>
            <div id="footer">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

    </body>
</html>
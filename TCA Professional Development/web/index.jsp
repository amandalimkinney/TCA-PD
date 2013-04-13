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


                    
                    <h1>Login</h1>
                    <p>This site requires authentication. Please enter your credentials to continue.</p>

                    <form name="frmLogin" onSubmit="return validate();" action="home/doLogin.jsp" method="get" style="margin: 20px 0 0 0;">
                    <strong>User Name</strong> 
                    <input type="text" name="sUserName" style="margin: 0 0 0 10px;"/><br/><br/>
                    <strong>Password</strong>
                    <input type="password" name="sPwd" style="margin: 0 0 0 17px;"/><br/>
                    <input type="submit" name="sSubmit" value="Submit" style="margin: 25px 0 0 0;"/>
                    </form>            
                    
                    <p>&nbsp;</p>
                    

                
            </div>
            <div id="footer">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

    </body>
</html>
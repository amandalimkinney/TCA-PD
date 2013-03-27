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

            <div id="sideBar">
                <%@include file="/WEB-INF/jspf/sidebar.jspf" %>
            </div>

            <div id="pageBody">
                <a href="home/index.jsp"> home </a> <br>
                <a href="home/login.jsp"> log in </a>
            </div>

            <div id="footer">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

    </body>
</html>
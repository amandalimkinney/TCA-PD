<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Add PD Hours"/>
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
            You have successfully taken attendance.<BR>
            <a href="../instructor/attendance">Go back to your courses</a><br>
            <a href="../home/index.jsp">Go to homepage</a>
        </div>
        <div id="footer">
                <%@include file="../WEB-INF/jspf/footer.jspf" %>
            </div>
    </body>
</html>
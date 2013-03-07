<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="/WEB-INF/jspf/head.jsp">
        <jsp:param name="title" value="Add hours"/>
        </jsp:include>
    </head>
    <body>
        <div id="main">
        <div id="header">
            <%@include file="/WEB-INF/jspf/header.jspf" %>
        </div>

        <div id="sidebar">
            <%@include file="/WEB-INF/jspf/sidebar.jspf" %>
        </div>

        <div id="pageBody">
            <div id="addCourseBox">
                hi
            </div>

        </div>

        <div id="footer">
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
    </div>
    </body>
</html>


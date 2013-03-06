<%-- 
    Document   : index
    Created on : Mar 4, 2013, 1:43:30 PM
    Author     : Panda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        
        <jsp:include flush="true" page="/WEB-INF/jspf/head.jsp">
        <jsp:param name="title" value="Main page"/>
        </jsp:include>
        
    </head>

    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        
        <%@include file="/WEB-INF/jspf/sidebar.jspf" %>
        <h1>Hello World!</h1>
        
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>

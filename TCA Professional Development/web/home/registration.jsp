<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Register for a class"/>
        </jsp:include>
    </head>
    <body>
        <div id="main">
            <div id="header">
                <%@include file="../WEB-INF/jspf/header.jspf" %>
            </div>

            <div id="sideBar">
                <%@include file="../WEB-INF/jspf/sidebar.jspf" %>
            </div>

            <div id="pageBody">
                <div id="addCourseBox">
                    <%
                    if(request.getAttribute("errormsg") != null)
                        out.println("Error! " + request.getAttribute("errormsg"));
                    %>
                    <div id="linkLabel">Register for a Course</div>
                    <form action="<%=request.getRequestURI()%>-submit" method="post">
                        Please select a course to register for: <br />
                        Type of course: 
                        <select NAME=type>
                            <option disabled="true" <c:if test="${type == null}">
                                                     selected="true"</c:if>>Select one</option>
                            <option value="technology" <c:if test="${type != null && type == 'technology'}">
                                                     selected="true"</c:if>>Technology</option>
                            <option value="textbook"<c:if test="${type != null && type == 'textbook'}">
                                                     selected="true"</c:if>>Textbook training</option>
                            <option value="teambuilding"<c:if test="${type != null && type == 'teambuilding'}">
                                                     selected="true"</c:if>>Team Building</option>
                            <option value="leadership"<c:if test="${type != null && type == 'leadership'}">
                                                     selected="true"</c:if>>Leadership</option>
                            <option value="hr"<c:if test="${type != null && type == 'hr'}">
                                                     selected="true"</c:if>>Human Resources</option>
                        </select><BR>                        
                        Select a course: 
                        

                        <INPUT TYPE=SUBMIT>
                    </form>
                    <div id="submit">
                        <a href="#">Save Course</a>
                    </div>
                </div>

            </div>

            <div id="footer">
                <%@include file="../WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>
    </body>
</html>
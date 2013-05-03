
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

 <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Take attendance"/>
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
              </div>
           <div id="pageBody">
              <table>
                   <tr><td>Please select who was present during the course:</td></tr>
                   <form action="<c:url value='attendanceSubmit'/>" method="post">
                   <c:forEach items="${attendees}" var="a">
                       <tr>
                           <td>
                               <c:out value="${a.teacherFname}"/>
                           </td>
                           <td>
                               <c:out value="${a.teacherLname}"/>
                           </td>
                           <td>
                               <input type="checkbox" name="attendance" value=${a.teacherId}>
                               
                           </td>
                       </tr>
                   </c:forEach>
                       <tr><td>
                               <input type="hidden"
                                                       name="courseId"
                                                       value=<%= request.getParameter("courseId")%>>
                               <input type="submit"
                                                       name="submit"
                                                       value="Submit attendance">
                           </td></tr>
                   </form>
               </table>
        </div>
        <div id="footer">
                <%@include file="../WEB-INF/jspf/footer.jspf" %>
            </div>
    </body>
</html>
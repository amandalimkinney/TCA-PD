
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
                   <tr><td>Choose which course:</td></tr>
                   <c:forEach items="${courses}" var="c">
                       <tr><td><c:out value="${c.courseName}"/></td>
                           <td> <c:out value="${c.date}"/></td>
                       <td><form action="<c:url value='attendance2'/>" method="post">
                                                <input type="hidden"
                                                       name="courseId"
                                                       value="${c.courseId}">
                                                <input type="submit"
                                                       name="submit"
                                                       value="Select">
                                            </form>
                           </td></tr>
                   </c:forEach>
               </table>
        </div>
        <div id="footer">
                <%@include file="../WEB-INF/jspf/footer.jspf" %>
            </div>
    </body>
</html>
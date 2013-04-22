<%@page import="session.CourseFacade"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Course Sign Up"/>
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
                <%--<%@include file="../WEB-INF/jspf/courseTable.jspf" %>--%>
                <table class="courseTable">
                    <thead class="tableHead">
                        <tr>
                            <th colspan="100%">Courses</th>
                            <c:forEach var="c" items="${courseList}">
                            <tr id="courseTableRow">
                                <td id="courseTableRow"> 
                                    <div>
                                        <h4> <c:out value="${c.courseName}"/> </h4>
                                        <p id="courseDescription"> <c:out value="${c.description}"/> </p>
                                    </div>
                                    <div>
                                        <table id='courseDetails'>
                                            <tr>
                                                <td>Instructor:</td>
                                                <td><c:out value="${c.courseInstructor}"/></td>
                                            </tr>
                                            <tr>
                                                <td>Assistants:</td>
                                                <td>  </t> </td>
                                                <td><fmt:message key="${c.courseAssistants}"/></td>
                                            </tr>

                                            <tr>
                                                <td>Date:</td>
                                                <td>  </t> </td>
                                                <td><fmt:formatDate type="date" value="${c.date}" /></td>
                                            </tr>
                                            <tr>
                                                <td>Location:</td>
                                                <td><c:out value="${c.courseRoom}"/></td>
                                            </tr>

                                            <tr>
                                                <td>Time:</td>
                                                <td>  </t> </td>
                                                <td><fmt:formatDate type="time" value="${c.beginTime}"/> to <fmt:formatDate type="time" value="${c.endTime}"/></td>
                                            </tr>

                                            <tr>
                                                <td>Number of seats:</td>
                                                <td>  </t> </td>
                                                <td><c:out value="${c.totalSeats}"/></td>
                                            </tr>

                                            <tr>
                                                <td>Notes:</td>
                                                <td>  </t> </td>
                                                <td><c:out value="${c.courseType}"/></td>
                                            </tr>
                                            
                                            
                                         
                                        </table>
                                    </div>
                                    <form action="<c:url value='viewcourselist-signup'/>" method="post">
                                                <input type="hidden"
                                                       name="courseId"
                                                       value="${c.courseId}">
                                                <input type="submit"
                                                       name="submit"
                                                       value="Sign up">
                                            </form>

                                </td></tr>
                            </c:forEach>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>

                </table>
            </div>
        </table>

    </div>

    <div id="footer">
        <%@include file="../WEB-INF/jspf/footer.jspf" %>
    </div>
</div>
</body>
</html>

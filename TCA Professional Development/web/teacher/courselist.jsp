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
                        </tr>
                    </thead>
                    <%--<tbody>
                        <tr>
                            <td id="courseTableRow">
                                <div>
                                    <h4>cs</h4>
                                        <p id="courseDescription">This is where the description of the course will go.
                                        It will inform the teachers about what they will be learning in the class.This is where the description of the course will go.
                                        It will inform the teachers about what they will be learning in the class.This is where the description of the course will go.
                                        It will inform the teachers about what they will be learning in the class.</p>
                                </div>
                                <div>
                                    <table id="courseDetails">
                                        <tr>
                                            <td id="details">Details</td>
                                        </tr>
                                    
                                        <tr>
                                                <td>Instructor:</td>
                                                <td>John Smith</td>
                                            </tr>
                                            <tr>
                                                <td>Assistants:</td>
                                                <td>Jane Doe</td>
                                            </tr>
                                            <tr>
                                                <td>Date:</td>
                                                <td>2012-01-02</td>
                                            </tr>
                                            <tr>
                                                <td>Location (Room#):</td>
                                                <td>1</td>
                                            </tr>

                                            <tr>
                                                <td>Time:</td>
                                                <td>10:00 a.m. to 12:00 p.m.</td>
                                            </tr>

                                            <tr>
                                                <td>Number of seats:</td>
                                                <td>10</td>
                                            </tr>

                                            <tr>
                                                <td>Type:</td>
                                                <td>academic</td>
                                            </tr>
                                        </table>
                                    </div>
                                
                            <form id="submit" action="<c:url value='viewcourselist-signup'/>" method="post">
                            <input type="hidden"
                                   name="courseId"
                                   value="${c.courseId}">
                            <input type="submit"
                                   name="submit"
                                   value="Sign up">
                         </form>
                    </td>
                            
                    <td id="courseTableRow">
                        <div>
                            <h4>se</h4>
                            <p id="courseDescription">This is where the description of the course will go.
                                        It will inform the teachers about what they will be learning in the class.This is where the description of the course will go.
                                        It will inform the teachers about what they will be learning in the class.This is where the description of the course will go.
                                        It will inform the teachers about what they will be learning in the class.</p>
                        </div>
                        <div>
                            <table id="courseDetails">
                                <tr>
                                            <td id="details">Details</td>
                                        </tr>
                                <tr>
                                    <td>Instructor:</td>
                                    <td>Sue Jones</td>
                                </tr>
                                <tr>
                                    <td>Assistants:</td>
                                    <td>Bill Brown</td>
                                </tr>
                                <tr>
                                    <td>Date:</td>
                                    <td>2013-02-02</td>
                                </tr>
                                <tr>
                                    <td>Location (Room#):</td>
                                    <td>4</td>
                                </tr>
                                <tr>
                                    <td>Time:</td>
                                    <td>2:00 p.m. to 3:00 p.m.</td>
                                </tr>
                                <tr>
                                    <td>Number of seats:</td>
                                    <td>15</td>
                                </tr>
                                <tr>
                                    <td>Type:</td>
                                    <td>tech</td>
                                </tr>
                            </table>
                        </div>
                        <form id="submit" action="<c:url value='viewcourselist-signup'/>" method="post">
                            <input type="hidden"
                                   name="courseId"
                                   value="${c.courseId}">
                            <input type="submit"
                                   name="submit"
                                   value="Sign up">
                         </form>
                        </td>
                        </tr>
                    </tbody>
                </table>--%>
           
                                
                            
                            <tbody>
                            <c:forEach var="c" items="${courseList}">
                            <tr>
                                <td id="courseTableRow"> 
                                    <div>
                                        <h4> <c:out value="${c.courseName}"/> </h4>
                                        <p id="courseDescription"> <c:out value="${c.description}"/> </p>
                                    </div>
                                    <div>
                                        <table id='courseDetails'>
                                            <tr>
                                                <td id="details">Details</td>
                                            </tr>
                                            <tr>
                                                <td>Instructor:</td>
                                                <td><c:out value="${c.courseInstructor}"/></td>
                                            </tr>
                                            <tr>
                                                <td>Assistants:</td>
                                                <td><fmt:message key="${c.courseAssistants}"/></td>
                                            </tr>

                                            <tr>
                                                <td>Date:</td>
                                                <td><fmt:formatDate type="date" value="${c.date}" /></td>
                                            </tr>
                                            <tr>
                                                <td>Location:</td>
                                                <td><c:out value="${c.courseRoom}"/></td>
                                            </tr>

                                            <tr>
                                                <td>Time:</td>
                                                <td><fmt:formatDate type="time" value="${c.beginTime}"/> to <fmt:formatDate type="time" value="${c.endTime}"/></td>
                                            </tr>

                                            <tr>
                                                <td>Number of seats:</td>
                                                <td><c:out value="${c.totalSeats}"/></td>
                                            </tr>

                                            <tr>
                                                <td>Notes:</td>
                                                <td><c:out value="${c.courseType}"/></td>
                                            </tr>
                                            
                                            
                                         
                                        </table>
                                    </div>
                                    <form id="submit" action="<c:url value='viewcourselist-signup'/>" method="post">
                                                <input type="hidden"
                                                       name="courseId"
                                                       value="${c.courseId}">
                                                <input type="submit"
                                                       name="submit"
                                                       value="Sign up">
                                            </form>

                                </td>
                            </tr>
                            </c:forEach>
                    </tbody>
                </table>
    </div>
    <div id="footer">
        <%@include file="../WEB-INF/jspf/footer.jspf" %>
    </div>
</div>
</body>
</html>

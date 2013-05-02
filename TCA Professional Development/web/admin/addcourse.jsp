<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Create TCA Course"/>
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
             <div id="addTCACourseBox">
                    <%
                    if(request.getAttribute("errormsg") != null)
                        out.println("Error! " + request.getAttribute("errormsg"));
                    %>
                    <div id="linkLabel">Add New TCA Course</div>
                         <form action="<%=request.getRequestURI()%>-submit" method="post">

                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Course Name:
                                </td>
                                <td id="input2">
                                    <INPUT type=text NAME=courseName size=30
                                           <c:if test="${courseName != null}">
                                               value=<%=request.getAttribute("courseName")%>
                                           </c:if>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Topic Type:
                                </td>
                                <td id="input2">
                                    <input NAME=type TYPE=radio VALUE="academic" 
                                          <c:if test="${type != null && type == 'academic'}">
                                                     checked="true"</c:if>/> Academic
                                    <input NAME=type TYPE=radio VALUE="technology"  <c:if test="${type != null && type == 'technology'}">
                                                     checked="true"</c:if>/> Technology
                                    <input NAME=type TYPE=radio VALUE="spiritual"  <c:if test="${type != null && type == 'spiritual'}">
                                                    checked="true"</c:if>/> Spiritual
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Topic:
                                </td>
                                <td id="input2">
                                    <INPUT TYPE=TEXT NAME=topicName SIZE=30
                                           <c:if test="${topicName != null}">
                                                value=<%=request.getAttribute("topicName")%>
                                           </c:if>>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable"> 
                            <tr>
                                <td id="category">
                                    Date (mm/dd/yyyy):
                                </td>
                                <td id="input2">
                                    <INPUT TYPE=text NAME=date size="10" 
                                                 <c:if test="${date != null}">
                                                     value=<%=request.getAttribute("date")%>
                                                 </c:if>> 
                                    
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Start Time:
                                </td>
                                <td id="input2">
                                    <INPUT Type=text NAME=beginTime SIZE=5
                                           <c:if test="${beginTime != null}">
                                               value=<%=request.getAttribute("beginTime")%>
                                           </c:if>>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    End Time:
                                </td>
                                <td id="input2">
                                    <INPUT Type=text NAME=endTime SIZE=5
                                           <c:if test="${endTime != null}">
                                               value=<%=request.getAttribute("endTime")%>
                                           </c:if>>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Number of Hours:
                                </td>
                                <td id="input2">
                                    <INPUT Type=text NAME=hours SIZE=5
                                           <c:if test="${numHours != null}">
                                               value=<%=request.getAttribute("hours")%>
                                           </c:if>>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Room:
                                </td>
                                <td id="input2">
                                    <INPUT Type=text NAME=courseRoom SIZE=5
                                           <c:if test="${courseRoom != null}">
                                               value=<%=request.getAttribute("courseRoom")%>
                                           </c:if>>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Available Seats:
                                </td>
                                <td id="input2">
                                    <INPUT type=text NAME=totalSeats SIZE=5
                                            <c:if test="${totalSeats != null}">
                                               value=<%=request.getAttribute("totalSeats")%> 
                                            </c:if>>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Course Instructor:
                                </td>
                                <td id="input2">
                                    <INPUT type=text NAME=courseInstructor SIZE=30
                                            <c:if test="${courseInstructor != null}">
                                               value=<%=request.getAttribute("courseInstructor")%> 
                                            </c:if>>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Course Assistant:
                                </td>
                                <td id="input2">
                                    <INPUT type=text NAME=courseAssistant SIZE=30
                                            <c:if test="${courseAssistant != null}">
                                               value=<%=request.getAttribute("courseAssistant")%> 
                                            </c:if>>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Equipment:
                                </td>
                                <td id="input2">
                                    <INPUT type=text NAME=equipment SIZE=30
                                            <c:if test="${equipment != null}">
                                               value=<%=request.getAttribute("equipment")%> 
                                            </c:if>>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Description:
                                </td>
                                <td id="input2">
                                    <textarea name=description rows=5 cols=30>
                                    </textarea>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <BR>
                    <BR>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr> 
                                <td id="submit">
                                    <INPUT TYPE=SUBMIT>
                                </td>
                            </tr>
                        </table>
                    </div>
                         </form>
                </div>
        </div>
        <div id="footer">
                <%@include file="../WEB-INF/jspf/footer.jspf" %>
            </div>
    </body>
</html>
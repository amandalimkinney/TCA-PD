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
             <div id="addCourseBox">
                    <%
                    if(request.getAttribute("errormsg") != null)
                        out.println("Error! " + request.getAttribute("errormsg"));
                    %>
                    <div id="linkLabel">Add New TCA Course</div>
                    <form action="<%=request.getRequestURI()%>-submit" method="post">
                        Date (mm/dd/yyyy) <INPUT TYPE=text NAME=date size="10" 
                                                 <c:if test="${date != null}">
                                                     value=<%=request.getAttribute("date")%>
                                                 </c:if>>
                        <BR>
                        Number of Hours <INPUT TYPE=text NAME=numHours SIZE=5
                                               <c:if test="${numHours != null}">
                                                     value=<%=request.getAttribute("numHours")%>
                                                 </c:if>><BR>
                        Method <select NAME=method>
                            <option disabled="true" <c:if test="${method == null}">
                                                     selected="true"</c:if>>Select one</option>
                            <option value="conference" <c:if test="${method != null && method == 'conference'}">
                                                     selected="true"</c:if>>Conference</option>
                            <option value="tcaCourse"<c:if test="${method != null && method == 'tcaCourse'}">
                                                     selected="true"</c:if>>TCA Course</option>
                            <option value="course"<c:if test="${method != null && method == 'course'}">
                                                     selected="true"</c:if>>Course</option>
                            <option value="presenting"<c:if test="${method != null && method == 'presenting'}">
                                                     selected="true"</c:if>>Presenting a Course or Conference</option>
                            <option value="workshop"<c:if test="${method != null && method == 'workshop'}">
                                                     selected="true"</c:if>>Workshop</option>
                            <option value="book"<c:if test="${method != null && method == 'book'}">
                                                     selected="true"</c:if>>Book</option>
                            <option value="newCurriculum"<c:if test="${method != null && method == 'newCurriculum'}">
                                                     selected="true"</c:if>>Developing new curriculum</option>
                            <option value="travel"<c:if test="${method != null && method == 'travel'}">
                                                     selected="true"</c:if>>Travel</option>
                            <option value="other"<c:if test="${method != null && method == 'other'}">
                                                     selected="true"</c:if>>Other</option>
                        </select><BR>
                        Hosting Organization <select name="hostOrg">
                            <option disabled="true" selected="true">Select one</option>
                            <option value="1"<c:if test="${hostOrg != null && hostOrg == '1'}">
                                                     selected="true"</c:if>>popular 1</option>
                            <option value="2"<c:if test="${hostOrg != null && hostOrg == '2'}">
                                                     selected="true"</c:if>>popular 2</option>
                            <option value="other"<c:if test="${hostOrg != null && hostOrg == 'other'}">
                                                     selected="true"</c:if>>Other</option>
                        </select><BR>
                        Location <input NAME=location TYPE=radio VALUE="on-site" 
                                        <c:if test="${location != null && location == 'on-site'}">
                                                     checked="true"</c:if>/> On-site
                        <input NAME=location TYPE=radio VALUE="off-site" 
                               <c:if test="${location != null && location == 'off-site'}">
                                                     checked="true"</c:if>/> Off-site<BR>
                        Topic Type <input NAME=type TYPE=radio VALUE="academic" 
                                          <c:if test="${type != null && type == 'academic'}">
                                                     checked="true"</c:if>/> Academic
                        <input NAME=type TYPE=radio VALUE="technology"  <c:if test="${type != null && type == 'technology'}">
                                                     checked="true"</c:if>/> Technology
                        <input NAME=type TYPE=radio VALUE="spiritual"  <c:if test="${type != null && type == 'spiritual'}">
                                                    checked="true"</c:if>/> Spiritual<BR>
                        Topic <INPUT TYPE=TEXT NAME=topicName SIZE=30<c:if test="${topicName != null}">
                                                     value=<%=request.getAttribute("topicName")%>
                                                 </c:if>><BR>
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
    </body>
</html>
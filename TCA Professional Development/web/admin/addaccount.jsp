<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Create Account"/>
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
            <div id="accountBox">
                <%
                    if(request.getAttribute("errormsg") != null)
                        out.println("Error! " + request.getAttribute("errormsg"));
                    %>
                <div id="linkLabel">Add New Account</div>
                <form action="<%=request.getRequestURI()%>-submit" method="post">
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    First Name:
                                </td>
                                <td id="input2">
                                    <INPUT type=text NAME=teacherFname size=30
                                           <c:if test="${courseName != null}">
                                               value=<%=request.getAttribute("teacherFname")%>
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
                                    Last Name:
                                </td>
                                <td id="input2">
                                    <INPUT type=text NAME=teacherLname size=30
                                           <c:if test="${courseName != null}">
                                               value=<%=request.getAttribute("teacherLname")%>
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
                                    Username:
                                </td>
                                <td id="input2">
                                    <INPUT type=text NAME=username size=30
                                           <c:if test="${courseName != null}">
                                               value=<%=request.getAttribute("username")%>
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
                                    Password:
                                </td>
                                <td id="input2">
                                    <INPUT type=password NAME=password size=30
                                           <c:if test="${courseName != null}">
                                               value=<%=request.getAttribute("password")%>
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
                                    Division:
                                </td>
                                <td id="input2">
                                    <INPUT NAME=division type=radio VALUE="Lower School"
                                           <c:if test="${division != null && division == 'Lower School'}">
                                               checked="true"</c:if>/> Lower School
                                    <INPUT NAME=division type=radio VALUE="Upper School"
                                           <c:if test="${division != null && division == 'Upper School'}">
                                               checked="true"</c:if>/> Upper School
                                </td>
                            </tr>
                        </table>
                    </div>
                    <BR>
                    <div id="input">
                        <table id="Itable">
                            <tr>
                                <td id="category">
                                    Subject:
                                </td>
                                <td id="input2">
                                    <INPUT NAME=subject type=text size=30
                                           <c:if test="${subject != null}">
                                               value=<%=request.getAttribute("subject")%>
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
                                    Hire Date (mm/dd/yyyy):
                                </td>
                                <td id="input2">
                                    <INPUT NAME=hireDate type=text size=10
                                           <c:if test="${hireDate != null}">
                                               value=<%=request.getAttribute("hireDate")%>
                                           </c:if>>
                                </td>
                            </tr>
                        </table>
                    </div>
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
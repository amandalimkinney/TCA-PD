<%-- 
    Document   : newjsp
    Created on : May 2, 2013, 7:41:03 PM
    Author     : Jeff
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Main page"/>
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
                <div id="upcomingCourses">
                    <div id="linkLabel">Upcoming Courses</div>
                    
                    <ul>  
                        <li>
                            3/22 - ALL in learning User Group
                        </li>
                    
                        <li>
                            3/22 - InDesign
                        </li>
                    </ul>
                </div>
                
                <div id="announcements">
                    <div id="linkLabel">Announcements</div>
                    <ul>
                        <li>
                            3/19 - Reminder this Friday (3/22) is Tech Friday.
                        </li>
                        <li>
                            3/12 - Reminder to sign up for the upcoming Tech
                            Friday.
                        </li>
                        <li>
                            2/29 - New courses have been posted for next months 
                            Tech Friday.
                        </li>
                    </ul>
                </div>
            </div>

            <div id="footer">
                <%@include file="../WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

    </body>
</html>

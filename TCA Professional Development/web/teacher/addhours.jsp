<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Add hours"/>
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
                    <div id="linkLabel">Add New Course</div>
                    <form action="/TCA_Professional_Development/addhours" method="post">
                        Date <INPUT TYPE=Date NAME=date><BR>
                        Number of Hours <INPUT TYPE=text NAME=numHours SIZE=5><BR>
                        Method <select NAME=method>
                            <option disabled="true" selected="true">Select one</option>
                            <option value="conference">Conference</option>
                            <option value="tcaCourse">TCA Course</option>
                            <option value="course">Course</option>
                            <option value="presenting">Presenting a Course or Conference</option>
                            <option value="workshop">Workshop</option>
                            <option value="book">Book</option>
                            <option value="newCurriculum">Developing new curriculum</option>
                            <option value="travel">Travel</option>
                            <option value="other">Other</option>
                        </select><BR>
                        Hosting Organization <select>
                            <option disabled="true" selected="true">Select one</option>
                            <option value="1">popular 1</option>
                            <option value="2">popular 2</option>
                            <option value="other">Other</option>
                        </select><BR>
                        Location <input NAME=location TYPE=radio VALUE="on-site" /> On-site
                        <input NAME=location TYPE=radio VALUE="off-site" /> Off-site<BR>
                        Topic Type <input NAME=type TYPE=radio VALUE="academic" /> Academic
                        <input NAME=type TYPE=radio VALUE="technology" /> Technology
                        <input NAME=type TYPE=radio VALUE="spiritual" /> Spiritual<BR>
                        Topic <INPUT TYPE=TEXT NAME=topicName SIZE=30><BR>
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
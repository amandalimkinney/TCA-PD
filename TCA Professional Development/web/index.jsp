<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
              <title>TCA Professional Development Home</title>
        <link rel="stylesheet" type="text/css" href="css/TCAProfDev.css" />
    </head>

    <body>
        <div id="main">
            <div id="header">
                <%@include file="/WEB-INF/jspf/header.jspf" %>
            </div>

            <div id="sideBar">
                <!--                These links will not work, TODO replace this-->
                <%--<%@include file="/WEB-INF/jspf/sidebar.jspf" %>--%>
                <div id="sideMenu">

                    <div  id="linkLabel"> 
                        Quick Links
                    </div>

                    <div id="standardLinks">

                        <a href="home/index.jsp" class="links">Home</a>
                        <!--    
                                <br>
                            
                                <a href="../teacher/viewcourselist" class="links">Courses</a>
                            
                                <br>
                               
                                <a href="../teacher/addhours.jsp" class="links">Add Hours</a>-->

                    </div>

                    <div id="linkLabel">
                        Views
                    </div>

                    <!--    <div id="roleLinks">
                            <a href="#" class="links"> Instructor</a>
                            
                            <br>
                            
                            <a href="#" class="links"> System Administrator</a>
                        </div>-->




                </div>
            </div>

            <div id="pageBody">
                <!--This is going to be the home page which will lead to either the log in page or the logged-in home screen-->
                <a href="home/index.jsp"> home </a> <br>
                <a href="home/login.jsp"> log in </a>
            </div>

            <div id="footer">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

    </body>
</html>
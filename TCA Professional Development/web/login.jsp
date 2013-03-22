<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="/WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Log In"/>
        </jsp:include>
    </head>
    <body>
        <div id="header">
                <%@include file="/WEB-INF/jspf/header.jspf" %>
        </div>

        <div id="sideBar">
            <%@include file="/WEB-INF/jspf/sidebar.jspf" %>
        </div>
        <div id="pageBody">
            <form name="frmLogin" onSubmit="return validate();" action="doLogin.jsp" method="post">
User Name <input type="text" name="sUserName" /><br />
Password <input type="password" name="sPwd" /><br />
<input type="submit" name="sSubmit" value="Submit" />
</form>
        </div>
        <div id="footer">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String username=request.getParameter("sUserName");
        String password=request.getParameter("sPwd");
        
        if((username.equals("anurag") && password.equals("jain")))
            {
            session.setAttribute("sUserName",username);
            response.sendRedirect("index.jsp");
            }
        else
            response.sendRedirect("Error.jsp");
        %>
    </body>
</html>
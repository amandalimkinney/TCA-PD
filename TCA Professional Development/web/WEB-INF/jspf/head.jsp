<%-- 
    contains everything in <head></head> that all pages need
    requires parameter "title"
    not a jspf because the java wouldn't work (?)
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>TCA Professional Development <%= request.getParameter("title") %></title>
<link rel="stylesheet" type="text/css" href="css/TCAProfDev.css" />
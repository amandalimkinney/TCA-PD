<%-- 
    Document   : doLogout
    Created on : Apr 7, 2013, 12:52:22 PM
    Author     : Erik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
 
     String username=(String)session.getAttribute("sUserName");
    if(username!=null)
        {
           out.println(username +" logged out. <a href=\"index.jsp\">Back</a>");
            session.removeAttribute("sUserName");
             
        }
     else 
         {
         out.println("You are not logged in. <a href=\"index.jsp\">Back</a>");
     }
 
 
 
%> 
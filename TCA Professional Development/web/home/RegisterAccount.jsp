<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
              <title>TCA Professional Development Home</title>
        <link rel="stylesheet" type="text/css" href="../css/TCAProfDev.css" />
    </head>

    <body>
        <div id="main">
            <div id="header">
                <%@include file="/WEB-INF/jspf/indexheader.jspf" %>
            </div>

            <div id="page1div">
                    
                    <h1>Register Account</h1>
                    <%
                    String errorMessage = request.getParameter("ERROR");
                    if( errorMessage != null)
                    {
                        out.print("<p>" + errorMessage + "</p>");
                    }
                    %>
                    <form action="<%=request.getRequestURI()%>--submit" method="POST">
                        <table>
                            <tr>
                                <td>
                                    First Name
                                </td>
                                 <td>
                                    <INPUT TYPE=text NAME=firstName size="15" <%if(request.getParameter("firstName") != null)out.print( "value=\"" + request.getAttribute("firstName") +"\"");%>>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Last Name
                                </td>
                                 <td>
                                    <INPUT TYPE=text NAME=lastName size="15" <%if(request.getParameter("lastName") != null)out.print( "value=\"" + request.getAttribute("lastName") +"\"");%>>  
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    E-Mail
                                </td>
                                 <td>
                                    <INPUT TYPE=text NAME=email size="15" <%if(request.getParameter("email") != null)out.print( "value=\"" + request.getAttribute("email") +"\"");%>>  
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Password
                                </td>
                                 <td>
                                    <INPUT TYPE=password NAME=password1 size="15" > 
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Re-enter Password
                                </td>
                                 <td>
                                    <INPUT TYPE=password NAME=password2 size="15" >
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <INPUT TYPE=SUBMIT>
                                    <INPUT TYPE=RESET>
                                </td>
                                
                            </tr>
                        </table>
                    
                    
                    </form>
                    
                    <p>&nbsp;</p>
                    

                
            </div>
            <div id="footer">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

    </body>
</html>
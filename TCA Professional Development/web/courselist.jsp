<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="/WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Course list"/>
        </jsp:include>
    </head>
    <body>
        <div id="main">
            <div id="header">
                <%@include file="/WEB-INF/jspf/header.jspf" %>
            </div>

            <div id="sideBar">
                <%@include file="/WEB-INF/jspf/sidebar.jspf" %>
            </div>

            <div id="pageBody">
                <table class="courseTable">
                    <thead>
                        <tr id="courseTableRow">
                          <th>Courses</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr id="courseTableRow">
                        <td>Course 1</td>
                        <td>Course 2</td>
                        <td>Course 3</td>
                        </tr>
                    </tbody>
            </div>
                    
                    
                    
                    
                    <!-- course name, type, room, time, number of hours, number of 
                    available seats, number of people on the waitlist, instructor, assistants, 
                    materials needed, and miscellaneous for extra information. The type of course 
                    can be technology, textbook training, team building, leadership, or HR. -->
                    <!--<tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                        <td>
                            <img src="${initParam.productImagePath}${product.name}.png"
                                 alt="<fmt:message key="${product.name}"/>">
                        </td>

                        <td><fmt:message key="${product.name}"/></td>

                    <td>
                    <fmt:formatNumber type="currency" currencySymbol="&euro; " value="${cartItem.total}"/>
                    <br>
                    <span class="smallText">(
                        <fmt:formatNumber type="currency" currencySymbol="&euro; " value="${product.price}"/>
                        / <fmt:message key="unit"/> )</span>
                    </td>

                    <td>
                        <form action="<c:url value='updateCart'/>" method="post">
                            <input type="hidden"
                                   name="productId"
                                   value="${product.id}">
                            <input type="text"
                                   maxlength="2"
                                   size="2"
                                   value="${cartItem.quantity}"
                                   name="quantity"
                                   style="margin:5px">
                            <input type="submit"
                                   name="submit"
                                   value="<fmt:message key='update'/>">
                        </form>
                    </td>
                    </tr>-->
                </table>

            </div>

            <div id="footer">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>
    </body>
</html>

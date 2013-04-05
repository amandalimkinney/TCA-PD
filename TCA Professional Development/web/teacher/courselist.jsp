<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include flush="true" page="../WEB-INF/jspf/head.jsp">
            <jsp:param name="title" value="Course list"/>
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
                <%--<%@include file="../WEB-INF/jspf/courseTable.jspf" %>--%>

                <table class="courseTable">
                    <thead class="tableHead">
                        <tr>
                            <th colspan="100%">Courses</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr id="courseTableRow">
                            <td id="courseTableRow"> 
                                <div>
                                    <h4> ALL in learning User Group </h4>
                                    <p id="courseDescription"> Come take a look at how teachers are using the ALL in
                                        the classroom. Join us for some quick tips and important 
                                        how to's. Be ready to share what has worked well and what
                                        to avoid. </p>
                                </div>

                                <div>
                                    <table id='courseDetails'>
                                        <tr>
                                            <td>Instructor:</td>
                                            <td>  </t> </td>
                                            <td>Jane Doe</td>
                                        </tr>

                                        <tr>
                                            <td>Assistants:</td>
                                            <td>  </t> </td>
                                            <td>John Smith</td>
                                        </tr>

                                        <tr>
                                            <td>Date:</td>
                                            <td>  </t> </td>
                                            <td>3/22/13</td>
                                        </tr>

                                        <tr>
                                            <td>Location:</td>
                                            <td>  </t> </td>
                                            <td>MS Room 15</td>
                                        </tr>

                                        <tr>
                                            <td>Time:</td>
                                            <td>  </t> </td>
                                            <td>10:00 a.m.</td>
                                        </tr>

                                        <tr>
                                            <td>Notes:</td>
                                        </tr>

                                    </table>
                                </div>

                                <div id="signUp">
                                    <a href="#" > Sign up </a>
                                </div>
                            </td>
                        </tr>
                    </tbody>

                </table>

                <c:forEach var="category" items="${categories}">
                </c:foreach>

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
        <%@include file="../WEB-INF/jspf/footer.jspf" %>
    </div>
</div>
</body>
</html>

<%-- 
    Document   : friendrequests
    Created on : Mar 7, 2016, 9:40:55 PM
    Author     : nk5946
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" type="text/css" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friend Requests</title>
    </head>
    <body>
        <div>
        <c:forEach var="user" items ="${users}">
            <tr>
                <td>${user.username}
                <td>${user.email}
                <td>${user.id}
                <td>
                    <a href="AcceptServlet?action=Accept&requestorid=${user.id}">Accept</a>
        </c:forEach>
        </div>
    </body>
</html>

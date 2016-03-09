<%-- 
    Document   : friends
    Created on : Mar 3, 2016, 6:54:26 PM
    Author     : nk5946
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" type="text/css" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friends</title>
    </head>
    <body>
        <div>
            <h2>Friends</h2>
        <table class="table">
            <tr>
                <th>first name</th>
                <th>last name</th>
                <th>email</th>
            </tr>
        <c:forEach var="user" items ="${users}">
            <tr>
            <td>${user.firstname} 
            <td>${user.lastname}
            <td>${user.email}
                <td>
                    <a href="VisitorServlet?action=visitor&id=${user.id}">Profile</a>
                </td>
            </tr>      
        </c:forEach>
        </table>
        </div>
        
        <div>
            <h2>Friend Requests</h2>
        <table class="table">
            <tr>
                <th>first name</th>
                <th>last name</th>
                <th>email</th>
            </tr>
        <c:forEach var="user" items ="${requests}">
            <tr>
            <td>${user.firstname} 
            <td>${user.lastname}
            <td>${user.email}
                <td>
                    <a href="AcceptServlet?action=Accept&requestorid=${user.id}">Accept</a>
                </td>
            </tr>      
        </c:forEach>
        </table>
        </div>
    </body>
</html>

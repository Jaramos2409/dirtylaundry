<%-- 
    Document   : searchresult
    Created on : Feb 26, 2016, 2:10:44 AM
    Author     : EVA Unit 02
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" type="text/css" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <h1>Results:</h1>
        <c:if test="${empty results}"> blank </c:if>
        <c:if test="${not empty results}">
            <c:forEach items="${results}" var="usr">
            <div>
                <a href="VisitorServlet?action=vistor&id=${usr.id}">${usr.firstname} ${usr.lastname}</a> <br>
                ${usr.gender} <br>
                ${usr.city}, ${usr.state}<br>
                ${usr.relationship}<br><br>
            </div>
            </c:forEach>
        </c:if> 
        <br><a href="SearchServlet?&action=load">Back to Search Page</a>
    </body>
</html>

<%-- 
    Document   : newreview
    Created on : Mar 6, 2016, 4:54:27 PM
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
        <title>Edit Review: </title>
    </head>
    <body>
        <form action="EditReviewServlet?&action=edit&review=${review}" method="post" style="width: 412px">
            <label id="review">Edit Review:</label><br>
            <textarea name="reviewtext" style="width: 410px; height: 134px" maxlength="500">${review.reviewtext}</textarea>
            <div align="right">500 character limit</div>
            <input name="Submit" type="submit" value="Edit Review" align="right"/>
            <input type="hidden" name="review" value="review" />
        </form>
    </body>
</html>

<%-- 
    Document   : newreview
    Created on : Mar 6, 2016, 4:54:27 PM
    Author     : EVA Unit 02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" type="text/css" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Review: </title>
    </head>
    <body>
        <form action="PostReviewServlet?&action=addreview&visiteeid=${visiteeid}" method="post" style="width: 412px">
            <label id="review">Review:</label><br>
            <textarea name="reviewtext" style="width: 410px; height: 134px" maxlength="500"></textarea>
            <div align="right">500 character limit</div>
            <input name="Submit" type="submit" value="Add New Review" align="right"/>
        </form>
    </body>
</html>

<%-- 
    Document   : sorryvisitor
    Created on : Mar 5, 2016, 1:07:33 AM
    Author     : EVA Unit 02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" type="text/css" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry</title>
    </head>
    <body>
        <h1>There was an error loading the visitee's page.</h1>
        <br><a href="SearchServlet?&action=load">Back to Search Page</a>
    </body>
</html>

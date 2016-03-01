<%-- 
    Document   : welcome
    Created on : Feb 23, 2016, 7:24:24 PM
    Author     : nk5946
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <div><h1>Welcome ${sessionScope.user.email} to Dirty Laundry</h1>
        </div>
        <a href="EditServlet?&email=${sessionScope.user.email}&password=${sessionScope.user.password}">Edit Personal Information</a>
    </body>
</html>

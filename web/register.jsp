<%-- 
    Document   : register
    Created on : Feb 23, 2016, 7:37:54 PM
    Author     : nk5946
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form action="RegisterServlet?action=register" method="post">
            <div class="form-group">
                <label>first</label>
                <input type="text" name="firstname">
            </div>
            <div class="form-group">
                <label>last</label>
                <input type="text" name="lastname">
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password">
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email">
            </div>
            <div class="form-group">
            <input type="submit" value="Register"/>
            </div>
        </form>
    </body>
</html>

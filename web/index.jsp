<%-- 
    Document   : login
    Created on : Feb 25, 2016, 7:24:08 PM
    Author     : nk5946
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header2.jsp"/>
        <link rel="stylesheet" type="text/css" href="style/style.css">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="Login" method="post">
            <div class="form-group">
                <label>Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </label>
                <input type="email" name="email">
            </div>
            <div class="form-group">
                <label>Password:</label>
                <input type="password" name="password">
            </div>
            <div class="form-group">&nbsp;</div>
            <div class="form-group">
            <input type="submit" value="Login"/>
            </div>
        </form>
        
        <p>Not a member yet?</p>
        <a href="register.jsp">Register!</a>
    </body>
</html>
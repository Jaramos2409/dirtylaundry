<%-- 
    Document   : searchresult
    Created on : Feb 26, 2016, 2:10:44 AM
    Author     : EVA Unit 02
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="webappbeans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <h1>Results:</h1>
        <%
            List<User> results = new ArrayList<>();
            if (request.getAttribute("results") != null) {
                results = (List<User>) request.getAttribute("results");
                
                for (User user : results) {
                   out.println(user.getFirstname() + " " + user.getLastname() + " " );%><br>
        <%
                }
            }
            %>
            <br><a href="search.jsp">Back to Search Page</a>
    </body>
</html>

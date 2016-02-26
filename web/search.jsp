<%-- 
    Document   : search
    Created on : Feb 25, 2016, 8:14:52 PM
    Author     : EVA Unit 02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form action="SearchServlet?action=search" method="post">
            <label for="searchtype">Search Type: </label>
            <select name="searchtype" title="Search Type:">
                <option selected="selected">Full Name</option>
                <option>Location</option>
            </select> 
            
            <br>
            
            <label for="keywords">Keywords: </label>
            <input name="keywords" style="width: 186px" type="text" />
    <input name="submit" type="submit" value="search" />
    </form>

    </body>
</html>

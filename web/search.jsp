<%-- 
    Document   : search
    Created on : Feb 25, 2016, 8:14:52 PM
    Author     : EVA Unit 02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" type="text/css" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>    
    <form action="SearchServlet?action=search" method="post">
	<input name="keyword" style="width: 352px" type="text" /><select name="searchtype" style="width: 113px">
	<option>Name</option>
	<option>Email</option>
	<option>City, State</option>
	<option>Relationship</option>
	<option>Phone Number</option>
	</select>
        <input name="submit" type="submit" value="search" />
    </form>
    
    </body>
</html>

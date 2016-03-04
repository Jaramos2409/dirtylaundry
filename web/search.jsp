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
        <title>Search</title>
    </head>
    <body>
    <form action="SearchServlet?action=search" method="post">
            <label for="firstname">First Name: </label>
            <input name="firstname" style="width: 186px" type="text" /><br>
            <label for="lastname">Last Name: </label>
            <input name="lastname" style="width: 186px" type="text" /><br>
            <label for="gender">Gender: </label>
            <input name="gender" style="width: 186px" type="text" /><br>
            <label for="email">Email: </label>
            <input name="email" style="width: 186px" type="text" /><br>
            <label for="city">City: </label>
            <input name="city" style="width: 186px" type="text" /><br>
            <label for="state">State: </label>
            <input name="state" style="width: 186px" type="text" /><br>
			<label for="birthday">Birthday: </label>
            <input name="birthday" style="width: 186px" type="text" /><br>
            <label for="ethnicity">Ethnicity: </label>
            <input name="ethnicity" style="width: 186px" type="text" /><br>
            <label for="education">Education: </label>
            <input name="education" style="width: 186px" type="text" /><br>
            <label for="occupation">Occupation: </label>
            <input name="occupation" style="width: 186px" type="text" /><br>
            <label for="relationship">Relationship: </label>
            <input name="relationship" style="width: 186px" type="text" /><br>
            <label for="phone">Phone: </label>
            <input name="phone" style="width: 186px" type="text" /><br>
            <br>
    <input name="submit" type="submit" value="search" />
    </form>
    </body>
</html>

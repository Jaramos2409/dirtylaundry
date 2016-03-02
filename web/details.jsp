<%-- 
    Document   : details
    Created on : Feb 29, 2016, 9:34:13 PM
    Author     : nk5946
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Information</title>
    </head>
    <body>
        <h1>Please Enter Your Details</h1>
        <form action="Save" method="post">
        <div id="personal">
            <table>
                <tr>
                    <td><label for="firstname"><b>First Name<font color="red">*</font></b></label></td>
                    <td><input id="firstname" maxlength="30" name="firstname" size="30" type="text" value="${user.firstname}"/> </td>
                </tr>  
                <tr>
                    <td><label for="lastname"><b>Last Name<font color="red">*</font></b></label></td>
                    <td><input id="lastname" maxlength="30" name="lastname" size="30" type="text" value="${user.lastname}"/> </td>
                </tr>
                <tr>
                    <td><label for="email"><b>Email<font color="red">*</font></b></label></td>
                    <td><input id="email" maxlength="30" name="email" size="30" type="text" value="${user.email}"/> </td>
                </tr>  
                <tr>
                    <td><label for="password"><b>Password<font color="red">*</font></b></label></td>
                    <td><input id="password" maxlength="30" name="password" size="30" type="text" value="${user.password}"/> </td>
                </tr> 
                <tr>
                    <td><input type="hidden" id="id" name="id" value="${user.id}"/></td>
                    <td><input type="submit" value="Save"/></td>
                    <td><input type="submit" value="Back"/></td>
                </tr>
            </table>
        </div>
        </form>
    </body>
</html>

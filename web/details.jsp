<%-- 
    Document   : details
    Created on : Feb 29, 2016, 9:34:13 PM
    Author     : nk5946
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" type="text/css" href="style/style.css">
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
                    <td><label for="city"><b>City<font color="red">*</font></b></label></td>
                    <td><input id="city" maxlength="30" name="city" size="30" type="text" value="${user.city}"/> </td>
                </tr> 
                <tr>
                    <td><label for="birthday"><b>Birthday<font color="red">*</font></b></label></td>
                    <td><input id="birthday" maxlength="30" name="birthday" size="30" type="text" value="${user.birthday}"/> </td>
                </tr>
                <tr>
                    <td><label for="ethnicity"><b>Ethnicity<font color="red">*</font></b></label></td>
                    <td><input id="ethnicity" maxlength="30" name="ethnicity" size="30" type="text" value="${user.ethnicity}"/> </td>
                </tr>
                <tr>
                    <td><label for="education"><b>Education<font color="red">*</font></b></label></td>
                    <td><input id="education" maxlength="30" name="education" size="30" type="text" value="${user.education}"/> </td>
                </tr>
                <tr>
                    <td><label for="occupation"><b>Occupation<font color="red">*</font></b></label></td>
                    <td><input id="occupation" maxlength="30" name="occupation" size="30" type="text" value="${user.occupation}"/> </td>
                </tr>
                <tr>
                    <td><label for="relationship"><b>Relationship<font color="red">*</font></b></label></td>
                    <td><input id="relationship" maxlength="30" name="relationship" size="30" type="text" value="${user.relationship}"/> </td>
                </tr>
                <tr>
                    <td><label for="phone"><b>Phone<font color="red">*</font></b></label></td>
                    <td><input id="phone" maxlength="30" name="phone" size="30" type="text" value="${user.phone}"/> </td>
                </tr>
                <tr>
                    <td><label for="state"><b>State<font color="red">*</font></b></label></td>
                    <td><input id="state" maxlength="30" name="state" size="30" type="text" value="${user.state}"/> </td>
                </tr>
                <tr>
                    <td><label for="gender"><b>Gender<font color="red">*</font></b></label></td>
                    <td><input id="gender" maxlength="30" name="gender" size="30" type="text" value="${user.gender}"/> </td>
                </tr>
                <tr>
                    <td><label for="password"><b>Password<font color="red">*</font></b></label></td>
                    <td><input id="password" maxlength="30" name="password" size="30" type="text" value="${user.password}"/> </td>
                </tr>
                <tr>
                    <td><input type="hidden" id="id" name="id" value="${user.id}"/> </td>
                </tr>
                <tr>
                    <td><h2>About Me</h2></td>
                    <td><input id="about" name="about" type ="text" value="${user.about}"  maxlength="1000" size="100"/></td>
                    <td><input type="submit" name="action" value="Save"></td>
            </table>
        </div>
        </form>
    </body>
</html>

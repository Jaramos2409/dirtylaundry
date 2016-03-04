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
        
        <div><h2>Personal Information</h2>
            <table>
                
                <tr>
                    <td><label for="firstname"><b>First Name</b></label></td>
                    <td>${sessionScope.user.firstname}</td>
                </tr>  
                <tr>
                    <td><label for="lastname"><b>Last Name</b></label></td>
                    <td>${sessionScope.user.lastname} </td>
                </tr>
                <tr>
                    <td><label for="email"><b>Email</b></label></td>
                    <td>${sessionScope.user.email}</td>
                </tr>  
                <tr>
                    <td><label for="city"><b>City</b></label></td>
                    <td>${sessionScope.user.city}</td>
                </tr>
                <tr>
                    <td><label for="birthday"><b>Birthday</b></label></td>
                    <td>${sessionScope.user.birthday}</td>
                </tr>
                <tr>
                    <td><label for="ethnicity"><b>Ethnicity</b></label></td>
                    <td>${sessionScope.user.ethnicity}</td>
                </tr>
                <tr>
                    <td><label for="education"><b>Education</b></label></td>
                    <td>${sessionScope.user.education}</td>
                </tr>
                <tr>
                    <td><label for="occupation"><b>Occupation</b></label></td>
                    <td>${sessionScope.user.occupation}</td>
                </tr>
                <tr>
                    <td><label for="relationship"><b>Relationship Status</b></label></td>
                    <td>${sessionScope.user.relationship}</td>
                </tr>
                <tr>
                    <td><label for="phone"><b>Phone Number</b></label></td>
                    <td>${sessionScope.user.phone}</td>
                </tr>
                <tr>
                    <td><label for="state"><b>State</b></label></td>
                    <td>${sessionScope.user.state}</td>
                </tr>
                <tr>
                    <td><label for="gender"><b>Gender</b></label></td>
                    <td>${sessionScope.user.gender}</td>
                </tr>
                <tr>
                    <td><label for="about"><b>About</b></label></td>
                    <td>${sessionScope.user.about}</td>
                </tr>
            </table>
        </div>
                <br><br>
        <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
            <input type="submit" value="Logout" />
        </form>
    </body>
</html>

<%-- 
    Document   : header
    Created on : Mar 3, 2016, 5:46:04 PM
    Author     : nk5946
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!DOCTYPE html>
<html>
    <nav>
        <a class="left" href="welcome.jsp">Home</a>
        <a class="left" href="SearchServlet?&action=load">Search</a>
        <a class="left" href="">Friends</a>
        <a class="left" href="EditServlet?&email=${sessionScope.user.email}&password=${sessionScope.user.password}">Edit Profile</a>
        <a class="left" href="ViewReviewsServlet?action=load">Reviews</a>
        <a class="right" href="LogoutServlet?&action=Logout">Logout</a>
        <a class="right" href="">Report</a>
        <a class="right" href="FAQ.html">FAQ</a>
        <div class="clear"></div>
    </nav>
    
</html>

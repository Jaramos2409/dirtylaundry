<%-- 
    Document   : home
    Created on : Mar 3, 2016, 5:01:25 PM
    Author     : nk5946
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
<jsp:include page="header.jsp"/>
<link rel="stylesheet" type="text/css" href="style/style.css">

</head>


<body>


<div id="name">
${sessionScope.user.firstname} ${sessionScope.user.lastname}
</div>

<div id="bio">
	<div id="bio-title">About Me!</div>
	${sessionScope.user.about} 
</div>


<div id="info-reviews">
	<div id="info">
		<div id="info-title">Personal Info!</div>
		Lives in: ${sessionScope.user.city}, ${sessionScope.user.state}<br>
		Hometown: ${sessionScope.user.city} <br>
		Sex: ${sessionScope.user.gender} <br>
		Birth Date: ${sessionScope.user.birthday} <br> 
		Ethnicity: ${sessionScope.user.ethnicity} <br>
		Education: ${sessionScope.user.education} <br>
		Job History: ${sessionScope.user.occupation} <br>
		Email: ${sessionScope.user.email} <br>
		Phone: ${sessionScope.user.phone} <br>
		Relationship: ${sessionScope.user.relationship} <br>
                
                <a href="EditServlet?&email=${sessionScope.user.email}&password=${sessionScope.user.password}">Edit Personal Information</a>
	</div>
        

        <div id="reviews">
            <div id="title-and-button">
                    <div id="review-title">Reviews!</div>
                    <a id="review-button" href="">Write Review</a>
                    <div class="clear"></div>
            </div>
             
            <c:if test="${empty sessionScope.user.reviews.reviews}"> blank </c:if>
            <c:if test="${not empty sessionScope.user.reviews.reviews}">
                <c:forEach items="${sessionScope.user.reviews.reviews}" var="review">
                    <div class="review">
                        ${review.reviewer_name}'s Review:
                        <div class="review-inner">${review.reviewtext}</div>
                        Agree: ${review.agree_count}<br>
                        Disagree: ${review.disagree_count}<br>
                    </div>
                </c:forEach>
            </c:if>
        </div>

</div>

                    <br><br><br>
<jsp:include page="pageDebugger.jsp"/>
</body>

</html>

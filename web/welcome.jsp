<%-- 
    Document   : home
    Created on : Mar 3, 2016, 5:01:25 PM
    Author     : nk5946
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


		<div class="review">
		RATING: ${review.rating}/5
		<div class="review-inner">this is a review</div>
		</div>
		
		<!-- for reviews in review list -->
		<!-- <div class="review"> score: ${review.score} /5 -->
		<!-- <div class="review-inner"> ${review.message} </div></div> -->
	</div>
</div>


</body>

</html>

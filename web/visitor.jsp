<%-- 
    Document   : visitor
    Created on : Mar 4, 2016, 6:23:06 PM
    Author     : EVA Unit 02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" type="text/css" href="style/style.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${visitee.firstname}'s Page</title>
    </head>
    <body>
        <div id="name">
            ${visitee.firstname} ${visitee.lastname}
        </div>

        <div id="bio">
                <div id="bio-title">About Me!</div>
                ${visitee.about} 
        </div>

        <div id="info-reviews">
                <div id="info">
                        <div id="info-title">Personal Info!</div>
                        Lives in: ${visitee.city}, ${visitee.state}<br>
                        Hometown: ${visitee.city} <br>
                        Sex: ${visitee.gender} <br>
                        Birth Date: ${visitee.birthday} <br> 
                        Ethnicity: ${visitee.ethnicity} <br>
                        Education: ${visitee.education} <br>
                        Job History: ${visitee.occupation} <br>
                        Email: ${visitee.email} <br>
                        Phone: ${visitee.phone} <br>
                        Relationship: ${visitee.relationship} <br>
                </div>

                <div id="reviews">
                    <div id="title-and-button">
                        <div id="review-title">Reviews!</div>
                            <a id="review-button" href="PostReviewServlet?&action=load&visiteeid=${visitee.id}">
                                Write Review
                            </a>
                            <div class="clear"></div>
                    </div>

                    <c:if test="${empty visitee.reviews.reviews}"> 
                        No Reviews Available :(. Be the first to review this person! 
                    </c:if>
                    <c:if test="${not empty visitee.reviews.reviews}">
                        <c:forEach items="${visitee.reviews.reviews}" var="review">
                            <div class="review">
                               <a href="VisitorServlet?&action=visitor&id=${review.reviewer_id}">
                                 ${review.reviewer_name}</a>'s Review of <a href="VisitorServlet?&action=visitor&id=${visitee.id}">
                                 ${visitee.firstname} ${visitee.lastname}</a>:
                                <div class="review-inner">${review.reviewtext}</div>
                                ${review.agree_count} people agree with this review.<br>
                                ${review.disagree_count} people disagree with this review.<br>
                                What about you? <a href="AgreeServlet?&action=agree&reviewid=${review.id}&revieweeid=${review.reviewee_id}">Agree</a> 
                                or <a href="DisagreeServlet?&action=disagree&reviewid=${review.id}&revieweeid=${review.reviewee_id}">Disagree</a><br>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
        </div>
    </body>
</html>

<%-- 
    Document   : reviews
    Created on : Mar 6, 2016, 7:29:11 PM
    Author     : EVA Unit 02
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" type="text/css" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reviews</title>
    </head>
    <body>
            <div id="view-reviews-left">
                <div id="title-and-button">
                        <div id="review-title">Reviews you have made!</div>
                        <div class="clear"></div>
                </div>
                <c:if test="${empty reviewsByYou.reviews}"> 
                            No Reviews Available :(. Review some people fool!
                </c:if>
                <c:if test="${not empty reviewsByYou.reviews}">
                    <c:forEach items="${reviewsByYou.reviews}" var="review">
                        <div class="review">
                            Review of <a href="VisitorServlet?&action=visitor&id=${review.reviewee_id}">
                                 ${review.reviewer_name}</a>:
                            <div class="review-inner">${review.reviewtext}</div>
                            Agree: ${review.agree_count}<br>
                            Disagree: ${review.disagree_count}<br>
                            <a id="review-button" href="DeleteReviewServlet?&action=delete&reviewid=${review.id}">
                                Delete Review</a>
                            <a id="review-button" href="EditReviewServlet?&action=load&reviewid=${review.id}">
                                Edit Review</a>
                        </div>
                    </c:forEach>
                </c:if>
            </div><br><br><br><br>
            <div id="view-reviews-right">
                <div id="title-and-button">
                        <div id="review-title">Reviews of you!</div>
                        <div class="clear"></div>
                </div>

                <c:if test="${empty sessionScope.user.reviews.reviews}"> 
                            No Reviews Available :(. Ask someone to review you! 
                </c:if>
                <c:if test="${not empty sessionScope.user.reviews.reviews}">
                    <c:forEach items="${sessionScope.user.reviews.reviews}" var="review">
                        <div class="review">
                             <a href="VisitorServlet?&action=visitor&id=${review.reviewer_id}">
                                 ${review.reviewer_name}</a>'s Review of You:
                            <div class="review-inner">${review.reviewtext}</div>
                            Agree: ${review.agree_count}<br>
                            Disagree: ${review.disagree_count}<br>
                        </div>
                    </c:forEach>
                </c:if>
           </div>
    </body>
</html>

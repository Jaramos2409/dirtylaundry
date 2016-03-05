<%-- 
    Document   : visitor
    Created on : Mar 4, 2016, 6:23:06 PM
    Author     : EVA Unit 02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

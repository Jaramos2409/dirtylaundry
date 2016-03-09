<%-- 
    Document   : uploadprofilepic
    Created on : Mar 8, 2016, 5:07:25 PM
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
        <title>Upload Profile Picture</title>
    </head>
    <body>
        <h3>File Upload:</h3>
        Select a file to upload: <br />
        <form action="UploadServlet" method="post"
                                enctype="multipart/form-data">
        <input type="file" name="file" size="50" />
        <br />
        <input type="submit" value="Upload File" />
        </form>
    </body>
</html>

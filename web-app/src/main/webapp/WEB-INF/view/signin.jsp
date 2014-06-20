<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/11/2014
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link href="<c:url value="../../resources/css/pagesStyle/reset.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/pagesStyle/animate.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/pagesStyle/styles.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrapValidator.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/jquery-2.1.1.min.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrapValidator.min.js"/>"></script>
    <title></title>
</head>
<body>
<div id="container">

    <form action="/j_spring_security_check" method="post">

        <label for="j_username">Username:</label>

        <input id="j_username" name="j_username" size="20" maxlength="50" type="name">

        <label for="j_password">Password:</label>

        <p><a href="#">Forgot your password?</a>

            <input id="j_password" name="j_password" size="20" maxlength="50" type="password">

        <div id="lower">

            <input type="checkbox"><label class="check">Keep me logged in</label>

            <input type="submit" value="Login">

        </div>

    </form>

</div>
</body>
</html>

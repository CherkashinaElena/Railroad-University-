<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/7/2014
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link href="<c:url value="../../resources/css/pagesStyle/adminPageStyle.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/pagesStyle/station_style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrapValidator.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/jquery-2.1.1.min.js"/>"></script>
    <script src="<c:url value="../../resources/js/jquery.filtertable.min.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrapValidator.min.js"/>"></script>
    <link href="<c:url value="../../resources/css/DateTimePicker.css"/>" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/DateTimePicker.js"/>"></script>
    <title>Header</title>
</head>
<body>
<div class="header">
    <div class="logo">
        <h1>Biletik.com</h1>
    </div>
    <div class="logout">
        <sec:authorize access="isAuthenticated()">
            <a href="<c:url value="/logout"/>">Logout</a>
        </sec:authorize>
    </div>
</div>
</body>
</html>

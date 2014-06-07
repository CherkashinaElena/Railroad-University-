<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/7/2014
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Admin layout</title>
</head>
<body>
<%@include file="layout.jsp"%>
<nav class="navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/admin/stations">Stations</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/8/2014
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Routes</title>
    <link href="<c:url value="../../resources/css/pagesStyle/station_style.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>All routes</h1>

    <div class="content">
        <a class="btn btn-lg btn-success" href="/admin/routes/addRoute">New route</a>

        <div class="content_table">
            <table id="stations" class="table table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Station</th>
                    <th>Train</th>
                    <th>Time in</th>
                    <th>Time out</th>
                    <th>Minutes</th>
                    <th>Kilometers</th>
                    <th>Priority</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${routeList}" var="route">
                    <tr>
                        <td>${route.stationByIdstation.namestation}</td>
                        <td>${route.trainByIdtrain.nametrain}</td>
                        <td>${route.timein}</td>
                        <td>${route.timeout}</td>
                        <td>${route.minutes}</td>
                        <td>${route.kilometers}</td>
                        <td>${route.priority}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="layout_footer.jsp"%>
</body>
</html>

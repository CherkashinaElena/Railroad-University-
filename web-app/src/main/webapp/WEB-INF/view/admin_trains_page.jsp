<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/8/2014
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Trains</title>
    <link href="<c:url value="../../resources/css/pagesStyle/station_style.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>All trains</h1>

    <div class="content">
        <a class="btn btn-lg btn-success" href="/admin/trains/addTrain">New train</a>

        <div class="content_table">
            <table id="stations" class="table table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Number</th>
                    <th>Name</th>
                    <th>Count of wagons</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${trainList}" var="train">
                    <tr>
                        <td>${train.numbertrain}</td>
                        <td>${train.nametrain}</td>
                        <td>${train.maxcountwagons}</td>
                        <td><a href="/admin/editTrain/${train.idtrain}"><button type="button" class="btn btn-warning">Edit</button></a></td>
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

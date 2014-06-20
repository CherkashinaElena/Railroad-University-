<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/7/2014
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Stations</title>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>All stations</h1>

    <div class="content">
        <a class="btn btn-lg btn-success" href="/admin/stations/addStation">New station</a>

        <div class="content_table">
            <table id="stations" class="table table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Station</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${stationsList}" var="station">
                    <tr>
                        <td>${station.idstation}</td>
                        <td>${station.namestation}</td>
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


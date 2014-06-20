<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/9/2014
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Type of wagons</title>
    <link href="<c:url value="../../resources/css/pagesStyle/station_style.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>All types</h1>

    <div class="content">

        <div class="content_table">
            <table id="stations" class="table table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Type</th>
                    <th>Class</th>
                    <th>Price</th>
                    <th>Note</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${typeofWagonList}" var="type">
                    <tr>
                        <td>${type.type}</td>
                        <td>${type.myclass}</td>
                        <td>${type.price}</td>
                        <td>${type.note}</td>
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

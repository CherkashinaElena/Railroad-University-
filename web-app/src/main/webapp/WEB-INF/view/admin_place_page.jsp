<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/15/2014
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Places</title>
    <link href="<c:url value="../../resources/css/pagesStyle/station_style.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>All tickets</h1>
    <div class="content">
        <a class="btn btn-lg btn-success" href="/admin/places/addPlace">New place</a>
        <div class="content_table">
            <form class="navbar-form navbar-right">
                <input type="search" class="form-control" id="global_filter" placeholder="Search">
            </form>
            <table id="tickets" class="table table-bordered display" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>PlaceNo</th>
                    <th>Wagon</th>
                    <th>Train</th>
                    <th>Type</th>
                    <th>Class</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${placesList}" var="place">
                    <tr>
                        <td>${place.placeno}</td>
                        <td>${place.idwagon}</td>
                        <td>${place.wagon.trainByIdtrain.numbertrain} ${place.wagon.trainByIdtrain.nametrain}</td>
                        <td>${place.wagon.typeofwagonByIdtypeofwagon.type}</td>
                        <td>${place.wagon.typeofwagonByIdtypeofwagon.myclass}</td>
                        <td>${place.wagon.typeofwagonByIdtypeofwagon.price}</td>
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

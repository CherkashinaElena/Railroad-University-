<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/10/2014
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="../../resources/css/pagesStyle/visitor_main_page.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/DateTimePicker.css"/>" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/jquery-2.1.1.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrap-collapse.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="../../resources/js/DateTimePicker.js"/>"></script>
</head>
<body>
<div class="main">
    <div class="main_header">
        <div class="logo">
            <h1>Biletik.com</h1>
        </div>
    </div>
    <nav class="navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Main</a></li>
                    <li class="active"><a href="/searchtrain">Tickets</a></li>
                    <li class="active"><a href="#">Plan your trip</a></li>
                    <li class="active"><a href="#">Trains in Europe</a></li>
                    <li class="active"><a href="#">Contact</a></li>
                    <li class="active"><a href="#">About</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="content_search_trains">
        <h1>Choose place</h1>
        <div class="content row search_result">
            <table id="trains" class="table table-bordered col-md-12" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <td>Wagon</td>
                    <td>Place</td>
                    <td>Type</td>
                    <td>Class</td>
                    <td>Price</td>
                    <td>Select</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${placeList}" var="place">
                    <tr>
                        <td>${place.wagon.idwagon}</td>
                        <td>${place.placeno}</td>
                        <td>${place.wagon.typeofwagonByIdtypeofwagon.type}</td>
                        <td>${place.wagon.typeofwagonByIdtypeofwagon.myclass}</td>
                        <td>${place.wagon.typeofwagonByIdtypeofwagon.price}</td>
                        <td><a href="/selectPlace/${place.idplace}">Select</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

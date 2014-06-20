<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/11/2014
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Tickets</title>
    <link href="<c:url value="../../resources/css/pagesStyle/station_style.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>All tickets</h1>
    <div class="content">
        <div class="content_table">
            <form class="navbar-form navbar-right">
                <input type="search" class="form-control" id="global_filter" placeholder="Search">
            </form>
            <table id="tickets" class="table table-bordered display" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Train</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Date</th>
                    <th>Place</th>
                    <th>Wagon</th>
                    <th>Type</th>
                    <th>Class</th>
                    <th>Price</th>
                    <th>Document</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ticketList}" var="ticket">
                    <tr>
                        <td>${ticket.nameclient}</td>
                        <td>${ticket.surnameclient}</td>
                        <td>${ticket.routeByIdrouteout.trainByIdtrain.numbertrain} ${ticket.routeByIdrouteout.trainByIdtrain.nametrain}</td>
                        <td>${ticket.routeByIdrouteout.stationByIdstation.namestation}</td>
                        <td>${ticket.routeByIdroutein.stationByIdstation.namestation}</td>
                        <td>${ticket.datein}</td>
                        <td>${ticket.placeByIdplace.placeno}</td>
                        <td>${ticket.placeByIdplace.idwagon}</td>
                        <td>${ticket.placeByIdplace.wagon.typeofwagonByIdtypeofwagon.type}</td>
                        <td>${ticket.placeByIdplace.wagon.typeofwagonByIdtypeofwagon.myclass}</td>
                        <td>${ticket.price}</td>
                        <td>${ticket.document}</td>
                        <td><a href="/admin/deleteTicket/${ticket.idticket}"><button type="button" class="btn btn-danger">Delete</button></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $('#tickets').filterTable({
            filterSelector: '#global_filter'
        });
    });
</script>
<%@include file="layout_footer.jsp"%>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/9/2014
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wagons</title>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>All wagons</h1>

    <div class="content">
        <a class="btn btn-lg btn-success" href="/admin/wagons/addWagon">New wagon</a>

        <div class="content_table">
            <table id="stations" class="table table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Wagon</th>
                    <th>Train</th>
                    <th>Type</th>
                    <th>Class</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${wagonsList}" var="wagon">
                    <tr>
                        <td>${wagon.idwagon}</td>
                        <td>${wagon.trainByIdtrain.numbertrain} ${wagon.trainByIdtrain.nametrain}</td>
                        <td>${wagon.typeofwagonByIdtypeofwagon.type}</td>
                        <td>${wagon.typeofwagonByIdtypeofwagon.myclass}</td>
                        <td>${wagon.typeofwagonByIdtypeofwagon.price}</td>
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

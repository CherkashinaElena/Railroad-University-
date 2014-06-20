<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/11/2014
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link href="<c:url value="../../resources/css/pagesStyle/ticketPageStyle.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/DateTimePicker.css"/>" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/jquery-2.1.1.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="../../resources/js/DateTimePicker.js"/>"></script>
</head>
<body>
<div class="ticket">
    <div class="table_content">
        <table id="ticket" class="table table-condensed" cellspacing="0" width="100%">
            <tr>
                <th colspan="2" align="center">
                    ${ticket.routeByIdrouteout.trainByIdtrain.numbertrain} ${ticket.routeByIdrouteout.trainByIdtrain.nametrain}
                </th>
            </tr>
            <tr>
                <td>
                    From: ${ticket.routeByIdrouteout.stationByIdstation.namestation}
                    <br/>
                    To: ${ticket.routeByIdroutein.stationByIdstation.namestation}
                    <br/>
                    Date: ${dateOut}
                    <br/>
                    Departure time: ${timeOut}
                    <br/>
                    Incomming time: ${timeIn}
                </td>
                <td align="right">
                    Place: 0${ticket.placeByIdplace.placeno}
                    <br/>
                    Wagon: 0${ticket.placeByIdplace.wagon.idwagon}
                    <br/>
                    Type: ${ticket.placeByIdplace.wagon.typeofwagonByIdtypeofwagon.type}
                    <br/>
                    Class: ${ticket.placeByIdplace.wagon.typeofwagonByIdtypeofwagon.myclass}
                </td>
            </tr>
            <tr>
                <td>
                    Passenger: ${ticket.nameclient} ${ticket.surnameclient}
                    <br/>
                    Document: ${ticket.document}
                </td>
                <td align="right">
                    Price: ${ticket.price}
                </td>
            </tr>
        </table>
    </div>

</div>
</body>
</html>

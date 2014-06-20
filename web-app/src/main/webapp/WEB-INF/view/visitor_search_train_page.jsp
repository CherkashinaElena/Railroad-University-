<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/10/2014
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link href="<c:url value="../../resources/css/pagesStyle/visitor_main_page.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrapValidator.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/DateTimePicker.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="../../resources/js/jquery-2.1.1.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrapValidator.min.js"/>"></script>
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
        <h1>Search train</h1>
        <div class="content row all_content_search_trains">
            <div class="col-md-6">
                <div class="search_form">
                    <form:form method="post" id="searchTrainForm" action="/searchtrain/search" commandName="commandSearchTrain" cssClass="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-3 control-label" for="stationfrom">From</label>

                            <div class="col-md-7">
                                <form:input path="routeByIdrouteout.stationByIdstation.namestation" id="stationfrom" name="stationfrom" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label" for="stationto">To</label>

                            <div class="col-md-7">
                                <form:input path="routeByIdroutein.stationByIdstation.namestation" id="stationto" name="stationto" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label" for="date">Date</label>

                            <div class="col-md-7">
                                <form:input path="datein" data-field="date" name="date" id="date" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button class="btn btn-danger" type="reset">Clear</button>
                                <button id="submitButton" class="btn btn-success" type="submit">Search</button>
                            </div>
                        </div>
                        <div id="dtBox"></div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#dtBox").DateTimePicker();

    });
</script>

<script>
    $(document).ready(function () {
        $('#searchTrainForm').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                stationfrom: {
                    message: 'The station is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The station is required and cannot be empty'
                        }
                    }
                }
            }
        });
    });
</script>
</body>
</html>

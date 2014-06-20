<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/10/2014
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link href="<c:url value="../../resources/css/pagesStyle/visitor_main_page.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/DateTimePicker.css"/>" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/jquery-2.1.1.js"/>"></script>
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
        <h1>Enter information</h1>

        <div class="content row">
                <form:form method="post" modelAttribute="commandCreateOrder" id="orderForm"
                           action="/makeOrder" cssClass="form-horizontal col-md-7">
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="name">Name</label>

                        <div class="col-md-10">
                            <form:input path="nameclient" id="name" name="nameclient" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="surname">Surname</label>

                        <div class="col-md-10">
                            <form:input path="surnameclient" id="surname" name="surnameclient" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="gender">Gender</label>

                        <div class="col-md-10">
                            <form:select path="gender" id="gender" cssClass="form-control">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="document">Document</label>

                        <div class="col-md-10">
                            <form:select path="document" id="document" cssClass="form-control">
                                <option value="passport">Passport</option>
                                <option value="student card">Student card</option>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="from">From</label>

                        <div class="col-md-10">
                            <form:input path="routeByIdrouteout.stationByIdstation.namestation" id="from"
                                        readonly="true" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="to">To</label>

                        <div class="col-md-10">
                            <form:input path="routeByIdroutein.stationByIdstation.namestation" id="to"
                                        readonly="true" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="date">Date</label>

                        <div class="col-md-10">
                            <form:input path="datein" id="date" value="${date}" readonly="true"
                                        cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="wagon">Wagon</label>

                        <div class="col-md-10">
                            <form:input path="placeByIdplace.idwagon" id="wagon" readonly="true"
                                        cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="place">Place</label>

                        <div class="col-md-10">
                            <form:input path="placeByIdplace.placeno" id="place" readonly="true"
                                        cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="type">Type</label>

                        <div class="col-md-10">
                            <form:input path="placeByIdplace.wagon.typeofwagonByIdtypeofwagon.type" id="type"
                                        readonly="true" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="clazz">Class</label>

                        <div class="col-md-10">
                            <form:input path="placeByIdplace.wagon.typeofwagonByIdtypeofwagon.myclass" id="clazz"
                                         readonly="true" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="price">Price</label>

                        <div class="col-md-10">
                            <form:input path="price" id="price" readonly="true"
                                        cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button class="btn btn-danger" type="reset">Clear</button>
                            <button class="btn btn-success" type="submit">Make order</button>
                        </div>
                    </div>
                </form:form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#orderForm').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nameclient: {
                    message: 'The name is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The name is required and cannot be empty'
                        },
                        stringLength: {
                            max: 50,
                            message: 'The name must be less than 50 characters long'
                        }
                    }
                },
                surnameclient: {
                    message: 'The surname is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The surname is required and cannot be empty'
                        },
                        stringLength: {
                            max: 50,
                            message: 'The surname must be 50 characters long'
                        }
                    }
                }
            }
        });
    });
</script>
</body>
</html>

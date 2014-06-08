<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/8/2014
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Routes</title>
    <link href="<c:url value="../../resources/css/pagesStyle/station_style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrapValidator.min.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>Add station</h1>

    <div class="content row">
        <div class="form_content col-lg-7">
            <form:form method="post" id="routeForm" action="/admin/routes/saveRoute"
                       commandName="commandAddRoute" cssClass="form-horizontal">

                <div class="row">
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="namestation">Station</label>

                        <div class="col-md-7">
                            <form:select path="stationByIdstation.namestation" name="namestation" id="namestation" cssClass="form-control">
                                <c:forEach var="station" items="${stationsOptionsList}">
                                    <form:option value="${station.namestation}">${station.namestation}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="numbertrain">Train</label>

                        <div class="col-md-7">
                            <form:select path="trainByIdtrain.numbertrain" id="numbertrain" cssClass="form-control">
                                <c:forEach var="train" items="${trainsOptionsList}">
                                    <form:option value="${train.numbertrain}"><c:out value="${train.numbertrain} ${train.nametrain}"/></form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="timein">Time in</label>

                        <div class="col-md-7">
                            <form:input path="timein" data-field="time" name="timein" id="timein" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="timeout">Time out</label>

                        <div class="col-md-7">
                            <form:input path="timeout" data-field="time" name="timeout" id="timeout" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="kilometers">Kilometers</label>

                        <div class="col-md-7">
                            <form:input path="kilometers" name="kilometers" id="kilometers" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="priority">Priority</label>

                        <div class="col-md-7">
                            <form:input path="priority" name="priority" id="priority" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button class="btn btn-danger" type="reset">Clear</button>
                            <button class="btn btn-success" type="submit">Save changes</button>
                        </div>
                    </div>

                </div>
                <div id="dtBox"></div>
            </form:form>
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
        $('#routeForm').bootstrapValidator({
            fields: {
                timein: {
                    message: 'The time is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The time is required and cannot be empty'
                        }
                    }
                },
                timeout: {
                    message: 'The time is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The time is required and cannot be empty'
                        }
                    }
                },
                kilometers: {
                    message: 'The kilometer is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The kilometer is required and cannot be empty'
                        },
                        stringLength: {
                            min: 1,
                            max: 10,
                            message: 'The number must be more than 1 and less than 10 numbers long'
                        },
                        regexp: {
                            regexp: /^[0-9.]+$/,
                            message: 'The station can only consist of number and dot'
                        }
                    }
                },
                priority: {
                    message: 'The priority is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The priority is required and cannot be empty'
                        },
                        stringLength: {
                            min: 1,
                            max: 10,
                            message: 'The priority must be more than 1 and less than 5 numbers long'
                        },
                        regexp: {
                            regexp: /^[0-9]+$/,
                            message: 'The station can only consist of number'
                        }
                    }
                }
            }
        });
    });
</script>
<%@include file="layout_footer.jsp"%>
</body>
</html>

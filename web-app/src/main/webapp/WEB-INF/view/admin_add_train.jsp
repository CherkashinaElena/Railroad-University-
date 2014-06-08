<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/8/2014
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Trains</title>
    <link href="<c:url value="../../resources/css/pagesStyle/station_style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrapValidator.min.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>Add train</h1>

    <div class="content row">
        <div class="form_content col-lg-7">
            <form:form id="trainForm" method="post" action="/admin/trains/saveTrain" commandName="commandAddTrain"
                       cssClass="form-horizontal">

                <div class="row">
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="numbertrain">Number</label>

                        <div class="col-md-7">
                            <form:input path="numbertrain" name="numbertrain" id="numbertrain" cssClass="form-control"/>
                        </div>
                        <div id="trainAviabilityResult"></div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="nametrain">Train</label>

                        <div class="col-md-7">
                            <form:input path="nametrain" name="nametrain" id="nametrain" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="maxcountwagons">Count of wagons</label>

                        <div class="col-md-7">
                            <form:input path="maxcountwagons" name="maxcountwagons" id="maxcountwagons" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button class="btn btn-danger" type="reset">Clear</button>
                            <button id="submitButton" class="btn btn-success" type="submit">Save changes</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
        <div class="tip col-lg-4">
            <div class="tip_header">
                <h3>Tip of a day</h3>
            </div>
            <div class="tip_content">
                <p>
                    Virgin Atlantic has collaborated with the original onesie designers,
                    OnePiece, to trial a limited edition OnePiece onesie for Upper Class passengers.
                    Modelled by English model, Amber Le Bon, the onesie is set to become a must have
                    for bedtime glamour and will be available from mid-June for a thousand passengers
                    travelling on selected night flights across Virgin Atlantic’s long haul network.
                </p>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#trainForm').bootstrapValidator({
            fields: {
                numbertrain: {
                    message: 'The number is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The number is required and cannot be empty'
                        },
                        stringLength: {
                            min: 3,
                            max: 5,
                            message: 'The number must be more than 3 and less than 5 characters long'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: 'The station can only consist of alphabetical, number and underscore'
                        }
                    }
                },
                nametrain: {
                    message: 'The train is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The train is required and cannot be empty'
                        },
                        stringLength: {
                            min: 3,
                            max: 100,
                            message: 'The train must be more than 3 and less than 100 characters long'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_-]+$/,
                            message: 'The train can only consist of alphabetical, number and underscore'
                        }
                    }
                },
                maxcountwagons: {
                    message: 'The count is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The count is required and cannot be empty'
                        },
                        regexp: {
                            regexp: /^[0-9]+$/,
                            message: 'The train can only consist of number'
                        }
                    }
                }
            }
        });
    });
</script>

<script>
    function check_availability(){
        $.ajax({
            type: "POST",
            url: "/admin/trains/addTrain/checkTrain",
            cache: false,
            beforeSend: function () {
                $('#trainAviabilityResult').html('Checking...');
            },
            data: 'numbertrain=' + $('#numbertrain').val(),
            success: function (response) {
                $('#trainAviabilityResult').html("");
                var obj = JSON.parse(response);
                console.log(obj);
                if (obj == 'false') {
                    $("#trainAviabilityResult").html("Train already exist").css('color', 'red');
                    $("#submitButton").attr('disabled', true);
                } else {
                    $("#trainAviabilityResult").html("").css('color', 'green');
                    $("#submitButton").attr('disabled', false);
                }
            },
            error: function (jqXhr, textStatus, errorThrown) {
                alert(textStatus);
            }
        })
    }

    $('#numbertrain').blur(function(){
        check_availability();
    });
</script>
<%@include file="layout_footer.jsp"%>
</body>
</html>

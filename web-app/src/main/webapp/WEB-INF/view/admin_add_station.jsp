<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/8/2014
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Stations</title>
    <link href="<c:url value="../../resources/css/pagesStyle/station_style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrapValidator.min.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>Add station</h1>

    <div class="content row">
        <div class="form_content col-lg-7">
            <form:form method="post" id="stationForm" action="/admin/stations/saveStation" commandName="commandAddStation" cssClass="form-horizontal">

                <div class="row">
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="namestation">Station</label>

                        <div class="col-md-7">
                            <form:input path="namestation" id="namestation" name="namestation" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button class="btn btn-danger" type="reset">Clear</button>
                            <button class="btn btn-success" type="submit">Save changes</button>
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
                    Nominees at the World Ski Awards, the only global initiative to
                    recognise, reward and celebrate excellence in the ski hospitality
                    industry, have been revealed as voting opens ahead of the 2014 Gala
                    Ceremony.
                </p>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#stationForm').bootstrapValidator({
            fields: {
                namestation: {
                    message: 'The station is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The station is required and cannot be empty'
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: 'The station must be more than 3 and less than 30 characters long'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: 'The station can only consist of alphabetical, number and underscore'
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

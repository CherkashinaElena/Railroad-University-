<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/15/2014
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Places</title>
    <link href="<c:url value="../../resources/css/pagesStyle/station_style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrapValidator.min.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="admin_main_page.jsp" %>
<div class="main">
    <h1>Add station</h1>

    <div class="content row">
        <div class="form_content col-lg-7">
            <form:form method="post" id="routeForm" action="/admin/places/savePlace"
                       commandName="commandAddPlace" cssClass="form-horizontal">

                <div class="row">
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="placeno">Place</label>

                        <div class="col-md-7">
                            <form:input path="placeno" name="placeno" id="placeno" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="idwagon">Wagon</label>

                        <div class="col-md-7">
                            <form:select path="idwagon" id="idwagon" cssClass="form-control">
                                <c:forEach var="wagon" items="${wagonOptionList}">
                                    <form:option value="${wagon.idwagon}"><c:out value="${wagon.idwagon}"/></form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="numbertrain">Train</label>

                        <div class="col-md-7">
                            <form:select path="wagon.trainByIdtrain.numbertrain" id="numbertrain" cssClass="form-control">
                                <c:forEach var="train" items="${trainsOptionsList}">
                                    <form:option value="${train.numbertrain}"><c:out value="${train.numbertrain} ${train.nametrain}"/></form:option>
                                </c:forEach>
                            </form:select>
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
    </div>
</div>
<%@include file="layout_footer.jsp"%>
</body>
</body>
</html>

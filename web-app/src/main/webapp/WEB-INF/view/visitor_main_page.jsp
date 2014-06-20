<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/9/2014
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Biletik.com</title>
    <link href="<c:url value="../../resources/css/pagesStyle/visitor_main_page.css"/>" rel="stylesheet"/>
    <link href="<c:url value="../../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/jquery-2.1.1.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrap-carousel.js"/>"></script>
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
                    <li class="active">
                        <spring:url value="/admin" var="adminUrl" />
                        <a href="${adminUrl}" title="Admin">Admin</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="myCarousel" class="carousel slide">
        <div class="carousel-inner">
            <div class="item active">
                <img src="../../resources/img/train1.jpg" alt="">
                <div class="carousel-caption">
                    <h1>The latest technology</h1>
                </div>
            </div>
            <div class="item">
                <img src="../../resources/img/train2.jpg" alt="">
                <div class="carousel-caption">
                    <h1>Best amenities</h1>
                </div>
            </div>

            <div class="item">
                <img src="../../resources/img/train3.jpg" alt="">
                <div class="carousel-caption">
                    <h1>Quality service</h1>
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="icon-prev"></span></a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="icon-next"></span></a>
    </div>

    <div class="content row all_content">
        <div class="col-md-6">
            <div class="content_header">
                <h3>Class Travel on European Trains</h3>
            </div>
            <div class="content_body">
                <p>
                    Comfort Class is train speak for first class.
                    This enhanced travel experience is possible
                    because there are fewer seats (and therefore,
                    fewer travelers) in the Comfort cabin. This makes
                    for a quieter, more spacious ride that includes
                    wider seats and more legroom than Economy Class.
                </p>

                <p>
                    Your accommodations can be in compartments for 5
                    or 6 people or in <q>airplane-style</q> open space
                    seating, 3-across separated by an aisle. These restful,
                    cushioned seats are usually covered in comfortable fabric or
                    leather. Most have reading lights, and many of them offer
                    country specific outlets that can be used with adapters. If
                    traveling overnight, these fares usually provide a one, two
                    or four-bed sleeping compartment.
                </p>

                <p>
                    Each train may offer additional services and amenities to travelers
                    with a Comfort Class ticket. For instance, the Renfe train gives a
                    personal audio-visual system at every seat whereas the Eurostar offers a
                    light meal. For a detailed description of the services and amenities on
                    specific trains, click on the “more information” link below the short train
                    description when you review the fares and schedules option in our booking
                    engine. Or simply visit our train pages.
                </p>

                <p>
                    Typically, Comfort Class is not significantly more expensive than Economy
                    making it an even greater value. So go on, treat yourself. It’s your vacation.
                </p>
            </div>
        </div>
        <div class="col-md-6">
            <div class="content_header">
                <h3>Altaria high-speed train</h3>
            </div>
            <div class="content_body">
                <img src="../../resources/img/map_with_altaria_routes.png" alt="">
                <p>
                    The Altaria is a high-speed long-distance train that
                    connects the Spanish capital Madrid to the southern
                    cities of Algeciras, Granada, Cartagena and Murcia.
                    Altaria trains are uniquely designed with gauge changing
                    technology enabling them to travel on both standard and
                    high-speed rails, reaching speeds of up to 200 km/hr.
                </p>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <h6>Copyright &copy; HelenCompany &#124; Bagira corporation</h6>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $("#myCarousel").carousel({
            interval : 5000,
            pause: false
        });
    });
</script>
</body>
</html>

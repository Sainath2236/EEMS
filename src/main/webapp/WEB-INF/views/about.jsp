<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${designation}</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/landing-page.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="css/simple-sidebar.css" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
<style> 
#footer {
	position: fixed;
	left: 0px;
	bottom: 0px;
	height: 45px;
	background-color: #e7e7e7;
	text-align: center;
	width: 100%;
}

.row {
	width: 99%;
}
</style>
<c:url value="/resources/img/bg.jpg" var="bgimage"></c:url>
</head>
<body
    style="width: 100%;background-image: url('${bgimage}');background-repeat:no-repeat;background-size:cover;">
    <jsp:include page="headerBeforeLogin.jsp"></jsp:include>
	<br />
	<br />
	<br />





	
	<br />
	<br />
	<br />
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6"><p><i><font style="font-family: Monotype Corsiva;font-size: 20px;">Employee expense management system is designed to help companies effectively manage reimbursement requests. The system facilitates entering expense reports and provides immediate error notification if information is missing or inaccurate. It also provides control mechanisms to monitor and audit expense reports, and the flexibility to customize the system for evolving expense and travel policies.</font></i></p></div>
		<div class="col-md-3"></div>
		</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">


    <div class="item active">
      <img src="resources/img/banner-bg.jpg" alt="Flower" size:30px>
    </div>

    <div class="item">
      <img src="resources/img/expense-management.jpg" alt="Flower" size:30px>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
  </div>
  	<div class="col-md-3"></div>
</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
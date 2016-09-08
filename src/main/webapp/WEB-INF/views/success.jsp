<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/landing-page.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Insert title here</title>
<style>

	#footer {position:fixed;
   left:0px;
   bottom:0px;
   height:47px;
   background-color:#e7e7e7;
   text-align:center;
   width:100%;
} 
</style>
<c:url value="/resources/img/bg.jpg" var="bgimage"></c:url>
</head>
<body style="width: 100%;background-image: url('${bgimage}');background-repeat:no-repeat;background-size:cover;">
    <jsp:include page="headerAfterLogin.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<center>
			<font color="Blue">
				<h1>**${sessionScope.status}**</h1>
			</font>
		</center>
		<br>
		<br>
		<center>
		<h1>
			<a href="<spring:url value="/"></spring:url>">LOGIN</a>
		</h1>
		</center>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
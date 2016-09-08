<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.ResourceBundle"%>
<%
	ResourceBundle resource = ResourceBundle.getBundle("webcontent");
	String projectName = resource.getString("projectName");
	String home = resource.getString("home");
	String about = resource.getString("about");
	String contact = resource.getString("contact");
	String logout = resource.getString("logout");
	String copyRight = resource.getString("copyRight");
	String newUser = resource.getString("newUser");
	String welcome = resource.getString("welcome");
	String claim = resource.getString("claim");
	String login = resource.getString("login");
%>
<html lang="en">


<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>EEMS</title>


<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">



<!-- Custom CSS -->
<link href="<c:url value="/resources/css/landing-page.css" />"
	rel="stylesheet"> 
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!-- Custom Fonts -->
<!-- <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css"> -->
<!--<link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">-->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->



<style>
.error {
	color: red;
}
</style>
<c:url value="/resources/img/intro-bg.jpg" var="bgimage"></c:url>
</head>

<body style="width: 100%;background-image: url('${bgimage}');background-repeat:no-repeat;background-size:cover;">
	<spring:url value="/home/loginSubmision" var="employeeLogin"></spring:url>

	<jsp:include page="headerBeforeLogin.jsp"></jsp:include>


	<!-- Header -->
	<a name="about"></a>
	<div class="intro-header">
		<div class="container">
		<br>
		<br>
			<h1 style="color: white;font-family: Monotype Corsiva;"><center><%=welcome%></center></h1>
			<h3 style="color: white; font-family: Monotype Corsiva;"><center><%=claim%></center></h3>
			<br>
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="panel panel-login">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-12">
										<center><p style="font-size: 20px;color: #337ab7; "><%=login%></p></center>
									</div>
								</div>
								<hr>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-12">
										<font color="Red">
											<h5>${message}</h5>
										</font>
										<spring:url value="/loginFailed" var="employeeLogin"></spring:url>
										<form:form id="login-form" action="${employeeLogin }"
											method="post" role="form" style="display: block;"
											modelAttribute="employee" commandName="employee">
											<div class="form-group">
												<form:input path="employeeId" type="text" name="employeeId"
													id="employeeId" tabindex="1" class="form-control"
													placeholder="Employee ID" />
												<form:errors path="employeeId" cssClass="error"></form:errors>
											</div>
											<div class="form-group">
												<form:input path="password" type="password" name="password"
													id="password" tabindex="2" class="form-control"
													placeholder="Password" />
												<form:errors path="password" cssClass="error"></form:errors>
											</div>

											<div class="form-group">
												<div class="row">
													<div class="col-sm-6 col-sm-offset-3">
														<input type="submit" name="login-submit" id="login-submit"
															tabindex="4" class="form-control btn btn-primary"
															value="Log In">
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-12">
														<div class="text-center">
															<a href="<spring:url value="/registration"></spring:url>"
																tabindex="5"><%=newUser%></a>
														</div>
													</div>
												</div>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
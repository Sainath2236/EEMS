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
<!-- <link href="css/simple-sidebar.css" rel="stylesheet"> -->
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link href="<c:url value="/resources/css/landing-page.css" />"
    rel="stylesheet">
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

tr td {
	padding: 5px;
}

.row {
	width: 99%;
}
</style>

<c:url value="/resources/img/bg.jpg" var="bgimage"></c:url>
</head>
<body style="width: 100%;background-image: url('${bgimage}');background-repeat:no-repeat;background-size:cover;">
    <jsp:include page="headerAfterLogin.jsp"></jsp:include>
	<br />
	<br />
	<br />


	<div class="row">
		<div class="col-md-2">
			<ul class="nav nav-pills  nav-stacked">

				<c:forEach items="${sessionScope.activities}" var="activity">
					<c:if
						test="${(activity.activityName eq 'View Vouchers') or (activity.activityName eq 'Create Voucher')}">
						<li role="presentation"><a
							href='<spring:url value="/${sessionScope.designation}/Voucher/${activity.activityName}"></spring:url>'>${activity.activityName}</a></li>
					</c:if>
					<c:if test="${(activity.activityName eq 'Bank Account')}">
						<li role="presentation"><a
							href='<spring:url value="/${sessionScope.designation}/Bank/${activity.activityName}"></spring:url>'>${activity.activityName}</a></li>
					</c:if>
					<c:if test="${(activity.activityName ne 'View Vouchers')}">
						<c:if test="${(activity.activityName ne 'Create Voucher') }">
							<c:if test="${(activity.activityName ne 'Bank Account') }">
								<li role="presentation"><a
									href='<spring:url value="/${sessionScope.designation}/${activity.activityName}"></spring:url>'>${activity.activityName}</a></li>
							</c:if>
						</c:if>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		<div class="col-md-10">
			<div class="container">
				<div class="jumbotron">
					<spring:url
						value="/${sessionScope.designation}/Bank/Bank Account/update"
						var="update"></spring:url>
					<form:form action="${update}">
						<table class="table table-hover" cellpadding="10" align="center"
							cellspacing="10">
							<tr>
							     <th>Account Details</th>
							     <th></th>
							</tr>
							<tr>
								<td>Account Number</td>
								<td>${requestScope.bankAccount.accountNumber}
							</tr>
							<tr>
								<td>Name</td>
								<td>${requestScope.bankAccount.accountName}</td>
							</tr>
							<tr>
								<td>Bank</td>
								<td>${requestScope.bankAccount.bankName}</td>
							</tr>
							<tr>
								<td>IFSC Code</td>
								<td>${requestScope.bankAccount.iFSCCode}</td>
							</tr>
							<tr>
								<td>Branch</td>
								<td>${requestScope.bankAccount.branch}</td>
							</tr>
							<tr>
								<td><input type="submit" value="Update"
									class="btn btn-primary" /></td>
									<td></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>

		</div>
	</div>
	<br />
	<br />
	<br />
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
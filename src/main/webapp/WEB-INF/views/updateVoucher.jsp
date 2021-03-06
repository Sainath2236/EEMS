<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.ResourceBundle"%>
<%
	ResourceBundle resource = ResourceBundle.getBundle("webcontent");
	String updateVoucher = resource.getString("updateVoucher");
	String voucherId = resource.getString("voucherId");
	String title = resource.getString("title");
	String description = resource.getString("description");
	String amount = resource.getString("amount");
%>
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
<script src="<c:url value="/resources/js/jsvalidations.js" />"></script>
<!-- Custom CSS -->
<link href="css/simple-sidebar.css" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!-- <script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
    src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->

<script type="text/javascript" src="/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
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

.error {
	color: red;
	font-size: 12px;
}

.row {
	width: 99%;
}
</style>

<c:url value="/resources/img/bg.jpg" var="bgimage"></c:url>
</head>
<body
	style="width: 100%;background-image: url('${bgimage}');background-repeat:no-repeat;background-size:cover;">
	<jsp:include page="headerAfterLogin.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$('#amount').keyup(function() {
						$('span.error-keyup-3').hide();
						var a = /[~!@#$%^&*(){}|?a-zA-Z]/;
						var amount = $('#amount').val();
						if (amount < 0) {
							$('#erroramt').html("only positive amount").show();
							return false;
						}
						if (a.test(amount)) {
							$('#erroramt').html("only positive amount").show();
							return false;
						}
						;
					});
					$('#register').click(
							function() {
								$('span.error-keyup-1').hide();
								var description = $('#description').val();
								if (description == '') {
									$('#errordesc').html(
											"description cannot be empty")
											.show();
									return false;
								}
								$('span.error-keyup-2').hide();
								var amount = $('#amount').val();
								if (amount == 0.0 || amount == '') {
									$('#erroramt').html(
											"amount cannot be zero or empty")
											.show();
									return false;
								}
							});
				});
	</script>

	<br />
	<br />
	<br />

	<%-- <div class="row">
        <div class="col-md-10"></div>
        <div class="col-md-2">${sessionScope.employee.name}</div>
    </div> --%>
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
			<spring:url value="/${sessionScope.designation}/Voucher/update"
				var="update"></spring:url>
			<form:form action="${update}" modelAttribute="voucher" id="register">

				<table cellpadding="10" align="center" cellspacing="10">

					<tr>
						<td colspan=2>
							<center>
								<font size=4><b><%=updateVoucher%></b></font>
							</center>
						</td>
					</tr>
					<tr>
						<td><%=voucherId%></td>
						<td><form:input path="voucherId" id="voucherId"
								class="form-control" readonly="true" /></td>
					</tr>
					<tr>
						<td><%=title%></td>
						<td><form:input path="title" id="title" class="form-control"
								readonly="true" /></td>
					</tr>

					<tr>
						<td></td>
						<td><span class="error error-keyup-1" id="errordesc"
							align="center"><form:errors path="description"
									cssClass="error"></form:errors></span></td>
						<td></td>

					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td><%=description%></td>
						<td><form:textarea path="description" cols="40" rows="8"
								id="description" class="form-control" /></td>
					</tr>

					<tr>
						<td></td>
						<td><span class="error error-keyup-2" id="erroramt"
							align="center"><form:errors path="amount" cssClass="error"></form:errors></span></td>
						<td></td>

					</tr>
					<tr>
						<td><%=amount%></td>
						<td><form:input type="text" path="amount" id="amount"
								class="form-control" placeholder="Amount" /></td>
					</tr>

					<tr>
						<td><input type="submit" value="Submit"
							class="btn btn-primary" /></td>
					</tr>



				</table>

			</form:form>
		</div>
	</div>
	<br />
	<br />
	<br />
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import = "java.util.ResourceBundle" %> 
<% ResourceBundle resource = ResourceBundle.getBundle("webcontent");
String accountDetails = resource.getString("accountDetails");
String accountNumber = resource.getString("accountNumber");
String accountName = resource.getString("accountName");
String bankName = resource.getString("bankName");
String iFSCCode = resource.getString("iFSCCode");
String branch = resource.getString("branch");
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

<!-- Custom CSS -->
<!-- <link href="css/simple-sidebar.css" rel="stylesheet"> -->
<script src="<c:url value="/resources/js/jsvalidations.js" />"></script>
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

tr td {
	padding: 5px;
}

.row {
	width: 99%;
}

.error {
	color: red;
}
</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('#accountNumber').keyup(
						function() {
							$('span.error-keyup-1').hide();
							var a = /[~!@#$%^&*(){}|?a-zA-Z]/;
							var accountNumber = $('#accountNumber').val();
							if (a.test(accountNumber)) {
								$('#erroracNo').html("only numbers").show();
								return false;
							} else if (accountNumber < 0) {
								$('#erroracNo').html(
										"account number cannot be negative")
										.show();
								return false;
							} else if (accountNumber != 16) {
								$('#erroracNo').html(
										"account number must be of length 16")
										.show();
							}
						});

				$('#accountName').keyup(function() {
					$('span.error-keyup-2').hide();
					var a = /[~!@#$%^&*(){}|?0-9]/;
					var accountName = $('#accountName').val();
					if (a.test(accountName)) {
						$('#erroracNm').html("only characters").show();
						return false;
					}
				});

				$('#bankName').keyup(function() {
					$('span.error-keyup-3').hide();
					var a = /[~!@#$%^&*(){}|?0-9]/;
					var bankName = $('#bankName').val();
					if (a.test(bankName)) {
						$('#errorbnkNm').html("only characters").show();
						return false;
					}
				});

				$('#iFSCCode').keyup(
						function() {
							$('span.error-keyup-4').hide();
							var a = /[~!@#$%^&*(){}|?]/;
							var iFSCCode = $('#iFSCCode').val();
							if (a.test(iFSCCode)) {
								$('#errorcode').html(
										"only alphanumeric characters").show();
								return false;
							}
						});
				$('#branch').keyup(function() {
					$('span.error-keyup-5').hide();
					var a = /[~!@#$%^&*(){}|?0-9]/;
					var branch = $('#branch').val();
					if (a.test(branch)) {
						$('#errorbranch').html("only characters").show();
						return false;
					}
				});

				$('#bankAccountForm').click(
						function() {
							$('span.error-keyup-1').hide();
							var accountNumber = $('#accountNumber').val();
							if (accountNumber.length == 0) {
								$('#erroracNo').html(
										"account number cannot be empty")
										.show();
								return false;
							}
							$('span.error-keyup-2').hide();
							var accountName = $('#accountName').val();
							if (accountName.length == 0) {
								$('#erroracNm').html(
										"account name cannot be empty").show();
								return false;
							}

							$('span.error-keyup-3').hide();
							var bankName = $('#bankName').val();
							if (bankName.length == 0) {
								$('#errorbnkNm').html(
										"bank name cannot be empty").show();
								return false;
							}
							$('span.error-keyup-4').hide();
							var iFSCCode = $('#iFSCCode').val();
							if (iFSCCode.length == 0) {
								$('#errorcode').html(
										"IFSC Code cannot be empty").show();
								return false;
							}
							$('span.error-keyup-5').hide();
							var branch = $('#branch').val();
							if (branch.length == 0) {
								$('#errorbranch')
										.html("branch cannot be empty").show();
								return false;
							}
						});
			});
</script>
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

			<c:if test="${empty bankAccount.accountNumber }">
				<spring:url value="/${sessionScope.designation}/Bank/addBankAccount"
					var="addbankaccount"></spring:url>
			</c:if>
			<c:if test="${!empty bankAccount.accountNumber }">
				<spring:url
					value="/${sessionScope.designation}/Bank/updateBankAccount"
					var="addbankaccount"></spring:url>

			</c:if>
			<div class="container">
            <div class="jumbotron">
			<form:form action="${addbankaccount}" name="BankAccount"
				method="post" modelAttribute="bankAccount" id="bankAccountForm">
				<center><h3><%=accountDetails %></h3></center>
				<table cellpadding="2" align="center" cellspacing="2">
					
					<tr>
						<td></td>
						<td></td>
						<td><span class="error error-keyup-1" id="erroracNo"><form:errors
									path="accountNumber" cssClass="error"></form:errors></span></td>
					</tr>
					<tr>
						<td><%=accountNumber %></td>
						<td>:</td>
						<td><form:input path="accountNumber" id="accountNumber"
								name="accountNumber" class="form-control" maxlength="16" /></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td><span class="error error-keyup-2" id="erroracNm"><form:errors
									path="accountName" cssClass="error"></form:errors></span></td>
					</tr>
					<tr>
						<td><%=accountName %></td>
						<td>:</td>
						<td><form:input path="accountName" id="accountName"
								name="accountName" class="form-control" maxlength="100" /></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td><span class="error error-keyup-3" id="errorbnkNm"><form:errors
									path="bankName" cssClass="error"></form:errors></span></td>
					</tr>
					<tr>
						<td><%=bankName %></td>
						<td>:</td>
						<td><form:input path="bankName" id="bankName" name="bankName"
								class="form-control" maxlength="80" /></td>
					</tr>

					<tr>
						<td></td>
						<td></td>
						<td><span class="error error-keyup-4" id="errorcode"><form:errors
									path="iFSCCode" cssClass="error"></form:errors></span></td>
					</tr>
					<tr>
						<td><%=iFSCCode %></td>
						<td>:</td>
						<td><form:input path="iFSCCode" id="iFSCCode" name="iFSCCode"
								class="form-control" maxlength="11" /></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td><span class="error error-keyup-5" id="errorbranch"><form:errors
									path="branch" cssClass="error"></form:errors></span></td>
					</tr>
					<tr>
						<td><%=branch %></td>
						<td>:</td>
						<td><form:input path="branch" id="branch" name="branch"
								class="form-control" maxlength="80" /></td>
					</tr>


					<tr>
						<td><input type="submit" value="Submit" name="submit"
							class="btn btn-primary"></td>

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
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

<%-- <link rel="stylesheet"
    href="<c:url value="/resources/css/dataTables.bootstrap.min.css" />">
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
    rel="stylesheet">
<link href="<c:url value="/resources/css/landing-page.css" />"
    rel="stylesheet">

<script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>
<script src="<c:url value="/resources/js/dataTables.bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script>
    $(document).ready(function() {
        $('#example').DataTable();
    });
</script> --%>

<link href="<c:url value="/resources/css/landing-page.css" />"
    rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>

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

.table {
	table-layout: fixed;
	word-wrap: break-word;
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
			<div class="row">
				<div class="container">
					<div class="jumbotron">
						<br /> <br />
						<c:if test="${!empty status}">
							<center>${status}</center>

						</c:if>
						<table id="example" class="table table-hover table-bordered"
							cellspacing="1" width="100%">
							<thead>
								<tr>
									<th>Employee Id</th>
									<th>Name</th>
									<th>Gender</th>
									<th>Email</th>
									<th>Contact NO.</th>
									<th>Department Id</th>
									<th>Designation Id</th>
									<th>Manager Id</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Employee Id</th>
									<th>Name</th>
									<th>Gender</th>
									<th>Email</th>
									<th>Contact NO.</th>
									<th>Department Id</th>
									<th>Designation Id</th>
									<th>Manager Id</th>
									<th>Delete</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${requestScope.employees}" var="employee">
									<tr>
										<td>${employee.employeeId}</td>
										<td>${employee.name}</td>
										<td>${employee.gender}</td>
										<td>${employee.email}</td>
										<td>${employee.contactNumber}</td>
										<td>${employee.departmentId}</td>
										<td>${employee.designationId}</td>
										<td>${employee.managerId}</td>
										<td><a
											href="<spring:url value="/${sessionScope.designation}/Manage Employee/delete/${employee.employeeId}"></spring:url>">
												<button type="button" class="btn btn-primary btn-md">
													Delete</button>
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
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
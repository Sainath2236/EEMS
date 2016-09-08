<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ page import = "java.util.ResourceBundle" %> 
<% ResourceBundle resource = ResourceBundle.getBundle("webcontent"); 

String employeeId = resource.getString("employeeId");
String name = resource.getString("name");
String password = resource.getString("password");
String confirmPassword = resource.getString("confirmPassword");
String gender = resource.getString("gender");
String dob = resource.getString("dob");
String emailId = resource.getString("emailId");
String department = resource.getString("department");
String designation = resource.getString("designation");
String contactNumber = resource.getString("contactNumber");
String registration = resource.getString("registration");
String register = resource.getString("register");
String reset = resource.getString("reset");
%>
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
<script src="<c:url value="/resources/js/jsvalidations.js" />"></script>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<spring:url value="/checkemail?email=" var="checkemail"></spring:url>
<spring:url value="/checkemployeeId?employeeId=" var="checkemployeeId"></spring:url>
<style>
tr td {
	padding: 5px;
}

tr td {
	padding: 3px;
}

.row {
	width: 50%;
}
</style>
<style>
.error {
	color: red;
}

.span {
	color: red;
}
</style>
<c:url value="/resources/img/bg.jpg" var="bgimage"></c:url>
</head>
<body style="width: 100%;background-image: url('${bgimage}');background-repeat:no-repeat;background-size:cover;">
	<jsp:include page="headerBeforeLogin.jsp"></jsp:include>
	<script>
		/* $(document).ready(function() {
		
			  $('#registration').click(
					  function() {
						  var c = "";
		                    $('span.error-keyup-1').hide();
		                    var employeeId = $('#employeeId')
		                            .val();
		                    if (employeeId.length == 0) {
		                        $('#employeeIdspan')
		                                .html(
		                                        "Employee id cannot be empty")
		                                .show();
		                        c += "1";
		                    }
		                    $('span.error-keyup-2').hide();
		                    var name = $('#name').val();
		                    if (name.length == 0){
		                        $('#namespan').html(
		                                "name cannot be empty")
		                                .show();
		                        c += "1";
		                    }
		                     
		                    $('span.error-keyup-4').hide();
		                    var email = $('#email').val();
		                    if (email.length == 0) {
		                        $('#emailspan')
		                                .html(
		                                        "email id cannot be empty")
		                                .show();
		                        c += "1";
		                    }
		                    $('span.error-keyup-5').hide();
		                    var password = $('#password').val();
		                    if (password.length == 0) {
		                        $('#passwordspan')
		                                .html(
		                                        "password cannot be empty")
		                                .show();
		                        c += "1";
		                    }
		                    $('span.error-keyup-6').hide();
		                    var cpassword = $(
		                            '#confirmPassword').val();
		                    if (cpassword.length == 0) {

		                        $('#confirmPasswordspan')
		                                .html(
		                                        "confirm password cannot be empty")
		                                .show();
		                        c += "1";
		                    } else if (password != cpassword) {
		                        $('#confirmPasswordspan')
		                                .html(
		                                        "passwords do not match")
		                                .show();
		                        c += "1";
		                    }
		                    $('span.error-keyup-7').hide();
		                    var contactNumber = $(
		                            '#contactNumber').val();
		                
		                    if (contactNumber.length == 0) {
		                        $('#contactNumberspan')
		                                .html(
		                                        "contact number cannot be empty")
		                                .show();
		                        c += "1";
		                    }
		                    $('span.error-keyup-8').hide();
		                    var dob = $('#dob').val();
		                    if (dob.length == 0) {
		                        $('#dobspan').html(
		                                "dob cannot be empty")
		                                .show();
		                        c += "1";
		                    }
		                    $('span.error-keyup-9').hide();
		                    var department = $('#departmentId').val();
		                    if (department == '0') {
		                        $('#departmentIdspan').html(
		                                "department is not selected")
		                                .show();
		                        c += "1";
		                    }
		                     $('span.error-keyup-10').hide();
		                        var designation = $('#designationId').val();
		                        if (designation == '0') {
		                            $('#designationIdspan').html(
		                                    "designation is not selected")
		                                    .show();
		                            c += "1";
		                        }
		                         $('span.error-keyup-3').hide();
		                        var gender = $('input[name=gender]:checked').val();
		                        if (typeof gender ==='undefined'){
		                            $('#genderspan').html(
		                                    "gender should be selected")
		                                    .show();
		                            c += "1"; 
		                        } 
		                        
		                        if(c.length != 0) {
		                        	return false;
		                        } else {
		                        	return true;
		                        }
		                }); 
			  
			  
			  
			  
		
		
		
		
		
		}); */

		$(document)
				.ready(
						function() {
							$('#employeeId')
									.keyup(
											function() {
												$('span.error-keyup-1').hide();
												var a = /[~!@#$%^&*(){}.|?a-zA-Z]/;
												var employeeId = $(
														'#employeeId').val();

												if (a.test(employeeId)) {
													$('#employeeIdspan').html(
															"numbers only")
															.show();
												} else if (employeeId.length != 7) {
													$('#employeeIdspan')
															.html(
																	"Id must be 7 digits.")
															.show();
												} else if (employeeId.length == 7) {
													checkemployeeId(
															"${checkemployeeId}",
															'employeeId');
												}

											});

							$('#name').keyup(
									function() {
										$('span.error-keyup-2').hide();
										var name = $('#name').val();
										var b = /[~!@#$%^&*(){}|?0-9]/;
										if (b.test(name)) {
											$('#namespan').html(
													"characters only").show();
										}
									});

							$('#email')
									.keyup(
											function() {
												$('span.error-keyup-4').hide();
												var email = $('#email').val();
												var a = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
												if (!a.test(email)) {
													$('#emailspan')
															.html(
																	"invalid email format")
															.show();
												}

												if (a.test(email)) {
													checkEmail("${checkemail}",
															'email');
												}

											});

							$('#password')
									.keyup(
											function() {
												$('span.error-keyup-5').hide();
												var pass = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{10}$/;
												var password = $('#password')
														.val();
												if (!pass.test(password)) {
													$('#passwordspan')
															.html(
																	"Password should contain atlest lower,upper case and a number with length 10")
															.show();
												}

											});

							$('#confirmPassword').keyup(
									function() {
										$('span.error-keyup-6').hide();
										var password = $('#password').val();
										var cpassword = $('#confirmPassword')
												.val();
										if ((password != (cpassword))) {
											$('#confirmpasswordspan').html(
													"password does not match")
													.show();
										}

									});

							$('#contactNumber')
									.keyup(
											function() {
												$('span.error-keyup-7').hide();

												var contactNumber = $(
														'#contactNumber').val();
												var a = /[~!@#$%^&*(){}|?a-zA-Z]/;
												if (a.test(contactNumber)) {
													$('#contactNumberspan')
															.html(
																	"numbers only")
															.show();
												} else if (contactNumber.length != 10) {
													$('#contactNumberspan')
															.html(
																	"contact number must be of length 10")
															.show();
												}
											});

							$('#dob')
									.keyup(
											function() {
												$('span.error-keyup-8').hide();
												var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
												var date = $('#dob').val();
												if (date.match(dateformat)) {
													var seperator1 = date
															.split('/');
													var seperator2 = date
															.split('-');

													if (seperator1.length > 1) {
														var splitdate = date
																.split('/');
													} else if (seperator2.length > 1) {
														var splitdate = date
																.split('-');
													}
													var dd = parseInt(splitdate[0]);
													var mm = parseInt(splitdate[1]);
													var yy = parseInt(splitdate[2]);
													var ListofDays = [ 31, 28,
															31, 30, 31, 30, 31,
															31, 30, 31, 30, 31 ];
													if (mm == 1 || mm > 2) {
														if (dd > ListofDays[mm - 1]) {
															$('#dobspan')
																	.html(
																			"invalid date")
																	.show();
															return false;
														}
													}
													if (mm == 2) {
														var lyear = false;
														if ((!(yy % 4) && yy % 100)
																|| !(yy % 400)) {
															lyear = true;
														}
														if ((lyear == false)
																&& (dd >= 29)) {
															$('#dobspan')
																	.html(
																			"invalid date")
																	.show();
															return false;
														}
														if ((lyear == true)
																&& (dd > 29)) {
															$('#dobspan')
																	.html(
																			"invalid date")
																	.show();
															return false;
														}
													}
												} else {
													$('#dobspan').html(
															"invalid date")
															.show();

													return false;
												}
											});

						});
	</script>


	<br>
	<br>
	<br>
	<div class="container">
	<div class="jumbotron">
		<c:if test="${!empty requestScope.status}">
			<center>
				<h4>
					<font color="Red"> ***${requestScope.status}*** </font>
				</h4>
			</center>
		</c:if>
		<form:form action="register" name="EmployeeRegistration" method="post"
			modelAttribute="employee" commandName="employee" id="registration">
			<table cellpadding="1" align="center" cellspacing="1"
				border-collapse: collapse>
				<tr>
					<td><h2><%= registration%></h2></td>

				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><span class="error error-keyup-1" id="employeeIdspan"><form:errors
								path="employeeId" cssClass="error"></form:errors></span></td>
					<td></td>
				</tr>
				<tr>
					<td><%=employeeId %></td>
					<td>:</td>
					<td><form:input path="employeeId" id="employeeId"
							class="form-control" size="7" maxlength="7"
							placeholder="Employee Id" /></td>
					<td><span id="employeeIdCheck"></span></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><span class="error error-keyup-2" id="namespan"><form:errors
								path="name" cssClass="error"></form:errors></span></td>
					<td></td>
				</tr>
				<tr>
					<td><%=name%></td>
					<td>:</td>
					<td><form:input path="name" id="name" class="form-control"
							size="40" maxlength="100" placeholder="Name" /></td>

					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><span class="error error-keyup-3" id="genderspan"><form:errors
								path="gender" cssClass="error"></form:errors></span></td>
					<td></td>
				</tr>
				<tr>
					<td><%=gender %></td>
					<td>:</td>
					<td><form:radiobuttons path="gender" items="${genders}"
							id="gender" /></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><span class="error error-keyup-4" id="emailspan">
						<form:errors
                                path="email" cssClass="error"></form:errors></span></td>
					<td></td>
				</tr>
				<tr>
					<td><%=emailId %></td>
					<td>:</td>
					<td><form:input path="email" id="email" class="form-control"
							size="25" maxlength="25" placeholder="example@email.com" /></td>
					<td><span id="emailCheck"></span></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><span class="error error-keyup-5" id="passwordspan"><form:errors
								path="password" cssClass="error"></form:errors></span></td>
					<td></td>
				</tr>
				<tr>
					<td><%=password %></td>
					<td>:</td>
					<td><form:password path="password" id="password"
							class="form-control" size="10" maxlength="10"
							placeholder="Password" /></td>
					<td></td>
				</tr>

				<tr>
					<td></td>
					<td></td>
					<td><span class="error error-keyup-6" id="confirmpasswordspan"></span></td>
					<td></td>
				</tr>
				<tr>
					<td><%=confirmPassword %></td>
					<td>:</td>
					<td><input type="password" name="confirmPassword"
						id="confirmPassword" class="form-control" maxlength="10" size="10"
						placeholder="Confirm Password" /></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><span class="error error-keyup-7" id="contactNumberspan"><form:errors
								path="contactNumber" cssClass="error"></form:errors></span></td>
					<td></td>
				</tr>
				<tr>
					<td><%=contactNumber %></td>
					<td>:</td>
					<td><form:input path="contactNumber" id="contactNumber"
							class="form-control" size="10" maxlength="10"
							placeholder="Contact Number" /></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><span class="error error-keyup-8" id="dobspan"><form:errors
								path="dob" cssClass="error"></form:errors></span></td>
					<td></td>
				</tr>
				<tr>
					<td><%=dob %></td>
					<td>:</td>
					<td><form:input path="dob" id="dob" class="form-control"
							placeholder="DD/MM/YYYY" /></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><span class="error error-keyup-9" id="departmentIdspan"><form:errors
								path="departmentId" cssClass="error"></form:errors></span></td>
					<td></td>
				</tr>
				<tr>
					<td><%=department %></td>
					<td>:</td>
					<td><form:select path="departmentId" items="${departments }"
							id="departmentId" multiple="false" class="form-control" /></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><span class="error error-keyup-10" id="designationIdspan"><form:errors
								path="designationId" cssClass="error"></form:errors></span></td>
					<td></td>
				</tr>
				<tr>
					<td><%=designation %></td>
					<td>:</td>
					<td><form:select path="designationId" items="${designations }"
							id="designationId" multiple="false" class="form-control" /></td>
				</tr>
				<tr>
					<td align="right"><input type="submit" value="<%=register %>"
						name="Register" class="btn btn-primary"></td>
					<td></td>
					<td><input type="reset" value="<%=reset %>" name="Reset"
						class="btn btn-warning" align="center"></td>
				</tr>

			</table>
		</form:form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		/* $("#email").keyup(function() {
			checkEmail("${checkemail}", 'email');
		});
		$("#employeeId").keyup(function() {
		    checkEmail("${checkemployeeId}", 'employeeId');
		}); */
		function checkEmail(url1, idval) {
			var email = "";
			email = document.getElementById(idval).value;
			console.log(email);
			$
					.ajax({
						type : "GET",
						contentType : "application/json",
						url : url1 + email,
						success : function(data) {
							console.log("SUCCESS: ", data);
							if (data != "") {
								console.log("successly retrieved");
								document.getElementById("emailCheck").innerHTML = "email is unavailable, choose other";
							} else {
								console.log("successly not retrieved");
								document.getElementById("emailCheck").innerHTML = "email is available";
							}

						}
					});
		}

		function checkemployeeId(url2, idval) {
			var employeeId = "";
			employeeId = document.getElementById(idval).value;
			console.log(employeeId);
			$
					.ajax({
						type : "POST",
						contentType : "application/json",
						url : url2 + employeeId,
						success : function(data) {
							console.log("SUCCESS: ", data);
							if (data != "") {
								console.log("successly retrieved");
								document.getElementById("employeeIdCheck").innerHTML = "Id is unavailable, choose other";
							} else {
								console.log("successly not retrieved");
								document.getElementById("employeeIdCheck").innerHTML = "Id is available";
							}

						}
					});
		}
	</script>
</body>
</html>
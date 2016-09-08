<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import = "java.util.ResourceBundle" %> 
<% ResourceBundle resource = ResourceBundle.getBundle("webcontent");
String projectName = resource.getString("projectName");
String home = resource.getString("home");
String logout = resource.getString("logout");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/landing-page.css" />" rel="stylesheet">
<style type="text/css">

#header{
    background-color: #337ab7;
}
</style>
</head>
<body>
<!-- Navigation -->
   <nav class="navbar navbar-default navbar-fixed-top topnav"
        role="navigation" id="header">
    <div class="container topnav">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <b class="navbar-brand topnav" style="color: white; "><%=projectName %></b>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
            id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a
                    href="<spring:url value="/${sessionScope.designation}/home"></spring:url>" style="color: white;"><%=home %></a></li>
                <li><a
                    href="<spring:url value="/${sessionScope.designation}/logout"></spring:url>" style="color: white;"><%=logout %></a></li>
                <li><a href="#" style="color: white;">${sessionScope.employee.name}</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
        <!-- /.container -->
    </nav>
</body>
</html>
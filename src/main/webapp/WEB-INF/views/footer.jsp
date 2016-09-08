<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import = "java.util.ResourceBundle" %> 
<% ResourceBundle resource = ResourceBundle.getBundle("webcontent");
String copyRight = resource.getString("copyRight");

%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

#footer {
    position: fixed;
    left: 0px;
    bottom: 0px;
    height: 47px;
    background-color: #337ab7;
    text-align: center;
    width: 100%;
}
</style>
</head>
<body>
	<div id="footer">

		<p class="copyright text-muted small" style="color: white;"><%=copyRight %> </p>

	</div>
</body>
</html>
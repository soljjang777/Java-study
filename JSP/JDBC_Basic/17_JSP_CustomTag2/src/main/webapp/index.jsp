<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/unit.css">
<link rel="stylesheet" href="css/bmi.css">
<link rel="stylesheet" href="css/reg.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/unit.js"></script>
<script type="text/javascript" src="js/bmi.js"></script>
</head>
<body>

	<table id="site">
	<tr>
		<td align="right"> <jsp:include page="${loginPage}"></jsp:include> </td>
	</tr>
	<tr>
		<td id="title">Sr's Website</td>
	</tr>
	<tr>
		<td id="menu"> 
		<a href="AController">A</a> 
		<a href="BController">B</a>
		<a href="UnitController">Unit</a> 
		<a href="BmiController">BMI</a>  
		</td>
	</tr>
	<tr>
		<td> <jsp:include page="${contentPage}"></jsp:include> </td>
	</tr>
	</table>



</body>
</html>
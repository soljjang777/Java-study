<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>

	<table id="siteTitle">
	<tr>
		<td align="center"> <a href="HC">SR's Home</a> </td>
	</tr>
	</table>
	
	<table id="siteContent">
	<tr>
		<td align="center"> <jsp:include page="${contentPage }"></jsp:include> </td>
	</tr>
	</table>
	
	<table id="siteMenu">
	<tr>
		<td> <a href="JSTLC">JSTL-Core</a> </td>
		<td> <a href="JSTL_FC">JSTL-Format</a> </td>
	</tr>
	</table>
	
</body>
</html>
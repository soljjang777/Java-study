<%@page import="com.sr.main.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body>
	<%
	Result r = (Result) request.getAttribute("re");
	%>
	<table>
		<tr>
			<td style="background-color: #F4A442; color: white;" colspan="2">BMI검사</td>
		</tr>
		<tr>
			<td id="td1">이름</td>
			<td><%=r.getName()%></td>
		</tr>
		<tr>
			<td id="td1">사진</td>
			<td><img src="img/<%=r.getSa()%>" width="50px;"></td>
		</tr>
		<tr>
			<td id="td1">키</td>
			<td><%=r.getHeight()%></td>
		</tr>
		<tr>
			<td id="td1">체중</td>
			<td><%=r.getWeight()%></td/>
		</tr>
		<tr>
			<td id="td1">bmi수치</td> <
			<td><%=r.getBmi()%></td>
		</tr>
		<tr>
			<td id="td1">결과</td> <
			<td><%=r.getResult()%></td>
		</tr>
	</table>
</body>
</html>
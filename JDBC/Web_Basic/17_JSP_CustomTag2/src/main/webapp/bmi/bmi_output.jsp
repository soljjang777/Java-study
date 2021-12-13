<%@page import="com.sr.bmi.Result"%>
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

	<table id="BmiTbl">
		<tr>
			<td style="background-color: #F4A442; color: white;" colspan="2">BMI검사</td>
		</tr>
		<tr>
			<td id="td1">이름</td>
			<td>${re.name}</td>
		</tr>
		<tr>
			<td id="td1">사진</td>
			<td><img src="img/${re.sa}" width="50px;"></td>
		</tr>
		<tr>
			<td id="td1">키</td>
			<td>${re.height}</td>
		</tr>
		<tr>
			<td id="td1">체중</td>
			<td>${re.weight}</td>
		</tr>
		<tr>
			<td id="td1">bmi수치</td> 
			<td>${re.bmi}</td>
		</tr>
		<tr>
			<td id="td1">결과</td> 
			<td>${re.result}</td>
		</tr>
	</table>
</body>
</html>
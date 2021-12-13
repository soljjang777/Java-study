<%@page import="com.sr.unit.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table id="unitTbl">
		<tr>
			<td><div id="main"><h1>단위변환</h1></div></td>
		</tr>
		<tr>
			<td>
			변환할 값(${rr.dan}) <p> ${rr.in} <span class= "${rr.cn}2"> (${danwi3})</span>
			</td>
		</tr>
		<tr>
			<td>
			변환된 값 <p> ${rr.result2 } <span class="${rr.cn}2">(${rr.danwi2})</span>
			</td>
		</tr>
		<tr>
			<td>
			<button onclick="location.href='UnitController'" style="cursor:pointer;">돌아가기</button>
			</td>
		</tr>
	</table>
</body>
</html>
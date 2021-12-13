<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전체조회 결과</h1>
<table border="1">
<tr>
	<td>이름</td>
	<td>나이</td>
</tr>
<c:forEach var="ng" items="${nameage}">
<tr>
	<td>${ng.name}</td>
	<td>${ng.age}</td>
</tr>
</c:forEach>

</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Third</h1>

	파라미터 : ${param.a} <p>
	어트리뷰터 : ${b} <p>
	
	
	<h2>세션 : ${sessionScope.c}</h2>
	<h2>쿠키 : ${cookie.d.value}</h2>
</body>
</html>
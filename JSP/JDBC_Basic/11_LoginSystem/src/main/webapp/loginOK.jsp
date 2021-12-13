<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${r}
${sessionScope.accountinfo.name}님 방가방가!햄토리! <p>
<button onclick="location.href='LoginController'">로그아웃</button>
</body>
</html>
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
${sessionScope.accountInfo.name}님 방가방가!햄토리! <p>
<button class="loginBtn"  onclick="location.href='InfoAccountC'">회원정보</button>
<button class="loginBtn" onclick="location.href='LoginController'">로그아웃</button>
</body>
</html>
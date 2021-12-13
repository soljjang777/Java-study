<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	jsp (java servelet page)
	
	HTML베이스에데가 자바코드를 넣는 형태로 작업 -> 서블릿 노가다보다 작업이 편해짐.
	톰캣이 Servlet으로 바꿔서 실행
 -->
 
 <%
 	int a = 10 + 20;
 
 %>
  <h1> <%=a %> </h1>
  
</body>
</html>
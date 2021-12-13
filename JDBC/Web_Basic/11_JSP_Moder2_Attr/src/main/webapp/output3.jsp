
<%@page import="com.sr.hc.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
 String how = request.getParameter("how");
 
%>
<%=how%>원 모지랍니다 <p>
<%=request.getAttribute("how2")%>원 모지랍니다

</body>
</html>
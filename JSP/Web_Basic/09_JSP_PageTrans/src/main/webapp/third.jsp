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
int a = Integer.parseInt(request.getParameter("a"));
int b = Integer.parseInt(request.getParameter("b"));

	// 정석
	Object c =	request.getAttribute("ccc");
	Integer c2 =  (Integer) c;
	int c3 = c2.intValue();
	
	// 오토 박싱, 언박싱
	Object o = request.getAttribute("ccc");
	int o2 = (Integer)o;
	
	// 위에꺼 한줄로 쓴거
	int ccc = (Integer)request.getAttribute("ccc");
%>
<h1>Third Page</h1>
<%=a %>
<%=b %>
<%=ccc %>
<%=c %>
</body>
</html>
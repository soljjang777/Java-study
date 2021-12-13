<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
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
	int c = a + b;
	/*
	값
	(1). parameter
	html 에서 만든 값
	그 자료형 String, String[]
	그런 값이 request객체에 실려서 전송

	second에서 만든 c를 thrid로 가져가고싶음
	
	(2). attribute
	java에서 만든 값
	Object(객체)면 다됨 
	request객체에 실려서 전송
	*/	
	request.setAttribute("ccc", c);
	
	
	/*
	// 자동이동 시리즈 3개
	1. redirect 
	// response.sendRediredct("third.jsp");
	
	2. forward
	// first에서 second로 넘어올 때 요청한 정보를 third까지 넘거줌
	*/
	RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
	rd.forward(request, response);
	
	// forward를 많이 쓰는데 first 에서 second로 넘어온 request까지 third로 보내줌.
	// redirect는 그냥 넘기는거
	// forward는 request에 값이 실려서 넘어오는건데 그 request를 같이 넘기닌까 third가 그 값 쓸 수 없음.
	
	//3. include ( 어떤 jsp속에 다른 jsp포함)
		//include : 위치조절이 안됨(무조건 제일 위에)
		// 관심이 없고 나중에 위치조절이 되는 다른 include있음
//	rd.include(request,response)
	%>
	<h1>Second Page</h1>
	<%=c%>
<% // rd.include(request, response); %>
</body>
</html>
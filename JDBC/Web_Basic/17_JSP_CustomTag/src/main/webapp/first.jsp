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
	.jsp에 자바를 쓰려는 경우
	1. 값을 일으려고 - EL로 해결
	
	------------ CustomTag로 해결 -------------
	2. 출력형식 떼문에
	3. 조건문, 반목문
	4. 이동하려고
	
	CustomTag
	- DOM객체 모양(html) - 실행 때 자바코드 바뀌어서 실행
	- .jsp 여기서만 
	
	<접두어 : xxx></접두어 : xxx>
	
	CustomTag는 2종류
	1. JSP 표준 액션 태그(정품)
		.jsp에서 기본적으로 쓸 수 있음.
	2. jstl(사제)
	
 -->
 <%//request.getRequestDispatcher("second.jsp").include(request, response); %>
 <h1>First</h1>
 redirect는 표준 액션태그에 없음.forward로 처리
 <jsp:include page="second.jsp"></jsp:include>
 
 
 
 
</body>
</html>
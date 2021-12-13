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
	//Result r = (Result) request.getAttribute("rr");
	//.jsp에 자바를 쓰는 경우
	//	값을 읽을려고
	//  출력형식 때문에
	//	조건문, 반복문

	//EL(Expresstion Language)
	// 	값 읽을때
	//	연산자 사용 가능
	//	import  없어도 됨
	//	값이 없으면 넘어감

	//EL로 - Parameter 읽기 : ${param.이름}
	//    - Attribute 읽기 : ${어트리뷰트 이름}
	//    - 객체    		  : ${이름.맴버변수}	
	
	//기본형[] or ArrayList<기본형> : ${이름[번호]}
	//		객체 []  : ${이름[번호].멤버변수}
	%>

<%--  	이름 : <%=request.getParameter("n")%>
	<br> 중간 :<%=request.getParameter("mid")%>
	<br> 기말 :<%=request.getParameter("last")%>
	<br> 평균 :<%=r.getAvg2()%>
	<br> 등급 :<%=r.getGrade()%>
	<br>
--%>	
	<hr>
	이름 : ${param.n}
	<br> 중간 : ${param.mid}
	<br> 기말 : ${rr.last}
	<br> 평균 : ${rr.avg2}
	<br> 등급 : ${rr.grade}
	<br>
	<hr>
	a : ${a} <br>
	b : ${b} <br>
	c : ${c[1]}
	<hr>
	d1 : ${d[0].name} <br>
	d2 : ${d[1].grade} 
	<hr>
	e1 : ${e[0].name} <br>
	e2 : ${e[1].name} <br>
	e3 : ${e[2].name}


</body>
</html>
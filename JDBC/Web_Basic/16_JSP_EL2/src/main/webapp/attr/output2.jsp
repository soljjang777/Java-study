<%@page import="com.sr.attr.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<table>
			<tr>
				<td>상품 가격 : ${rr.price}  </td>
			</tr>
			<tr>
				<td>지불한 돈 : ${rr.money} </td>
			</tr>
			<tr>
				<td>잔돈 : ${rr.exchange} </td>
			</tr>	
			<tr>
				<td>맨트 : ${rr.say} </td>
			</tr>									
		</table>
------------------------------------------- <p>		
	버튼을 눌렀을 때 output2.jsp	 <p>
	1. 모자를 때만 나오게 <p>
	2. 모자른 금액을 안내 <p>


<c:if test="${rr.exchange < 0}">
	<a href="attr/output3.jsp?how=${rr.price-rr.money}"> <button>0.얼마모지란데요?(a로 겟요청)</button></a>
	<form action="attr/output3.jsp" method="post">
	<button name="how" value="${rr.exchange * -1}">1.얼마 모자른데요?(뷰로 요청)</button>
	</form>
	
	<form action="ExController" method="post">
	<button name="how" value="${rr.exchange * -1}">2.얼마 모자른데요?(컨트롤로 요청-뷰에서 계산)</button>
	</form>
	
	<form action="ExController" method="post">
	<button name="how" value="${ex2}">3.얼마 모자른데요?(컨트롤로 요청-모델이계산(포스트))</button>
	</form>
	
	<form action="ExController" method="get">
	<button name="how" value="${rr.exchange}">4.얼마 모자른데요?(컨트롤로 요청-모델이계산(겟))</button>
	</form>

	
</c:if>		

	

	



</body>
</html>
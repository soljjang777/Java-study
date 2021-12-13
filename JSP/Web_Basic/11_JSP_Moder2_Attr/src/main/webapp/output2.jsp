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
	Result r = (Result) request.getAttribute("rr");
%>
		<table>
			<tr>
				<td>상품 가격 : <%=r.getPrice()%> </td>
			</tr>
			<tr>
				<td>지불한 돈 : <%=r.getMoney() %> </td>
			</tr>
			<tr>
				<td>잔돈 : <%=r.getExchange()%> </td>
			</tr>	
			<tr>
				<td>맨트 : <%=r.getSay() %> </td>
			</tr>									
		</table>
------------------------------------------- <p>		
	버튼을 눌렀을 때 output2.jsp	 <p>
	1. 모자를 때만 나오게 <p>
	2. 모자른 금액을 안내 <p>

	<%if(r.getExchange() < 0){
		int how = r.getPrice() - r.getMoney();
		%> 
	<form action="output3.jsp" method="post">
	<button name="how" value="<%=how%>">1.얼마 모자른데요?(뷰로 요청)</button>
	</form>
	
	<form action="ExController" method="post">
	<button name="how" value="<%=how%>">2.얼마 모자른데요?(컨트롤로 요청-뷰에서 계산)</button>
	</form>
	
	<%} %>
	
		<%if(r.getExchange() < 0){
		int how = (Integer) request.getAttribute("ex2");
		%> 	
	<form action="ExController" method="post">
	<button name="how" value="<%=how%>">3.얼마 모자른데요?(컨트롤로 요청-모델이계산(포스트))</button>
	</form>
	
		<form action="ExController" method="get">
	<button name="how" value="<%=r.getExchange()%>">4.얼마 모자른데요?(컨트롤로 요청-모델이계산(겟))</button>
	</form>
	
	<%} %>	






</body>
</html>
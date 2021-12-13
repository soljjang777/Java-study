<%@page import="com.sr.main.Result"%>
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
				<td>상품가격 : <%=r.getPrice()%> </td>
			</tr>
			<tr>
				<td>지불한돈 : <%=r.getMoney() %>  </td>
			</tr>
			<tr>
				<td>모지란돈 : <%=r.getEx() %>  </td>
			</tr>
			<tr>
				<td>멘트 : <%=r.getSay() %>  </td>
			</tr>
			<tr>
	<%if(r.getEx() < 0){%>
		
	<form action="exc" method="post">			
		<td> <button name="jan" value="<%=r.getEx()%>">모지란돈얼마?</button> </td>
	<%}%>	
		</form>						
			</tr>
		</table>
</body>
</html>
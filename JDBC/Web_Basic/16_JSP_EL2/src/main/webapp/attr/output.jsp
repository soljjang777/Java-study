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

%>
		<table>
			<tr>
				<td>상품 가격 : <%=request.getParameter("p")%> </td>
			</tr>
			<tr>
				<td>지불한 돈 : <%=request.getParameter("m") %> </td>
			</tr>
			<tr>
				<td>잔돈 : <%=request.getAttribute("exchange") %> </td>
			</tr>	
			<tr>
				<td>맨트 : <%=request.getAttribute("say") %> </td>
			</tr>									
		</table>



</body>
</html>
<%@page import="com.mz.hc.Remain"%>
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
	Remain r = (Remain)request.getAttribute("re");
%>
	<table>
		<tr>
			<td>번돈 : <%=r.getE()%>
			</td>
		</tr>
		<tr>
			<td>쓴돈 : <%=r.getS()%>
			</td>
		</tr>
		<tr>
			<td>남은돈 : <%=r.getR()%>
			</td>
		</tr>
	</table>
</body>
</html>
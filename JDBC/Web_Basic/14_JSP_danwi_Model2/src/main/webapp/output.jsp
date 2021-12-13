<%@page import="com.sr.main.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body>
<%
	Result r = (Result) request.getAttribute("rr");
%>
	<table>
		<tr>
			<td><div id="main"><h1>단위변환</h1></div></td>
		</tr>
		<tr>
			<td>
			변환할 값(<%=r.getDan() %>) <p> <%=r.getIn() %> <span class=<%=r.getCn() %>2>(<%=request.getAttribute("danwi3") %>)</span>
			</td>
		</tr>
		<tr>
			<td>
			변환된 값 <p> <%=r.getResult2() %> <span class=<%=r.getCn()%>2>(<%=r.getDanwi2() %>)</span>
			</td>
		</tr>
		<tr>
			<td>
			<button>돌아가기</button>
			</td>
		</tr>
	</table>
</body>
</html>
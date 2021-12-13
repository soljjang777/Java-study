<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	public int getGob(int a, int b){
		return a*b;
	}
	
%>

<%
	//1. 값 받기
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	
	int hab = x + y;
	int cha = x - y;
	int cob = getGob(x,y);
	
	
	


%>
<!-- 
	현재 아래 결과가 나오고 있다.
	근데 합이 10이 넘었을 때만 저 결과가 나오게 하라
 -->
<h1>계산결과</h1>
<% if(hab > 10){ %>

<marquee><%=x %> + <%=y %> = <%=hab %></marquee> 
<marquee><%=x %> - <%=y %> = <%=cha %></marquee> 
<marquee><%=x %> * <%=y %> = <%= getGob(x,y) %></marquee> 
<marquee><%=x %> * <%=y %> = <%= cob %></marquee> 

<% } %>

</body>
</html>
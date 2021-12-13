<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
 int in = Integer.parseInt(request.getParameter("in"));
 String dan = request.getParameter("dan");
 
 double a = 0;
 double b = 0;
 double c = 0;
 double d = 0;
%>
<table>
<% 
	if(dan.equals("길이")){
		a = (double) in / 2.54;%>
		<tr>
			<td><div id="main"><h1 style="color: black;">단위변환</h1></div></td>
		</tr>
		<tr style="color: black;">
			<td>
			입력한 값<p>
<%=in %>(cm)	 <p>		
			변환된 값  <p>
		<%=String.format("%.1f",a)%> (inch)
		<%}else if(dan.equals("넓이")){
		b = (double) in * 0.3025;%>
		<tr>
			<td><div id="main"><h1 style="color: red;">단위변환</h1></div></td>
		</tr>
		<tr style="color: red;">
			<td>
			입력한 값  <p>
<%=in %>(평)	 <p>		
			변환된 값  <p>
		<%=String.format("%.1f",b)%> (평)
	<%}else if(dan.equals("온도")){
		c = (double) (in * 1.8) + 32; %>
		<tr>
			<td><div id="main"><h1 style="color: blue;">단위변환</h1></div></td>
		</tr>
		<tr style="color: blue;">
			<td>
			입력한 값  <p>
<%=in %>(℃)	 <p>		
			변환된 값  <p>
		<%=String.format("%.1f",c)%> (℉)
	<%}else if(dan.equals("속도")){
		d = (double) in * 0.621371;%>
		<tr>
			<td><div id="main"><h1 style="color: green;">단위변환</h1></div></td>
		</tr>
		<tr style="color: green;">
			<td>
			입력한 값  <p>
<%=in %>(km/h)	 <p>		
			변환된 값  <p>
		<%=String.format("%.1f",d)%> (mi/h) 	
 <%}%>		
			</td>
		</tr>
	</table>
</body>
</html>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		String path = request.getSession().getServletContext().getRealPath("img");
		System.out.println(path);
		
		MultipartRequest mr = new MultipartRequest(request, path, 
		30 * 1021 * 1024, "utf-8", new DefaultFileRenamePolicy());
		
		 String sa = mr.getFilesystemName("sa");
		 System.out.println(sa); 
		 String name = mr.getParameter("name");
		 int height = Integer.parseInt(mr.getParameter("height"));
		 int weight = Integer.parseInt(mr.getParameter("weight"));
		 double bmi = (weight) / ((height / 100) * (height / 100));
		 String result = "비만";
				 
		 if (bmi < 18.5) {
		    result = "저체중";
		 } else if (bmi < 23) {
		    result = "정상";
		 } else if (bmi >= 23 && bmi < 25) {
		    result = "과체중";
		 }
%>
	<table>
	<tr>
		<td style="background-color: #F4A442; color: white;" colspan="2">BMI검사</td>
	</tr>
	<tr>
		<td id="td1">사진</td>
		<td><img src="img/<%=sa%>"></td>
	</tr>
	<tr>
		<td id="td1">이름</td>
		<td><%=name%></td>
	</tr>
	<tr>
		<td id="td1">키</td>
		<td><%=height%></td>
	</tr>
	<tr>
		<td id="td1">체중</td>
		<td><%=weight%></td>
	</tr>
	<tr>
		<td>BMI</td>
		<td><%=String.format("%.2f",bmi)%></td>
	</tr>
	<tr>
		<td colspan="2" style="color: #FBD148">결과는 '<%=result%>'입니다!</td>
	</tr>
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/movie.css">
<link rel="stylesheet" href="css/review.css">
<script type="text/javascript" src="js/movie.js"></script>
<script type="text/javascript" src="js/review.js"></script>

</head>
<body>
	<table>
	<tr>
	<td class="siteMenu" align="center"> <a href="HC">홈</a> </td>
	<td class="siteMenu" align="center"> <a href="Menu2">[2]</a> </td>
	<td class="siteMenu" align="center"> <a href="Menu3">[영화정보]</a> </td>
	<td class="siteMenu" align="center"> <a href="Menu4">[영화후기]</a> </td>
	</tr>
	<tr>
		<td colspan="5">
			<table id="site">
			<tr>
				<td><jsp:include page="${contentPage}"></jsp:include></td> 
			</tr>
			</table>
		</td>	
	</tr>
	</table>
</body>
</html>
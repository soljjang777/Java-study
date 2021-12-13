<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="BmiController" enctype="multipart/form-data" method="post"
		onsubmit="return call();">
		<table id="BmiTbl">
			<tr>
				<td style="background-color: #F4A442; color: white;" colspan="2">BMI검사</td>
			</tr>
			<tr>
				<td id="td1">이름</td>
				<td><input name="name" placeholder="글자만입력해주세요(2자리이상)" id="i1"></td>
			</tr>
			<tr>
				<td id="td1">키</td>
				<td><input name="height" placeholder="숫자만입력하세요(3자리이상)" id="i2"></td>
			</tr>
			<tr>
				<td id="td1">체중</td>
				<td><input name="weight" placeholder="숫자만입력해주세요(2자리이상)" id="i3"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="sa"></td>
			</tr>
			<tr>
				<td colspan="2"><button>계산</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
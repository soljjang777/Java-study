<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UnitController" method="post" onsubmit="return call();">
	<table id="unitTbl">
		<tr>
			<td><div id="main"><h1>단위변환</h1></div></td>
		</tr>
		<tr>
			<td>
			변환할 값  <p>
			<input name="in" placeholder="숫자를 입력하세요" id="i1"> <p>
			단위  <p>
			<select name="dan">
			<option value="길이">cm → inch
			<option value="넓이">㎥ → 평
			<option value="온도">℃ → ℉
			<option value="속도">km/h → mi/h 
			</select><p>
			<button style='cursor:pointer'>변환</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
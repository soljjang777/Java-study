<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	20살이 넘으면 어서오세요
	20 미만이면 안녕
	
	저런거 하려면  if문 필요한데
	
	CustomTag
	1. JSP 표준액션태그(정품) : include
	
	2. CustomTag(사제품) : 말이 그렇다는거지 그냥 기본으로 생각
	 
	 JSTL(JSP Standard Tag Library)
	 .jar
	 
	 core - if, for
 -->


 <h1> 당신은 ${age}살입니다. </h1>
 <!-- 19살이 넘으면 '안녕하세요 -->
 <c:if test="${age > 19}">
 	<h1>안녕하세요</h1>
 </c:if>

 <!-- if, else if -->
 
<c:choose>
	<c:when test="${age > 19 }">
		<h1>어서오세요</h1>
	</c:when>
	<c:when test="${age > 9 }">
		<h1>안녕</h1>
	</c:when>
	<c:otherwise>
		<h1>안녕 아가야</h1>
	</c:otherwise>
</c:choose>

<hr>
	<!-- 단점 : 역순이 안됨 (step에 음수x) -->
<c:forEach var="a" begin="1" end="${age}" step="3">
 ${a}
</c:forEach> 
 <hr>
 
 <c:forEach var="c" items="${ar}">
 	${c}
 </c:forEach>
 <hr>
  
 <c:forEach var="m" items="${menus}">
 	${m.name}
 	${m.price}
 </c:forEach>
 
 <!--위에 저걸 테이블 구조에 잘 담으면 게시판 -->
 
 <table border="1">
 <tr>
 	<td>메뉴명</td>
 	<td>가격</td>
 </tr>
  <c:forEach var="m" items="${menus}">
 	<tr>
 	<td>${m.name}</td>
 	<td>${m.price}</td>
 	</tr>
 </c:forEach>
 </table>
 
 
 
 
</body>
</html>
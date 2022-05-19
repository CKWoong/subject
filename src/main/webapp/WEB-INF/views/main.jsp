<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>
		<h1>숫자를 한칸씩 띄어서 입력해주세요.</h1>
		<h2>EX > 30 45 70 90 55</h2>
		
	<form action="${contextPath}/selection" method="get">
		<br>
		<input type="text" name="select">	
		<input type="submit" value="Q01) 선택정렬">
	</form>
	
	<form action="${contextPath}/bubble" method="get">
		<br>
		<input type="text" name="bubb">		
		<input type="submit" value="Q01) 버블정렬">
	</form>
	
	<form action="${contextPath}/insertion" method="get">
		<br>
		<input type="text" name="insert">		
		<input type="submit" value="Q01) 삽입정렬">
	</form>
	
	<form action="${contextPath}/question02" method="get">
		<br>
		<input type="text" name="Q02">		
		<input type="submit" value="Q02) 탐색">
	</form>
	
	<form action="${contextPath}/coordinate" method="get">
		<h1>좌표는 아래의 예시와 같은 형식으로 입력해주세요.</h1>		
		<h2>EX > (2,6),(1,-1),(3,6),(-2,1),(1,3)</h2>
		<br>
		<input type="text" name="coord">		
		<input type="submit" value="Q01) 오름차순">
	</form>	
			
</body>
</html>
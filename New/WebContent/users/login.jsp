<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인</title>
</head>
<body>
<div class="container">
	<h1>${loginCheck }</h1>
	<c:choose>
		<c:when test="${not empty user_id }">
			<a href="../index.jsp">홈으로 가기</a>	
		</c:when>
		<c:otherwise>
			<a href="loginForm.jsp">로그인 하러 가기</a>
			<a href="../index.jsp">홈으로 가기</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>
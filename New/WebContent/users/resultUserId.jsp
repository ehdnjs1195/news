<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
<jsp:include page="${pageContext.request.contextPath }/include/navbar.jsp"/>
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${result }">
			<h1>찾는 아이디는 ${user_id } 입니다.</h1>
			<a href="loginForm.jsp">로그인 하러 가기</a>
			<a href="../index.jsp">홈으로 돌아가기</a>
		</c:when>
		<c:otherwise>
			<h1>아이디가 존재 하지 않습니다. 정보를 다시 입력해주세요.</h1>
			<a href="findUserId.jsp">아이디 찾기</a>
			<a href="../index.jsp">홈으로 돌아가기</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과</title>
<jsp:include page="${pageContext.request.contextPath }/include/navbar.jsp"/>
</head>
<body>
<h3> ${id } 님 가입이 완료되었습니다!</h3> 
<a href="loginForm.jsp">로그인 하기</a>
<a href="../index.jsp">홈으로 가기</a>
</body>
</html>
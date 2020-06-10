<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>404</h1>
	<p class="alert alert-danger">
		요청하신 페이지는 존재하지 않습니다.
		<a class="alert alert-link"  href="${pageContext.request.contextPath }/home.do">확인</a>
	</p>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<jsp:include page="${pageContext.request.contextPath }/include/navbar.jsp"/>
</head>
<body>
<div class="container">
	<h3>변경할 비밀번호를 입력하세요.</h3>
	<h3>${error }</h3>
	<form action="changeUserPwd.do" method="POST">
		비밀번호 입력: <input type="password" name="user_pwd"/>
		비밀번호 확인: <input type="password" name="user_pwd2"/>
		<input type="hidden" name="user_id" value=${user_id } />
		<input type="submit" value="비밀번호 변경하기"/>
	</form>
</div>
</body>	
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<jsp:include page="${pageContext.request.contextPath }/include/navbar.jsp"/>
</head>
<body>
<div class="container">
	<form action="findUserPwd.do" method="POST">
		아이디 입력: <input type="text" name="user_id" />
		이름 입력: <input type="text" name="user_name" />
		이메일 입력: <input type="email" name="user_email" />
		<input type="submit" value="비밀번호  찾기" />
	</form>
</div>
</body>
</html>
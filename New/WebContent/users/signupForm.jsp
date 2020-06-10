<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="signup.do" method="post">
	<label for="id">
		아이디: <input type="text" id="id" name="user_id" />
	</label>
	<label for="pwd">
		비밀번호: <input type="password" id="pwd" name="user_pwd"/>
	</label>
	<label for="name">
		이름: <input type="text" id="name" name="user_name" />
	</label>
	<label for="email">
		이메일: <input type="email" id="email" name="user_email" />
	</label>
	<input type="submit" value="가입" />
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<jsp:include page="${pageContext.request.contextPath }/include/navbar.jsp"/>
</head>
<body>
<div class="container">
	<form class="box" action="login.do" method="post">
		<h1>Login</h1>
			<input type="hidden" name="url" value="" />
			<input type="text" name="user_id" placeholder="Username" value=""/>
			<input type="password" name="user_pwd" placeholder="Password" value=""/>
			<!-- <label><input type="checkbox" name="isSave" id="yes" /> Save ID, Password</label> --> 
			<input type="submit" name="" value="Login"/>
	</form>
</div>
</body>
</html>
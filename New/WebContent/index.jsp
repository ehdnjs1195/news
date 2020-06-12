<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    <%@ taglib uri="http://authTag.com" prefix="authTag" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지</title>
</head>
<body>
<jsp:include page="${path}/include/navbar.jsp"/>
<div class="container">
	<h1>index페이지</h1>
<authTag:authCheck authority="U001, U002" id="${user_id }" >권한이 없습니다.</authTag:authCheck>
	<a href="users/signupForm.jsp"> 회원가입하기</a>
	<a href="users/loginForm.jsp">로그인</a>
	<a href="users/logout.do">로그아웃</a>
	<a href="users/findUserId.jsp">아이디찾기</a>
	<a href="users/findUserPwd.jsp">비밀번호 찾기</a>
	<a href="users/userInfo.do">회원 정보 보기</a>
	<a href="users/userList.do">회원목록 보기</a>
</div>
</body>
</html>
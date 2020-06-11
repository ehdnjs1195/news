<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<jsp:include page="${pageContext.request.contextPath }/include/navbar.jsp"/>
</head>
<body>
<div class="container">
	<h1>회원 목록 입니다</h1>
	<table class="table table-condensed">
		<colgroup>
			<col class="col-xs-1"/>
			<col class="col-xs-2"/>
			<col class="col-xs-5"/>
			<col class="col-xs-1"/>
			<col class="col-xs-1"/>
			<col class="col-xs-2"/>
		</colgroup>
		<thead>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>이메일</th>
				<th>회원상태</th>
				<th>회원권한</th>
				<th>가입일시</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${userList }">
				<tr>
					<th>${tmp.user_name }</th>
					<th>${tmp.user_id }</th>
					<th>${tmp.user_email }</th>
					<th>${tmp.user_state_code }</th>
					<th>${tmp.user_authority_code }</th>
					<th>${tmp.user_regdate }</th>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>
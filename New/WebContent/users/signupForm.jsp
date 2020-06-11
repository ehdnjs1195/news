<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="${pageContext.request.contextPath }/include/navbar.jsp"/>
</head>
<body>
<div class="container">
<form action="signup.do" method="post">
	<label for="id">
		아이디: <input type="text" id="id" name="user_id" />
	</label>
	<a href="checkId.do" id="checkId">중복 확인</a>
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
</div>
<script>

$("#checkId").click(function(){
	//1. 입력한 아이디를 읽어온다.
	var inputId=$("#id").val();
	//2. 서버에 보내서 사용가능 여부를 응답받는다. (페이지 이동없이 자바스크립트로 원하는 시점에 요청을 하는 작업. 요청과 함께 파라미터를 전달.  	지금 까지는 링크를 누르거나 submit 버튼을 눌러서 요청을 해왔었다.)
	$.ajax({	//object를 전달.  key:value, key:value ... 전달.
		url:"${pageContext.request.contextPath }/users/checkId.do",		//요청 url
		method:"POST",	//요청 메소드
		data:{user_id:inputId},		//data라는 방에 요청 할 때 요청파라미터를 전달(콤마로 여러개의 파라미터를 전달). inputId라는 파라미터 명으로 inputId 값을 전달. (checkid.jsp?inputId=inputId 가 된다.)
		success:function(responseData){		//ajax 요청에 대해 서버에서 응답을 하면 이 함수가 호출된다. 응답한 인자로 responseData가 전달된다. jsp 문자열 전체가 전달된다.
			var isExistId = ${isExistId} ==null? 
			console(isExistId);
			if(!isExistId){//이미 존재하는 아이디라면 
				alert("이미 존재하는 아이디 입니다.");
			}else{
				alert("사용 가능한 아이디 입니다.");
			}
		}
	})
})
</script>
</body>
</html>
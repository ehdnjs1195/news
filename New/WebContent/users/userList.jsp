<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    <%@ taglib uri="/WEB-INF/authTag.tld" prefix="authTag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
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
	
	<!-- pager{s} -->
	<div id="pagerBox">
		<ul class="pager">
			<li>
				<select name="listSize" id="listSize" onchange="fn_listSize('${pager.page}', '${pager.range}', '${pager.rangeSize}')">
					<option value="5">5개씩 보기</option>
					<option value="10">10개씩 보기</option>
					<option value="20">20개씩 보기</option>
					<option value="100">100개씩 보기</option>
				</select>
			</li>
			<c:if test="${pager.prev}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pager.page}', '${pager.range}', '${pager.rangeSize}')">Previous</a></li>
			</c:if>
				
			<c:forEach begin="${pager.startPage}" end="${pager.endPage}" var="idx">
				<li class="page-item <c:out value="${pager.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pager('${idx}', '${pager.range}', '${pager.rangeSize}')"> ${idx} </a></li>
			</c:forEach>
				
			<c:if test="${pager.next}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pager.range}', '${pager.range}', '${pager.rangeSize}')" >Next</a></li>
			</c:if>
		</ul>
	</div>
	<!-- pager{e} -->

</div>

<script>
//리스트 개수 선택
function fn_listSize(page, range, rangeSize){
	var listSize = $("#listSize").val();
	var url = "${pageContext.request.contextPath}/users/userList.do";
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	url = url + "$listSize=" + listSize;

	location.href = url;
}

//이전 버튼 이벤트
function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		
		var url = "${pageContext.request.contextPath}/users/userList.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;

		location.href = url;
	}

  //페이지 번호 클릭
	function fn_pager(page, range, rangeSize, searchType, keyword) {
		var url = "${pageContext.request.contextPath}/users/userList.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;

		location.href = url;	
	}

	//다음 버튼 이벤트
	function fn_next(page, range, rangeSize) {
		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;
		
		var url = "${pageContext.request.contextPath}/users/userList.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
</script>

</body>
</html>
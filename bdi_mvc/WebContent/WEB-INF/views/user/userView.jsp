<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap}">
<script>
	alert('${rMap.msg}');
	if('${rMap.success}'=="true"){
		location.href="/user/userList";
	}
</script>
</c:if>
<body>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<td>${user.uino}</td>			
		</tr>
		<tr>
			<th>이름</th>
			<td>${user.uiname}</td>			
		</tr>
		<tr>
			<th>아이디</th>
			<td>${user.uiid}</td>
		</tr>
		<tr>
			<th>유저설명</th>
			<td>${user.uidesc}</td>			
		</tr>
		<tr>
			<th>나이</th>
			<td>${user.uiage}</td>
		</tr>
		<tr>
			<th>부서번호</th>
			<td>${user.dino}</td>			
		</tr>
		<tr>
			<td colspan="2" style="text-align:center">
				<form action = "/user/userDelete" method="post" style="">
					<button type="button" data-page='/user/userUpdate?uiNo=${user.uino}'>수정</button>
					<button>삭제</button>
					<button type="button" data-page='/user/userList'>리스트 이동</button>
					<input type="hidden" name="uiNo" value="${user.uino}">
				</form>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
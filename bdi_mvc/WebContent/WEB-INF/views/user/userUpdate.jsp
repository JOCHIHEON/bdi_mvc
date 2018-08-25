<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap}">
<script>
	alert('${rMap.msg}');
	if('${rMap.success}'=='true'){
		location.href='/user/userList';
	}
</script>
</c:if>
<body>
<div class="container">
		<form action="/user/userUpdate" method="post">
			<table class="table table-bordered">
				<tr>	
					<th>번호</th>
					<td>${user.uino}</td>
				</tr>
				<tr>	
					<th>이름</th>
					<td><input type="text" name="uiName" value="${user.uiname}"></td>
				</tr>
				<tr>	
					<th>아이디</th>
					<td><input type="text" name="uiId" value="${user.uiid}"></td>
				</tr>
				<tr>	
					<th>패스워드</th>
					<td><input type="password" name="uiPwd" value="${user.uipwd}"></td>
				</tr>
				<tr>
					<th>유저정보</th>
					<td><input type="text" name="uiDesc" value="${user.uidesc}"></td>
				</tr>
				<tr>
					<th>유저나이</th>
					<td><input type="text" name="uiAge" value="${user.uiage}"></td>
				</tr>
				<tr>
					<th>부서번호</th>
					<td><input type="number" name="diNo" value="${user.dino}"></td>
				</tr>
				<tr>
					<td colspan="2"><button>유저수정</button></td>
				</tr>
			</table>
			<input type="hidden" type="number" name="uiNo" value="${user.uino}">
		</form>
	</div>
</body>
</html>
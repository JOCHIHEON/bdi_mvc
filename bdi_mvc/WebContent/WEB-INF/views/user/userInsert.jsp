<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap}">
<script>
	alert('${rMap.msg}');
	if('${rMap.success}'== "true"){
		location.href="/user/userList";
	}
</script>
</c:if>
<body>
	<div class="container">
		<form action="/user/userInsert" method="post">
			<table class="table table-bordered">
				<tr>	
					<th>이름</th>
					<td><input type="text" name="uiName"></td>
				</tr>
				<tr>	
					<th>아이디</th>
					<td><input type="text" name="uiId"></td>
				</tr>
				<tr>	
					<th>비멀번호</th>
					<td><input type="password" name="uiPwd"></td>
				</tr>
				<tr>	
					<th>유저정보</th>
					<td><input type="text" name="uiDesc"></td>
				</tr>
				<tr>	
					<th>나이</th>
					<td><input type="number" name="uiAge"></td>
				</tr>
				<tr>	
					<th>부서번호</th>
					<td><input type="number" name="diNo"></td>
				</tr>
				<tr>
					<td colspan="2"><button>유저등록</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
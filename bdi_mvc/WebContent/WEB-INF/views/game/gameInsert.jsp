<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap}">
<script>
	alert('${rMap.msg}');
	if('${rMap.cnt}'==1){
		location.href="/game/gameList";
	}
</script>
</c:if>
<body>
<div class="container">
<form action="/game/gameInsert" method="post" enctype="multipart/form-data">
	<table class="table table-bordered">
		<tr>
			<th>게임이름</th>
			<td><input type="text" name="gcName"></td>
		</tr>
		<tr>
			<th>게임가격</th>
			<td><input type="number" name="gcPrice" min="0"></td>
		</tr>
		<tr>
			<th>게임회사</th>
			<td><input type="text" name="gcVendor"></td>
		</tr>
		<tr>
			<th>게임순위</th>
			<td><input type="number" name="gcOrder" min="1"></td>
		</tr>
		<tr>
			<th>게임설명</th>
			<td><input type="text" name="gcDesc"></td>
		</tr>
		<tr>
			<th>게임이미지</th>
			<td><input type="file" name="gcImg"></td>
		</tr>
		<tr>
			<td colspan="2"><button>게임등록</button></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
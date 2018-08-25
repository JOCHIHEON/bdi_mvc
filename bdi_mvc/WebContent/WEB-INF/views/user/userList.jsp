<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class="container">
	<h4>유저리스트</h4>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>사원명</th>
					<th>사원아이디</th>
					<th>사원설명</th>
					<th>사원나이</th>
					<th>부서번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var ="u"> 
					<tr>
						<td>${u.uino}</td>
						<td><a href="/user/userView?uiNo=${u.uino}">${u.uiname}</a></td>
						<td>${u.uiid}</td>
						<td>${u.uidesc}</td>
						<td>${u.uiage}</td>
						<td>${u.dino}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<button onclick="goPage()">유저등록</button>
		</div>
	</div>
<script>
function goPage() {
	location.href="/views/user/userInsert"
}
</script>
</body>
</html>
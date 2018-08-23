<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
		<table class="table table-bordered">
			<tr>	
				<th>번호</th>
				<td>${maker.mnum}</td>
			</tr>
			<tr>	
				<th>메이커</th>
				<td>${maker.mname}</td>
			</tr>
			<tr>	
				<th>가격</th>
				<td>${maker.mprice}</td>
			</tr>
			<tr>
				<th>수량</th>
				<td>${maker.mcnt}</td>
			</tr>
			<tr>
				<th>총액</th>
				<td>${maker.mtotal}</td>
			</tr>
			<tr>
				<th>상품설명</th>
				<td>${maker.mdesc}</td>
			</tr>
		</table>
		<div>
			<button onclick="goPage()">리스트이동</button>
		</div>
	</div>
<script>
function goPage() {
	location.href="/maker/makerList";
}
</script>
</body>
</html>
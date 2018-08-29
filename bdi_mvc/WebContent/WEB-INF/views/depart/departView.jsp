<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<td>${depart.diNo}</td>			
		</tr>
		<tr>
			<th>이름</th>
			<td>${depart.diName}</td>			
		</tr>
		<tr>
			<th>부서설명</th>
			<td>${depart.diDesc}</td>			
		</tr>
		<tr>
			<th>부서인원</th>
			<td>${depart.diCnt}</td>			
		</tr>
		<tr>
			<td colspan="2" style="text-align:center">
				<form action="/depart/departDelete" method="post">
					<button data-page="/depart/departUpdate?diNo=${depart.diNo}">부서수정</button>
						<!-- <script>
							window.onload = function(){
								var btns = document.querySelectorAll('button[data-page]');
								for(var i=0;i<btns.length;i++){
									btns[i].setAttribute('type','button')
									btns[i].onclick = function(){
										location.href = this.getAttribute('data-page');
									}
								}	*페이지이동*
							} 
						</script> -->	
					<button>삭제</button>
					<button type="button" data-page='/depart/departList'>리스트 이동</button>
					<input type="hidden" name="diNo" value="${depart.diNo}">
				</form>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
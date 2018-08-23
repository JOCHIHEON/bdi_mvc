<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
		<table class="table table-bordered">
			<tr>	
				<th>메이커</th>
				<td><input type="text" id="mName"></td>
			</tr>
			<tr>	
				<th>가격</th>
				<td><input type="text" id="mPrice"></td>
			</tr>
			<tr>
				<th>수량</th>
				<td><input type="text" id="mCnt"></td>
			</tr>
			<tr>
				<th>상품설명</th>
				<td><input type="text" id="mDesc"></td>
			</tr>
			<tr>
				<td colspan="2"><button onclick="insertMaker()">등록</button>
				<button onclick="goPage()">취소</button></td>
			</tr>
		</table>
	</div>
<script>
	function insertDel(){
		var mName = document.querySelector("#mName").value;
		var mPrice = document.querySelector("#mPrice").value;
		var mName = document.querySelector("#mCnt").value;
		var mPrice = document.querySelector("#mTotal").value;
		var mName = document.querySelector("#mName").value;
		var mPrice = document.querySelector("#mDesc").value;
		location.href='/maker/makerInsert?mName='+mName+'&mPrice='+mPrice
		+'&mCnt='+mCnt+'&mTotal='+mTotal+'&mDesc='+mDesc;
	}
	function goPage(){
		location.href='/maker/makerList';
	}
	var cnt = '${cnt}';
	if(cnt==1){
		alert('등록이 잘 되었습니다.');
		goPage();
	}else if(cnt===0){
		alert('등록에 실패하였습니다.');
	}
</script>
</body>
</html>
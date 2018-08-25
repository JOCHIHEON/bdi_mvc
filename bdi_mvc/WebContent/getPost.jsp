<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<form action="/test">
	<input type="text" name="name">
	<button>Get전송</button>
</form>
<form action="/test" method="post">
	<input type="text" name="name">
	<button>Post전송</button>
</form>
</body>
</html>
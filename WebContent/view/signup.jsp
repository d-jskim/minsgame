<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= application.getContextPath() %>/signup" method="post">
	id: <input type="text" name="userid"/>
	pw: <input type="password" name="password">
	<input type="submit" value="회원가입">
	</form>
</body>
</html>
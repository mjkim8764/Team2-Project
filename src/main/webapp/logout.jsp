<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>

<%
	System.out.println(session.getId());
	session.invalidate();
	session = null;
%>

<center>
<br><br><br><br><h3>로그아웃 성공!</h3><br><br><br>
<button type="button" onclick="location.href='index.html'">로그인 화면으로</button>
</center>


</body>
</html>
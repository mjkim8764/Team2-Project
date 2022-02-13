<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>

<form action="controller?command=memberDelete" method="post">

<br><br><h3>비밀번호를 입력하세요</h3><br><br>
<center>
	<label> 암호 : </label>
   <input type="text" name="pw" value=""><br>
   <input type="submit" value="회원탈퇴">
</center>

</form>

</body>
</html>
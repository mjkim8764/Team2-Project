<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
<center>

<h3>재능 기부자 정보 수정하기 - 재능 분야 수정</h3>
<hr><p>

<form action="controller?command=memberUpdate" method="post">
<table border="1">
	<thead>
		<tr>
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>가입날짜</th><th>대출권수</th>
		</tr>
 	<tr>
 		<td><input type="text" name="id"  value="${member.id}" readonly></td>
 		<td><input type="text" name="pw" value="${mebmer.pw}"></td>
 		<td>${member.name}</td>
 		<td>${member.mdate}</td>
 		<td>${mebmer.maxloan}</td>
 	</tr>
 	
 	<tr>
 		<td colspan="4">
 			<input type="submit" value="수정">
 			&nbsp;&nbsp;&nbsp;
 			<input type="reset" value="취소">
 		</td>
 	</tr>
</table>
</form>

</center>
</body>
</html>
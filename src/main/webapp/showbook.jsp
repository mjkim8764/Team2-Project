<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 검색</title>
</head>
<body>
<h3>
	<br><br><br>검색하신 책의 정보입니다.<br><br><br>
</h3>
	
<center>
<table border="1">
	<tr>   
		<th>책 아이디</th><th>발행번호</th><th>책 이름</th><th>저자</th>
		<th>출판사</th><th>출시일</th><th>보유권수</th>
	</tr>
	 
 		<tr></tr>
 		    <td>${book.id}</td>
 		    <td>${book.isbn}</td>
 			<td>${book.bname}</td>
 			<td>${book.author}</td>
 			<td>${book.publisher}</td>
 			<td>${book.bdate}</td>
 			<td>${book.bcnt}</td>
 		</tr> 
</table>
</center>
<br><br><br>
<button type="button" onclick="location.href='member.html'">메인으로</button>

</body>
</html>
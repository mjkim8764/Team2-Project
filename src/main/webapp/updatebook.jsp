<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.domain.BookDTO, java.util.HashMap" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 수정</title>

</head>
<body>

<center><h3> 책 정보는 아래와 같습니다.</h3><br>
<h3>수정할 곳을 입력하세요(책 권수만 가능)</h3></center>

<form action="controller?command=bookUpdate" method="post">

<center>
<table border="1">
	<tr>   
		<th>책ID</th><th>발행번호</th><th>책 이름</th><th>저자</th>
		<th>출판사</th><th>출시일</th><th>보유권수</th>
	</tr>
	
	<c:forEach items="${requestScope.books}" var="books"> 
 		<tr></tr>
 			<td><input type="text" name="id"  value="${book.id}" readonly></td>
 		    <td><input type="checkbox" name="isbn" value="${book.isbn}" readonly></td>
 			<td>${books.bname}</td>
 			<td>${books.author}</td>
 			<td>${books.publisher}</td>
 			<td>${books.bdate}</td>
 			<td><input type="text" name="bcnt" value="${books.bcnt}"></td>
 		</tr>
 	</c:forEach>
</table>
</center>

<br><br>

<center>
<input type="submit" value="수정하기" onclick='update()'>
<SCRIPT LAUNGUAGE='JAVASCRIPT'>
	function update() {
		alert('수정되었습니다!');
	}
</SCRIPT>
</form>
<button type="button" onclick="location.href='member.html'">메인으로</button>

<form action="controller?command=rentAllInfo" method="post">
</form>

</center>

</body>
</html>
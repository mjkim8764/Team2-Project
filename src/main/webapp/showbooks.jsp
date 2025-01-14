<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.domain.BookDTO" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 대출하기</title>

</head>
<body>

<center><h3> 책 정보는 아래와 같습니다.</h3><br><h3> 대출할 책을 선택하세요.</h3></center>

<form action="controller?command=rentAllInsert" method="post">

<center>
<table border="1">
	<tr>   
		<th>체크</th><th>발행번호</th><th>책 이름</th><th>저자</th>
		<th>출판사</th><th>출시일</th><th>보유권수</th>
	</tr>
	
	${sessionScope.id}
	
	<c:forEach items="${requestScope.books}" var="book"> 
 		<tr></tr>
 		    <td><input type="checkbox" name="bid" value="${book.id}"></td>
 		    <td>${book.isbn}</td>
 			<td><a href='/controller?command=bookInfo&bid=${book.id}'>${book.bname}</td>
 			<td>${book.author}</td>
 			<td>${book.publisher}</td>
 			<td>${book.bdate}</td>
 			<td>${book.bcnt}</td>
 		</tr>
 	</c:forEach> 
</table>
</center>

<br><br>

<center>
<input type="submit" value="대출하기" onclick='reserve()'>
<SCRIPT LAUNGUAGE='JAVASCRIPT'>
	function reserve() {
		alert('대출되었습니다!');
	}
</SCRIPT>
</form>
<button type="button" onclick="location.href='member.html'">메인으로</button>

</center>

</body>
</html>
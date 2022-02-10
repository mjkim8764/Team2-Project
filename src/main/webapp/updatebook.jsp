<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.domain.BookDTO, java.util.HashMap" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 보기</title>

</head>
<body>

<center><h3> 책 정보는 아래와 같습니다.</h3></center>

<table border="1">
	<tr>   
		<th>체크</th><th>발행번호</th><th>책 이름</th><th>저자</th>
		<th>출판사</th><th>출시일</th><th>보유권수</th>
	</tr>
	
	<c:forEach items="${requestScope.bookInfo}" var="dataAll">
 		<tr>
 			<td></td>
 			<td>${dataAll.isbn}</td>
 			<td>${dataAll.bname}</td>
 			<td>${dataAll.author}</td>
 			<td>${dataAll.publisher}</td>
 			<td>${dataAll.bdate}</td>
 			<td>${dataAll.bcnt}</td>
 		</tr>
 	</c:forEach> 
</table>

</body>
</html>
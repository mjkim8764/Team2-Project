<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.domain.BookDTO" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 보기</title>

</head>
<body>

<center><h3> 대출 현황은 아래와 같습니다.</h3><br><h3> 반납할 책을 선택하세요.</h3></center>

<form action="controller?command=rentDelete" method="post">

<center>
<table border="1">
	<tr>   
		<th>체크</th><th>대출 관리번호</th><th>책 아이디</th><th>회원 아이디</th><th>책 대출일</th>
	</tr>
	
	<c:forEach items="${requestScope.rents}" var="rent"> 
 		<tr>
 			<td><input type="checkbox" name="rent" value="${rent.rentno}"></td>
 			<td>${rent.rentno}</td>
 			<td>${rent.bid}</td>
 			<td>${rent.mid}</td>
 			<td>${rent.rdate}</td>
 		</tr>
 	</c:forEach> 
</table>
</center>

<br><br>

<center>
<input type="submit" value="반납하기" onclick='notreserve()'>
<SCRIPT LAUNGUAGE='JAVASCRIPT'>
	function notreserve() {
		alert('반납되었습니다!');
	}
</SCRIPT>
</form>
<button type="button" onclick="location.href='member.jsp'">메인으로</button>

</center>

</body>
</html>
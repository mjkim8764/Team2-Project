<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>어서오세요</title>

</head>
<body>
<br><br><br><br>
<center>
<h3>원하는 메뉴를 선택하세요 !</h3>

<a href="controller?command=bookAllInfo">1. 책 리스트</a><br><br>

<form action="controller?command=bookInfo", method="post">
2. 책 검색(이름을 입력하세요)<br>
<input type="text" name="bname" value="">
<input type="submit" value="검색"> 
</form>



<a href="controller?command=rentAllInfo">3. 대출현황 확인</a><br><br><br>

    <h3> 매니저 메뉴 </h3>

<a href="addbook.jsp">4. 책 추가</a><br>

<a href="controller?command=bookAllInfo2">5. 책 제거</a><br>
<a href="controller?command=bookAllInfo3">6. 책 정보수정</a><br><br><br>
    <button type="button" onclick="location.href='myinfo.jsp' ">내 정보</button>
    <button type="button" onclick="location.href='updateinfo.jsp' ">내 정보수정</button>
    <button type="button" onclick="location.href='logout.jsp' ">로그아웃</button>
    <button type="button" onclick="location.href='signout.jsp' ">회원탈퇴</button>

</center>
</body>
</html>
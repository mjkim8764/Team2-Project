<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 추가</title>
</head>
<body>
<br><br><br><br>
<center>
<h3>추가할 책의 정보를 적어주세요 !</h3>
</center>

<form action="controller?command=bookInsert" method="post">
    <!-- ID, PW 입력 & 로그인-->
    <center>
        <label>책 아이디 : </label>
        <input type="text" name="id"><br>
    </center>

    <center>
        &nbsp;&nbsp;&nbsp;<label>발행번호 : </label>
        <input type="text" name="isbn"><br>
    </center>

    <center>
        &nbsp;&nbsp;&nbsp;<label>책 이름 : </label>
        <input type="text" name="bname"><br>
    </center>

    <center>
        &nbsp;&nbsp;&nbsp;<label>책 저자 : </label>
        <input type="text" name="author"><br>
    </center>
    
    <center>
        &nbsp;&nbsp;&nbsp;<label>출판사 : </label>
        <input type="text" name="author"><br>
    </center>
    
    <center>
        &nbsp;&nbsp;&nbsp;<label>출시일 : </label>
        <input type="text" name="author"><br>
    </center>
    
    <center>
        &nbsp;&nbsp;&nbsp;<label>책 보유 권수 : </label>
        <input type="text" name="author"><br>
    </center>

	<center>
		<input type="submit" value="추가하기" onclick='addbook()'>
		<SCRIPT LAUNGUAGE='JAVASCRIPT'>
			function addbook() {
				alert('추가되었습니다!');
				document.location.href="member.html";
			}
		</SCRIPT>
</form>

<button type="button" onclick="location.href='member.html'">메인으로</button>

</body>
</html>
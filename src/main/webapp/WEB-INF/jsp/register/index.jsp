<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.register.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="/static/js/register.js"></script> 
</head>
<body>

	<form action="./register" method="post"> 
	<div>
		<label>아이디</label>					<!-- init 데이터 널값인지 확인 -->
			<input type="text" name="userid" required>
	</div>
	
	<div>
		<label>비밀번호</label>
			<input type="password" id="id_pass1" name="password" required>
	</div>
	
	<div>
		<label>비밀번호 확인</label>
		<input type="password" id="id_pass2" name="password_check"  required>					
		<div><label></label></div>
	</div>

	<div>
		<label>이름</label>
		<input type="text" name="username"  required>					
	</div>
	
	<div>
		<label>이메일</label>
			<input type="text" name="email" required>	
	</div>
	<!--  
	<div>
		<label>생년월일</label>
		<input type="date" name="year" value="" min="1900-01-01" max="2021-12-31">
	</div> -->
	<div>
		<label>성별</label>
		<select name="gender">
		<option value="f">여자</option>
		<option value="m">남자</option>
		</select>
	</div>
	<div>
	<label>키</label>
	<input type="text" name="height">
	</div>
	<label>몸무게</label>
	<input type="text" name="weight">
	</div>
	
	<div>
	<button type="submit">가입하기</button>
	</div>
</form>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.register.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="/static/js/register.js"></script> 
<link rel="stylesheet" href="/static/css/register.css">
</head>
<body>

	<%
		RegisterDTO initData = new RegisterDTO(); //object가 있는지 없는지 먼저 파악
		if(request.getAttribute("initData") != null) {
			initData =(RegisterDTO) request.getAttribute("initData"); //다운캐스팅
		}
	%>
	<form action="./register" method="post" onsubmit="idpwCheck"> 
	
	<div class ="joinform">
	
	<div class = "joinheader">
	<div class = "joinheader-1">	
	<h1>회원가입</h1>
	<div class="joinheader-2">
	<h3>😊 회원 가입 양식을 작성 해 주세요 😊</h3>
	</div>
    </div>
	</div>
	
	<div class="joinmiddle">

	<div class="input-form">
	<label>아이디</label>
	<div class = "inline-input">
	<input type="text" id="userid" name="userid" value="<%=initData.getUserid()%>" maxlength="20" >
	</div>
	</div>
	<div>
   <span id="idMsg"></span>
   </div>
	
	<div class="input-form">
	<label>비밀번호</label>
	<div class = "inline-input">
	<input type="password" name="password" id="pass1" >
	</div>
	</div>
	
	<div class="input-form">
	<label>비밀번호 확인</label>
	<div class = "inline-input">
	<input type="password" name="password_check" id="pass2" >
	</div>
	</div>
	<div>
   <span id="check"></span>
   </div>
	
	
	<div class="input-form">
	<label>이름</label>
	<div class = "inline-input">
	<input type="text" name="username" id="username" value="<%=initData.getUsername()%>" required>
	</div>
	</div>
	
	<div class="input-form">
	<label>이메일</label>
	<div class = "inline-input">
	<input type="text" name="email" id="email" value="<%=initData.getEmail()%>" required>
	</div>
	</div>
	
	<div class="input-form">
	<label>생년월일</label>
	<div class = "inline-input">
	<input type="date"  name="birthday" id="birthday" value="<%=initData.getBirthday()%>" min="1900-01-01" max="2021-12-31">
	</div>
	</div>
	
	<div class="input-form">
	<label>성별</label>
	<div class = "inline-input">
	<select name="gender" id="birthday">
		<option value="f">여자</option>
		<option value="m">남자</option>
		</select>
	</div>
	</div>
	
	<div class="input-form">
	<label>키</label>
	<div class = "inline-input">
	<input type="text" id="height" name="height" id="height" value="<%=initData.getHeight()%>"  required>
	<span class="mute">cm</span>
	</div>
	</div>
	
	<div class="input-form">
	<label>몸무게</label>
	<div class = "inline-input" >
	<input type="text" id="weight" name="weight" id="weight" value="<%=initData.getWeight()%>"  required>
	<span class="mute">kg</span>
	</div>
	</div>

	<div class="btn">
	<button type="submit">가입하기</button>
	</div>

	</div>
	</div>

	
</body>
</html>


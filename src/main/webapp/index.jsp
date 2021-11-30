<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello</h1>
	<% 
   		if(session.getAttribute("login_name") != null) {
    %>
	   		<h3>Session -> <%=(String)session.getAttribute("login_name") %> 님 환영합니다.</h3>
	   		<a href="register">회원 가입</a>
			<a href="/logout">로그아웃</a>
			<a href="/review">리뷰 목록</a>
   	<%
    	} else {
   	%>
	   		<a href="register">회원 가입</a>
			<a href="/login">로그인</a>
			<a href="/review">리뷰 목록</a>
	<%
    	}
	%>
</body>
</html>
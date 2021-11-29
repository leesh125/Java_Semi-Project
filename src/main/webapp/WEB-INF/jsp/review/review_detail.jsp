<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>    
<%@ page import = "com.web.review.model.*" %>    
<%@ page import = "com.web.review.controller.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세조회</h1>
	<%
		ReviewDTO datas = (ReviewDTO) request.getAttribute("datas");
		if(datas != null) {
	%>
	
	<div>
		<a href="/update">수정</a>
		<button >삭제</button>
		<a href="/review">목록으로</a>
	</div>
	<p><%= datas.getReview_id() %></p>
	<p><%= datas.getReview_context() %></p>
	<p><%= datas.getReview_title() %></p>
	<p><%= datas.getReview_date() %></p>
	<p><%= datas.getViews() %></p>
	<%		
			
		}else{	
		%>
		<p>data없음</p>
	<%
		}
	%>	
</body>
</html>
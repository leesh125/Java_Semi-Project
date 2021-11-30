<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>    
<%@ page import = "com.web.review.model.*" %>    
<%@ page import = "com.web.review.controller.*" %>  
<%@ page import="java.io.File" %>
<!-- 파일 이름이 동일한게 나오면 자동으로 다른걸로 바꿔주고 그런 행동 해주는것 -->
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<!-- 실제로 파일 업로드 하기 위한 클래스 -->
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세조회</h1>
	<%
		// 현재 로그인 된 username
		String username = (String)session.getAttribute("login_name");
		System.out.println("로그인 된 username : " + username);
		// 현재 review_id에 해당되는 data 조회
		ReviewDTO datas = (ReviewDTO) request.getAttribute("datas");
		
		String data_username = "";
		if(datas != null) {
			data_username = datas.getUsername(); // 현재 review_id에 해당되는 username
			System.out.println("리뷰 주인 username : " + data_username);
	%>
	<div>
		<a href="/review">목록으로</a>
	</div>
	<img src="../upload/<%=datas.getReview_fileName()%>" style="width:200px; height:200px;"/>
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
	
	<% 
		if(username.equals(data_username)){ // 로그인 username == 현재 review의 username
	%>
	<div>
		<a href="/update?review_id=<%=datas.getReview_id() %>">수정</a>
		<a href="/delete?review_id=<%=datas.getReview_id() %>">삭제</a>
	</div>
	<%
		}
	%>
</body>
</html>
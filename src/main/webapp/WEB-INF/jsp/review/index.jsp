<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>    
<%@ page import = "com.web.review.model.*" %>    
<%@ page import = "com.web.review.controller.*" %>  
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Review</title>
	<script type="text/javascript" src="/js/reviewScript.js"></script>
</head>
<body>
	<!-- 리뷰 table -->
	<h4>Review</h4>
	<div><hr></div>
	<% 
   		if(session.getAttribute("login_name") != null) {
    %>	
	<form action="/review" method="post">	
		<table class="review_tb">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>수정/삭제</th>
				</tr>
			</thead>
		<tbody>
			<%
				String username = (String)session.getAttribute("login_name"); 
				System.out.println("로그인 한 유저 : "+username);
				List<ReviewDTO> datas = (List<ReviewDTO>) request.getAttribute("datas");
				if(datas != null) {
				for(ReviewDTO data: datas){
					String data_username = data.getUsername();
					
			%>
			
			<tr>
				<td><%= data.getReview_id() %></td>
				<td><a href="/review_detail?review_id=<%=data.getReview_id() %>"><%= data.getReview_title() %></a></td>
				<td class="con"><%= data.getReview_context() %></td>
				
				<td><%= data.getReview_date() %></td>
				<td><%= data.getViews() %></td>
				
				<% 
					if(username.equals(data_username)){
				%>
				<td>
					<a href="/update?review_id=<%=data.getReview_id() %>">수정</a>/
					<a href="/delete?review_id=<%=data.getReview_id() %>">삭제</a>
				</td>
				<%
				}else{
				%>
					<td>권한 없음</td>
				<%
				}
				%>
			</tr>
				
		<%		
				}
		%>
		</tbody>	
		</table>	
	</form>
		
		
		<div><a href="/review_write" >리뷰 작성</a></div>
		<%
			}else{ // 아무린 리뷰가 없을때	
		%>
		<h1>리뷰를 작성해보세요!</h1>
		<div><a href="/review_write" >리뷰 작성</a></div>
		<%		
			}
		%>	
		<%
   		} else { // 로그인을 안하면 리뷰목록 조회 안됨
		%>
			<h3>리뷰목록을 조회하려면 로그인이 필요합니다.</h3>
			<a href="/login">로그인</a>
		<%
   		}
		%>
</body>
</html>
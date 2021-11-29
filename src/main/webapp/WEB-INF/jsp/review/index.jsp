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
		
	<form action="/review" method="post">	
		<table class="review_tb">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th colspan="2">내용</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
		<tbody>
			<%
				List<ReviewDTO> datas = (List<ReviewDTO>) request.getAttribute("datas");
				if(datas != null) {
				for(ReviewDTO data: datas){
			%>
			<tr>
				<td><%= data.getReview_id() %></td>
				<td><a href="/review_detail?review_id=<%=data.getReview_id() %>"><%= data.getReview_title() %></a></td>
				<td class="con"><%= data.getReview_context() %></td>
				<td>
					<a href="/update?review_id=<%=data.getReview_id() %>">수정</a>
					<form action="/delete" method="post">
						<input type="hidden"name="review_id" value="<%= data.getReview_id() %>">
						<button type="submit">삭제</button>
					</form>	
				</td>
				<td><%= data.getReview_date() %></td>
				<td><%= data.getViews() %></td>
			</tr>				
			<%		
				}
			}else{	
			}
			%>			
		</tbody>	
		
		<!-- 리뷰 작성 페이지로 넘어가기 -->
		
		</table>	
		
	</form>
	
		<div><a href="/review_write" >리뷰 작성</a></div>	
</body>
</html>
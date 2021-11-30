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
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Review</title>
	<script type="text/javascript" src="/js/reviewScript.js"></script>
</head>
<body>
	<!-- 리뷰 table -->
	<h2>Review</h2>
	<div><hr></div>
	
	<!-- 조회수 TOP 1 데이터 출력 -->
	<h4>1등 리뷰</h4>
	<p>조회수가 같을 경우 가장 최근에 올라온 리뷰가 우선순위 입니다.</p>
	<% 
		ReviewDTO top_views = (ReviewDTO) request.getAttribute("top_views");
		if(top_views.getReview_date() != null) {
	%>
		<div>
			<div>
				<img src="../upload/<%=top_views.getReview_fileName()%>" style="width:200px; height:200px;"/>
			</div>
			<div>
				번호 :<%= top_views.getReview_id() %>
			</div>
			<div>
				제목 : <%= top_views.getReview_title()%>
			</div>
			<div>
				내용 : <%= top_views.getReview_context() %>
			</div>
			<div>
				작성일 : <%= top_views.getReview_date()%>
			</div>
			<div>
				조회수 : <%= top_views.getViews() %>
			</div>
		</div>
		<br>
		<hr>
	<%
		}
	%>
	<!-- 리뷰 리스트 조회 -->
	<% 
   		if(session.getAttribute("login_name") != null) {
    %>	
	<form action="/review" method="post" enctype="multipart/form-data">	
		<table class="review_tb">
			<thead>
				<tr>
					<th>번호</th>
					<th>이미지</th>
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
				<td><img src="../upload/<%=data.getReview_fileName()%>" style="width:200px; height:200px;"/>
				<td><a href="/review_detail?review_id=<%=data.getReview_id() %>"><%= data.getReview_title() %></a></td>
				<td class="con"><%= data.getReview_context() %></td>
				
				<td><%= data.getReview_date() %></td>
				<td><%= data.getViews() %></td>
				
				<% 
					if(username.equals(data_username)){
				%>
				<td>
					<a href="/update?review_id=<%=data.getReview_id() %>">수정</a>
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
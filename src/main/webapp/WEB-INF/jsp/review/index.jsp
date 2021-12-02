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
	<%@ include file ="/module/head.jsp" %>
	<link type="text/css" rel="stylesheet" href="/static/css/reviewbox.css">
	<script type="text/javascript" src="/js/reviewScript.js"></script>
</head>
<body class="modal-open" style="padding-right:16px;">
	<jsp:include page="/module/header.jsp"></jsp:include>
	
   <!-- 검색바 -->
   <div id="review_img">
      <a href="/review"><img src="/static/img/review.png"></a>
   </div>
   <div class="search_icon">
      <input type="search" id="search-bar" maxlength="28">
      <a href="/review"><img id="find-icon" src="/static/img/find-icon.png"></a>
      <div class="review_write"><a href="/review_write">리뷰 작성</a></div>   
   </div>
	   
   <!-- 리뷰 작성 -->
   
   
	
	<!-- 리뷰 리스트 조회 -->
	<% 
   		if(session.getAttribute("login_name") != null) {
    %>	
	<form action="/review" method="post" enctype="multipart/form-data">	
		
			<%
				String username = (String)session.getAttribute("login_name"); 
				System.out.println("로그인 한 유저 : "+username);
				List<ReviewDTO> datas = (List<ReviewDTO>) request.getAttribute("datas");
				if(datas != null) {
				for(ReviewDTO data: datas){
					String data_username = data.getUsername();
					
			%>
			
		<main>
		      <li class="review_li">   
		         <!--리뷰 박스 모양  -->
		         <div class="review_box">
		            <div class="name-cnt">   
		               <div id="re-user-name"><%= data.getUsername() %></div>
		               <div id="view_cnt">조회수: <%= data.getViews() %></div>
		            </div>     
		            <a href="/review_detail?review_id=<%=data.getReview_id() %>"><%= data.getReview_title() %>
		            	<img id="img_size" src="../upload/<%=data.getReview_fileName()%>"/> 
		            </a>
		                    
		               
		            <!-- 리뷰 제목 css -->
		            <div id="review_title"><%= data.getReview_title() %></div>   
		            <hr id="line">
		            <!-- 리뷰 내용 css -->
		            <div id="review_context"><%= data.getReview_context() %></div>
		            
		            <div class="dud">
		               <!-- 리뷰 업로드 시간  -->   
		               <div id="review_date"><%= data.getReview_date() %></div>
		               <!-- 수정 버튼 -->
		               
		                <% 
							if(username.equals(data_username)){
						%>
						
							<a class="update-btn" href="/update?review_id=<%=data.getReview_id() %>">수정</a>
							<span id="line2">|</span> 
							<a href="/delete?review_id=<%=data.getReview_id() %>">삭제</a>
						
						<%
							}else{
						%>
								
						<%
							}
		              	%>
		               
		            </div>   
		                     
		         </div><!-- review_box end -->         
		      </li>
		                  
		</main>   
			
			<%-- <tr>
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
				
		
		</tbody>	
		</table> --%>	
		<%		
				}
		%>
	</form>
		
		
		
		
		
		<!-- // *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@22 -->
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
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
    <%@ include file ="/module/head.jsp" %>
  	<link type="text/css" rel="stylesheet" href="/static/css/main_img.css">
</head>
<body style="padding-right: 16px;">
	<jsp:include page="/module/header.jsp"></jsp:include>
	<!-- 조회수 TOP 1 데이터 출력 -->
	<sub class="sub_views">조회수가 같을 경우 가장 최근에 올라온 리뷰가 우선순위 입니다.</sub>
	<div class="img_top">
		<img src="static/img/top_views_top.png"/>
	</div>
	<div class="context">
    </div>
    
    <%
	    ReviewDTO top_views = (ReviewDTO) request.getAttribute("top_views");
		if(top_views.getReview_date() != null) {
	%>
    <div>
    <!-- 이미지 크기 -->
    <img src="../upload/<%=top_views.getReview_fileName()%>" id="image"/>
       
    </div>
    <div class="box">
          <div id="title">제목 : <%= top_views.getReview_title() %> </div>
          <hr id="line">
          <div id="review_context" ><%= top_views.getReview_context() %></div>      
    </div>
    <%-- <p><%= datas.getReview_date() %></p>
	<p><%= datas.getViews() %></p> --%>
    <!-- 돌아가기 -->
    <div>
       <span class="get_views">조회수 : <%= top_views.getViews() %></span>
    </div>
    
    <div class="img_bot">
    	<img src="static/img/top_views_bottom.png"/>
    </div>
    <%		
			
		}else{	
	%>
		<p>data없음</p>
	<%
		}
	%>	
	
	
	
	
	
	<%-- 
	<% 
		ReviewDTO top_views = (ReviewDTO) request.getAttribute("top_views");
		if(top_views.getReview_date() != null) {
	%>
		<div>
			<div>
				<img src="/upload/<%=top_views.getReview_fileName()%>" style="width:200px; height:200px;"/>
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
	<%
		}else{
	%>
		<h1>오류</h1>
	<%
		}
	%>  --%>
	<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>

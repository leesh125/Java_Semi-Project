<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.web.review.model.*" %>
<%@ page import="java.io.File" %>
<!-- 파일 이름이 동일한게 나오면 자동으로 다른걸로 바꿔주고 그런 행동 해주는것 -->
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<!-- 실제로 파일 업로드 하기 위한 클래스 -->
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%@ include file ="/module/head.jsp" %>
	<link type="text/css" rel="stylesheet" href="/static/css/review_write.css">
	<script type="text/javascript" src="/static/js/reviewScript.js"></script>
</head>
<body class="modal-open" style="padding-right:16px;">
	<jsp:include page="/module/header.jsp"></jsp:include>
	<form action="/review_write" method="post" enctype="multipart/form-data">
            <div id="review" style="margin-top: 180px;">
               <span>REVIEW</span>
            </div>
               <% 
                  ReviewDTO dto = new ReviewDTO();
                  if(request.getAttribute("init") != null){
                     dto = (ReviewDTO)request.getAttribute("init");
                  }
               %> 
               <div class="table" style="margin-top: 200px;">
                  
               <!--  리뷰 제목 -->
               <div>
                  <input id="review_title" type="text" maxlength="20" name="review_title" placeholder="제목을 입력해 주세요." maxlength="50"  autofocus><%= dto.getReview_title() %>
               </div>
               
               <!-- 리뷰 내용 -->
               <div>
                  <textarea id="review_context" maxlength=2048 name="review_context" 
                  placeholder="★ 적립금 지급 ★
-글자수 40자 이상 글리뷰 1000원 지급
- 전신샷 리뷰 2000원 지급 ( *글 + 포토 리뷰 =2,000원)
- 상품 일등 포토리뷰 후기는 더블로 4,000원 지급

** 아래와 같은 경우 적립금이 지원되지 않아요 ㅠㅠ
- 글자수 40자 미만일 경우
- 상품과 상관 없는 단어로 40자 채울 경우
- 5,000원 미만의 상품인 경우
- 60일 지난 상품 리뷰의 경우
- 할인 상품인 경우"></textarea>
                     <%= dto.getReview_context() %>
                  <label for="review_context"></label>   
               </div>
               
               
               <table class="table2">
                  <p id="photo">PHOTO</p>   
                  <div id="table3">
                     
                     <!-- 파일 첨부 -->
                     <div class="file">
                        <input type="file" id="image" name="review_fileName" accept="img/*" onchange="setThumbnail(event);" value="<%= dto.getReview_fileName() %>"/>
                         <div id="image_container"></div>
                         <label for="image">사진첨부</label>
                     </div>
                  </div>
                  
               </table>         
                <!-- 리뷰 작성 -->
                
               <div class="write-back">
                  <input id="write_btn" type="submit" value="리뷰작성">
               <!-- 돌아가기 -->   
                  <a href="/review" id="back-review">돌아가기</a>
                </div>
               
            </div>
            
                  
   </form>
	<%-- <form action="/review_write" method="post" enctype="multipart/form-data">
		<h1>리뷰 작성</h1>
			<table style="text-align:center; border:1px solid #dddddd">
					<tr>
						<th colspan="2" style="text-align:center;">review 작성</th>
					</tr>

				<tbody>
					<tr><td>
						<input type="text" name="review_title" placeholder="리뷰 제목" maxlength="50" >
					</td></tr>
					<tr>
					<td>
					<% 
						ReviewDTO dto = new ReviewDTO();
						if(request.getAttribute("init") != null){
							dto = (ReviewDTO)request.getAttribute("init");
						}
					%>	
					<!-- ReviewDTO로 다운 캐스팅 시켜주기 -->
					<textarea placeholder="리뷰 내용" name="review_context" maxlength="2048" style="height:350px;" >
						<%= dto.getReview_context() %>

					</textarea>
					</td>
					</tr>
					
					<!-- 이미지 파일 업로드 -->
					<tr>
						<td>	
						  <input type="file" name="review_fileName" id="image" accept="image/*" onchange="setThumbnail(event);" value=" <%= dto.getReview_fileName() %>"/>
						  <div id="image_container"></div>
						</td>
					</tr>
				</tbody>	
				</table>	
				<input type="submit" value="리뷰게시" />
	</form> --%>
	
</body>
</html> 
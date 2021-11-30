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
	<title>리뷰 수정</title>
	<script type="text/javascript" src="/js/reviewScript.js"></script>
</head>
<body>
	<% 
		ReviewDTO dto = new ReviewDTO();
		if(request.getAttribute("datas") != null){
			dto = (ReviewDTO)request.getAttribute("datas");
		}
	%>
	<form action="/update" method="post" enctype="multipart/form-data">
		<h1>리뷰 수정</h1>
			<input type="hidden" name="review_id" value="<%= dto.getReview_id() %>">
			<table style="text-align:center; border:1px solid #dddddd">
					<tr>
						<th colspan="2" style="text-align:center;">review 수정</th>
					</tr>

				<tbody>
						
					<tr><td>
						<input type="text" name="review_title" maxlength="50" value="<%= dto.getReview_title() %>">
						
					</td></tr>
					<tr>
					<td>

					<!-- ReviewDTO로 다운 캐스팅 시켜주기 -->
					<textarea placeholder="리뷰 내용" name="review_context" maxlength="2048" style="height:350px;" >
						<%= dto.getReview_context() %>

					</textarea>
					</td>

					</tr>
					
					<tr>
						<td>	
						  <input type="file" name="review_fileName" id="image" accept="image/*" onchange="setThumbnail(event);" value=" <%= dto.getReview_fileName() %>"/>
						  <div id="image_container"></div>
						</td>
					</tr>
				</tbody>	
				</table>	
				<button type="submit">수정하기</button>
	</form>


</body>
</html> 
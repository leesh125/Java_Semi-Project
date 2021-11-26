<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.web.review.model.*" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>리뷰 작성 게시글</title>
</head>
<body>

<form action="/review_write" method="post">
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
				</tbody>	
				</table>	
				<input type="submit" value="리뷰게시" />
	</form>
</body>
</html>
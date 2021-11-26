package com.web.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.review.model.ReviewDTO;
import com.web.review.model.ReviewService;


// 리뷰 작성 폼
@WebServlet("/review_write")
public class ReviewWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReviewService service = new ReviewService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view ="/WEB-INF/review/re_write.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String review_title = request.getParameter("review_title");
		String review_context = request.getParameter("review_context");
		
		// dto에서 제목,내용 값 가져오기
		ReviewDTO dto = new ReviewDTO(review_title, review_context);
		
		// 서비스에서 요청해 데이터 가져오기
		if(service.add(dto)) {
			// true면 저장 완료 후 목록 페이지 호출
			response.sendRedirect("/review");
		}else {
			//false면 저장 실패면 창 다시 띄우기
			request.setAttribute("init", dto);	
			request.setAttribute("datas" , service.getReviewList());
			response.sendRedirect("/review_write");	
		}

	}
}

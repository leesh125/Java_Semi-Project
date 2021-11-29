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


@WebServlet("/update")
public class ReviewUpdateController extends HttpServlet {
	
	private ReviewService service = new ReviewService();
	
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service = new ReviewService();
		String id = request.getParameter("review_id");
		int id_int = Integer.parseInt(id); // string을 int로 (id는 int이다)
		System.out.println(id_int);
		ReviewDTO dto = new ReviewDTO(id_int);
		
		if(id != null) {
			request.setAttribute("datas", service.getReviewId(id_int));
			String update = "/WEB-INF/jsp/review/update.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(update);
			rd.forward(request, response);
		}
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("review_id");
		int review_id = Integer.parseInt(id);
		String title = request.getParameter("review_title");
		String context = request.getParameter("review_context");
		
		System.out.println("id는 = " + review_id + "  , " +  title + ", " + context);
		ReviewDTO dto = new ReviewDTO(review_id,title,context);

		boolean res = false;
		
		if (review_id != 0) {
			res = service.updateReview(dto);
			if(res) {
				System.out.println("update post 성공 후 review 목록 페이지로 !");
				response.sendRedirect("/review");
			}else {
				System.out.println("Reivew 수정 실패! - controller에서");
			}
		}
		
	}
	
}

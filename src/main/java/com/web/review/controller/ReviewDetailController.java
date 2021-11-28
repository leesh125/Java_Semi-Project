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

@WebServlet("/review_detail")
public class ReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService service = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service = new ReviewService();
		String id = request.getParameter("review_id");
		int id_int = Integer.parseInt(id); // string을 int로 (id는 int이다)
		
		if(id != null) {
			ReviewDTO dto = new ReviewDTO(id_int);
			request.setAttribute("datas", service.getReviewId(id_int));
			String review_detail = "/WEB-INF/jsp/review/review_detail.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(review_detail);
			rd.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

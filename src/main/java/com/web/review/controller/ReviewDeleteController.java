package com.web.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.review.model.ReviewDTO;
import com.web.review.model.ReviewService;


@WebServlet("/delete")
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String review_id = request.getParameter("review_id");
		int review_id_int = Integer.parseInt(review_id);
		
		ReviewService service = new ReviewService();
		ReviewDTO dto = new ReviewDTO();
		
		dto.setReview_id(review_id_int);

		if(service.delete(dto)) {
			response.sendRedirect("../review");
		}else {
			response.sendRedirect("../review");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
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
		String update = "/WEB-INF/review/update.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(update);
		rd.forward(request, response);
	
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		
	}
	
}

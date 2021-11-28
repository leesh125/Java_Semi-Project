package com.web.review.controller;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.review.model.ReviewDTO;
import com.web.review.model.ReviewService;

import com.web.review.model.*;
//사용자 요청 페이지 리뷰 목록

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReviewService service = new ReviewService();
		
		// 모든 테이블 내용이 datas에 담긴다
		List<ReviewDTO> datas = service.getReviewList();
		
		// 뷰에서 사용할 수 있게 전달
		request.setAttribute("datas", datas);
		
		String view ="/WEB-INF/jsp/review/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String view ="/WEB-INF/jsp/review/re_write.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);

		}
		


}

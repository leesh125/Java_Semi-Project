package com.web.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.web.review.model.ReviewDTO;
import com.web.review.model.ReviewService;


// 리뷰 작성 폼
@WebServlet("/review_write")
public class ReviewWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReviewService service = new ReviewService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view ="/WEB-INF/jsp/review/re_write.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
//		session.setAttribute("login_name", dto.getUsername());
		try {
			MultipartRequest multi = new MultipartRequest(request ,
			request.getServletContext().getRealPath("/upload"), // 실제 경로
			1024 * 1024 * 10 , 
			"utf-8", 
			new DefaultFileRenamePolicy());
			
			//파일명이 중복되면 시스템에서 자동으로 바꿔줌
			String review_fileName = multi.getFilesystemName("review_fileName");
			// 원래 파일명
			String review_filerealName = multi.getOriginalFileName("review_fileName");
								
			if(multi.getFilesystemName("review_fileName") != null) {
				String user_name = (String) session.getAttribute("login_name");; 
				String review_title = multi.getParameter("review_title");
				String review_context = multi.getParameter("review_context");
				review_fileName = multi.getFilesystemName("review_fileName");
				ReviewDTO dto = new ReviewDTO(review_fileName,review_title, review_context,user_name);
		
				
				
				// dto에서 제목,내용 값 가져오기
				
				
				// 서비스에서 요청해 데이터 가져오기
				if(service.add(dto)) {
					// true면 저장 완료 후 목록 페이지 호출
					response.sendRedirect("/review");
				}else {
					//false면 저장 실패면 창 다시 띄우기
					System.out.println("실패!@");
					request.setAttribute("init", dto);	
					request.setAttribute("datas" , service.getReviewList());
					response.sendRedirect("/review_write");	
				}
			} else {
				response.sendRedirect("/review");
				System.out.println("파일 업로드 실패!!");
			}
		}catch (IOException e) {
			String view ="/WEB-INF/review/re_write.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			request.setAttribute("error", "제한 용량 초과(10k)");
			rd.forward(request, response);
		}
	}
}

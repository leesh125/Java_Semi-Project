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
		
		HttpSession session = request.getSession();
		try {
			MultipartRequest multi = new MultipartRequest(request ,
					request.getServletContext().getRealPath("/upload"), // 실제 경로
					1024 * 1024 * 10 , 
					"utf-8", 
					new DefaultFileRenamePolicy());
			
			String review_fileName = multi.getFilesystemName("review_fileName");
			// 원래 파일명
			String review_filerealName = multi.getOriginalFileName("review_fileName");
								
			if(multi.getFilesystemName("review_fileName") != null) {
				String id = multi.getParameter("review_id");
				int review_id = Integer.parseInt(id);
				String user_name = (String) session.getAttribute("login_name");; 
				String review_title = multi.getParameter("review_title");
				String review_context = multi.getParameter("review_context");
				review_fileName = multi.getFilesystemName("review_fileName");
				ReviewDTO dto = new ReviewDTO(review_id,review_fileName, review_context,review_title,user_name);
			
				boolean res = false;
				
				if (review_id != 0) {
					res = service.updateReview(dto);
					if(res) {
						System.out.println("update post 성공 후 review 목록 페이지로 !");
						response.sendRedirect("/review");
					}else {
						System.out.println("Reivew 수정 실패! - controller에서");
					}
				
				}else {
					response.sendRedirect("/review");
					System.out.println("파일 업로드 실패!!");
				}
			}
		}catch (IOException e) {
			String view ="/WEB-INF/review/re_write.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			request.setAttribute("error", "제한 용량 초과(10k)");
			rd.forward(request, response);
		}
		
		
	}
	
}

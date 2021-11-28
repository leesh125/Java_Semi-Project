package com.web.register.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.web.register.model.*;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String view = "/WEB-INF/jsp/register/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		rp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
			request.setCharacterEncoding("UTF-8");
			String password_check = request.getParameter("password_check");
			
			RegisterDTO dto = new RegisterDTO(
					request.getParameter("userid"),
					request.getParameter("password"),
					request.getParameter("username"),
					request.getParameter("email"),
					request.getParameter("gender"),
					Integer.parseInt(request.getParameter("height")),
	                Integer.parseInt(request.getParameter("weight"))
	                );
					
		    RegisterService service = new RegisterService(dto);
		    
		  //중복이면 제출한 양식 포워드 비번 뺴고 초기화 시켜서 포워드
			request.setAttribute("initData", dto);
			
			String view = "/WEB-INF/jsp/register/index.jsp";
			RequestDispatcher rp = request.getRequestDispatcher(view);
		    //포워드 시켜주는 로직 매번 쓰면 길어지니깐 여기에 빼둠
		    
		    if(service.isValid() == null) { //유효성 검사가 통과 되지 않으면
		    
		    	if(service.equalPassword(password_check)) {
		    	
		    		if(service.isDuplicated()) { 
		    			rp.forward(request, response);
		    	
		    		}else {
		    			service.createRegiser();
		    			response.sendRedirect("/"); //가입완료되면 여기로 이동
		    		}
		    			}else { 
			    			rp.forward(request, response);
		    	
		    			}
		    			}else {

			    		rp.forward(request, response);
		    				
        }
       }
   }
	
		
	


		
		
		
		
//		
//		
//		
//		
//		String userid = request.getParameter("userid");
//		String password = request.getParameter("password");
//		String password_check = request.getParameter("password_check");
//		String username = request.getParameter("username");
//		String email = request.getParameter("email");
//		String gender = request.getParameter("gender");
//		int height = Integer.parseInt(request.getParameter("height"));
//		int weight = Integer.parseInt(request.getParameter("weight"));
//		
//		System.out.println(userid);
//		System.out.println(password);
//		System.out.println(password_check);
//		System.out.println(username);
//		System.out.println(email);
//		System.out.println(gender);
//		System.out.println(height);
//		System.out.println(weight);
	
		


		
		
		


package com.web.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.login.model.LoginDTO;
import com.web.login.model.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/login/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		rp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDTO dto = new LoginDTO(
				request.getParameter("username"),
				request.getParameter("password"));
		LoginService service = new LoginService(dto);
		
		String view = "/WEB-INF/jsp/login/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		
		
		if(service.isExist()) { // 아이디가 존재할 경우
			if(service.eqaulPass()) { // 패스워드가 일치할 경우
//				Cookie cookie = new Cookie("login_name", dto.getUsername());
//				cookie.setMaxAge(60 * 30); // 만료시간 설정
//				response.addCookie(cookie);
				
				// true : 이미 세션정보가 있으면 있는 정보로 반환하고 없으면 새로 생성한다.
				// false : 이미 세션정보가 있으면 있는 정보로 반환하고 없으면 null로 반환한다.
				HttpSession session = request.getSession();
				session.setAttribute("login_name", dto.getUsername());
				
				response.sendRedirect("/");
			}else { // 패스워드 일치하지 않을 경우
				request.setAttribute("login_error","패스워드를 잘못 입력했습니다.");
				rp.forward(request, response);
			}
		}else { // 아이디가 존재하지 않을 경우
			request.setAttribute("login_error","아이디를 잘못 입력했습니다.");
			rp.forward(request, response);
			System.out.println("아이디 없음!");
		}
	}

}

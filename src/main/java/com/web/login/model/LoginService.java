package com.web.login.model;

import com.web.login.model.LoginDAO;

public class LoginService {
	LoginDTO dto = null;
	
	public LoginService() {
		
	}

	public LoginService(LoginDTO dto) {
		this.dto = dto;
	}

	public boolean isExist() {
		LoginDAO dao = new LoginDAO();
		LoginDTO data = dao.select(this.dto.getUsername());
		dao.close();

		if(data == null) {
			return false;	// 아이디 존재하지 않음
		}
		return true;	// 아이디 존재함
	}

	public boolean eqaulPass() {
		LoginDAO dao = new LoginDAO();
		LoginDTO data = dao.select(this.dto.getUsername(),this.dto.getPassword());
		dao.close();

		if(data == null) {
			return false;	// 아이디 없음
		}
		return true;	// 아이디 있음
	}

}

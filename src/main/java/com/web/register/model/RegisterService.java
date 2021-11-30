package com.web.register.model;

public class RegisterService {
	
	RegisterDTO dto = null;
	
	public RegisterService() {}
	
	public RegisterService(RegisterDTO dto) {
		this.dto = dto;
	}

	public String isValid() { //필수입력 체크 만약 길이나 특수문자 그런거 더 하고 싶으면 여기에 넣어주면 된다.
			if(this.dto.getPassword() == null) {
				return ("패스워드가 입력되지 않았습니다.");
			}else if(this.dto.getUsername() == null) {
				return ("이름이 입력되지 않았습니다.");
			}else if (this.dto.getEmail() == null) {
				return ("이메일이 입력되지 않았습니다.");
			}else if (this.dto.getGender() == null) {
				return ("성별을 선택하세요.");
		
			}else {
				return null;
			}
	}

	public boolean equalPassword(String password_check) {
		return this.dto.getPassword().equals(password_check);
		
		
	}

	public boolean isDuplicated() {
		//여기서 데이터베이스 쪽 필요 DAO
		RegisterDAO dao = new RegisterDAO();
		RegisterDTO data = dao.select(this.dto.getUsername());
		dao.close();
		
		return data != null ? true : false;
		}
	

	public boolean createRegiser() {
		RegisterDAO dao = new RegisterDAO();
		boolean res = dao.insert(this.dto);
		if(res) {
			dao.commit();
		}else {
			dao.rollback();
		}
		dao.close();
			return res;
	}
}

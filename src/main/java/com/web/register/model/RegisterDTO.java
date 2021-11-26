package com.web.register.model;
	
	public class RegisterDTO  {
		private String userid;
		private String password;
		private String username;
		private String email;
		private String gender;
		private int height;
		private int weight;
		
		
		public RegisterDTO () {
			this("","","","","");
		}
		
		public RegisterDTO(String id) {
			this.username = userid;
		}
		public RegisterDTO(String userid, String password) {
			this.userid = userid;
			this.password = password;
		}
		public RegisterDTO(String userid, String password, String username,String email, String gender) {
			this(userid, password);
			this.username = username;
			this.email = email;
			this.gender = gender;
		}
		public RegisterDTO(String userid, String password, String username,String email, String gender,int height, int weight) {
			this(userid, password,username,email,gender);
			this.height= height;
			this.weight = weight;
		}

		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
	}



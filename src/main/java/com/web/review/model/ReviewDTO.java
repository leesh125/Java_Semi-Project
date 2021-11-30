package com.web.review.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewDTO {
	private int review_id; //글 번호
	private String review_fileName; // 파일
	private String review_title =""; // 리뷰 제목
	private String review_context =""; // 리뷰 내용
	private Date review_date; // 작성일
	private int views; // 조회수
	private String username; // 
	


	// 기본 생성자
	public ReviewDTO() {}
	
	public ReviewDTO(int review_id, String username) {
		this.review_id = review_id;
		this.username = username;
	}
	public ReviewDTO(int review_id) {
		this.review_id = review_id;
	}
	
	public ReviewDTO(int review_id, int views) {
		this.review_id = review_id;
		this.views = views;
	}
	public ReviewDTO(String review_title, String review_context) {
		this.review_title = review_title;
		this.review_context = review_context;
	}
	public ReviewDTO(int review_id, String review_title, String review_context) {
		this.review_id = review_id;
		this.review_title = review_title;
		this.review_context = review_context;
	}
	
	public ReviewDTO(String review_fileName, String review_title, String review_context, String username) {
		this.review_fileName = review_fileName;
		this.review_title = review_title;
		this.review_context = review_context;
		this.username = username;
	}
	
	public ReviewDTO(int review_id,String review_fileName, String review_context, String review_title, String username) {
		this.review_id = review_id;
		this.review_fileName = review_fileName;
		this.review_context = review_context;
		this.review_title = review_title;
		this.username = username;
	}
	public ReviewDTO(String review_title, String review_context, String username) {
		this.review_title = review_title;
		this.review_context = review_context;
		this.username = username;
	}

	public int getReview_id() {
		return this.review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	
	public String getReview_title() {
		return this.review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	
	public String getReview_context() {
		return this.review_context;
	}
	public void setReview_context(String review_context) {
		this.review_context = review_context;
	}
	
	public Date getReview_date() {
		return this.review_date;
	}
	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	
	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getReview_fileName() {
		return review_fileName;
	}

	public void setReview_fileName(String review_fileName) {
		this.review_fileName = review_fileName;
	}

	public void setResultSet(ResultSet res) throws SQLException {
		this.review_id = res.getInt("review_id");
		this.review_fileName = res.getString("review_fileName");
		this.review_title = res.getString("review_title");
		this.review_context = res.getString("review_context");
		this.review_date = res.getDate("review_date");
	}
}

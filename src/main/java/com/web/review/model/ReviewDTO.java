package com.web.review.model;

import java.sql.Date;

public class ReviewDTO {
	private int review_id; //글 번호
	private String review_title =""; // 리뷰 제목
	private String review_context =""; // 리뷰 내용
	private Date review_date; // 작성일
	
	// 기본 생성자
	public ReviewDTO() {}
	
	
	public ReviewDTO(String review_title, String review_context) {
		this.review_title = review_title;
		this.review_context = review_context;
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
	
	
	
	
	
	
}

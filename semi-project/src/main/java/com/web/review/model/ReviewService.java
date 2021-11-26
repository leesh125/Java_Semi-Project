package com.web.review.model;

import java.sql.SQLException;
import java.util.List;

public class ReviewService {
	ReviewDAO dao = null;
	//리뷰 추가(등록)
	
	public ReviewService() {
		try {
			this.dao = new ReviewDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean add(ReviewDTO dto) {
		try {
			if(dao.insert(dto)) {
				dao.commit();
				return true;
			}else {
				dao.rollback();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	// 리뷰 리스트 뽑아서 조회하기(리뷰 목록 페이지에 나올 수 있게)
	public List<ReviewDTO> getReviewList() {
		List<ReviewDTO> datas = null;
		
		try {
		    datas = dao.select(); // select로 조회
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
		
	}

	
	
}

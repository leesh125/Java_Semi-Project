package com.web.review.model;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	
	// 리뷰 상세조회를 위해
	public ReviewDTO getReviewId(int review_id) {
		ReviewDTO datas = null;
		try {
			if(dao.UpdateViews(review_id)) {
				dao.commit();
			}else {
				dao.rollback();
			}
		    datas = dao.select(review_id); // select로 조회
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
		
	}
	
	
	// 리뷰 삭제를 위해
	public boolean delete(ReviewDTO dto) {
		// 기존에 저장된 데이터 조회
		// 조회된 데이터를 확인 후 삭제
		ReviewDTO data = getReviewId(dto.getReview_id());
		boolean res = false;
		
		if(data.getReview_id() != 0) {
			res = dao.delete(data);
		}
		try {
			if(res) {
				dao.commit();
			}else {
				dao.rollback();
			}
			dao.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public boolean updateReview(ReviewDTO dto) {
		boolean res = false;
		res = dao.updateReivew(dto);
		System.out.println("res = " + res);
		if(dto.getReview_id() != 0) {
			try {
				if(res) {
					dao.commit();
				}else {
					dao.rollback();
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("update 실패! - service에서");
		}
		return res;
	}

	

	
}
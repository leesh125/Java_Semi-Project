package com.web.review.model;

import java.sql.SQLException;
import java.util.List;


public class ReviewService {
	ReviewDAO dao = null;
	//리뷰 추가(등록)

	public ReviewService() {
		this.dao = new ReviewDAO();
	}

	public boolean add(ReviewDTO dto) {	
			boolean res = dao.insert(dto);
			if(res) {
				dao.commit();
			}else {
				dao.rollback();
			}
			dao.close();
			return res;
	}

	// 리뷰 리스트 뽑아서 조회하기(리뷰 목록 페이지에 나올 수 있게)
	public List<ReviewDTO> getReviewList() {
		List<ReviewDTO> datas = dao.select(); // select로 조회
		dao.close();
		return datas;
	}
	
	// 수정된 데이터 조회
	public boolean modify(ReviewDTO dto) {
		// 기존에 저장된 데이터를 조회해야 한다.	
		//조회한 데이터에 수정된 데이터로 교체
		// 교체된 데이터로 저장
		
		ReviewDTO data = getData(dto.getReview_id());
		data.setReview_title(dto.getReview_title());
		data.setReview_context(dto.getReview_context());
		
		return update(data);
		
	}
	
	public boolean delete(ReviewDTO dto) {
		// 기존에 저장된 데이터 조회
		// 조회된 데이터를 확인 후 삭제
		ReviewDTO data = getData(dto.getReview_id());
		boolean res = false;
		dao = new ReviewDAO();
		if(data.getReview_id() != 0) {
			res = dao.delete(data);
		}
		if(res) {
			dao.commit();
		}else {
			dao.rollback();
		}
		dao.close();
		return res;
	}
	
	
	
	
	
	// 기존 데이터 조회
	public ReviewDTO getData(int review_id) {
		dao = new ReviewDAO();
		ReviewDTO data = dao.select(review_id);
		return data;
	}
	
	
	public boolean update(ReviewDTO dto) {
		dao = new ReviewDAO();
		boolean res = dao.update(dto);
		
		if(res) { //업뎃 되면 저장
			dao.commit();;
			return true;
		}else { // 업뎃 실패시 롤백
			dao.rollback();	
		}
		dao.close();
		return res;
	
	}
	
}

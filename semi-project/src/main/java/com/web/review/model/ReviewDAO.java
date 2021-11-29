package com.web.review.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspweb.dbconn.OracleCloudConnect;


public class ReviewDAO {
	OracleCloudConnect occ = null;
	//service에서 작업하기 위해 insert 추가

	public ReviewDAO(){
        try {
			this.occ = new OracleCloudConnect();
			this.occ.connection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
	}
	
	// db에서 테이블 조회
		public List<ReviewDTO> select(){
			// while로 가져온 값을 datas에 담기
			List<ReviewDTO> datas = new ArrayList<ReviewDTO>();

			// db에서 review 테이블 조회
			String query = "SELECT * FROM REVIEW ORDER BY REVIEW_DATE DESC";
			ResultSet res;
			try {
				res = occ.sendQuery(query);
				//db에서 각각의 컬럼 값 가져오기
				while(res.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setReview_id(res.getInt("review_id"));;
				dto.setReview_title(res.getString("review_title"));;
				dto.setReview_context(res.getString("review_context"));;
				dto.setReview_date(res.getDate("review_date"));;
				datas.add(dto);
			}
				res.close();
				occ.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return datas;
		}

		
		public ReviewDTO select(int review_id) {
			ReviewDTO dto = new ReviewDTO();
			String query = "SELECT * FROM REVIEW"
					+ " WHERE REVIEW_ID = " + review_id;
			
			try {
				ResultSet res = occ.sendQuery(query);
				res.next();
				dto.setResultSet(res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return dto;
		}
		


		// 데이터 베이스 추가
		public boolean insert(ReviewDTO dto) {
			String query = "INSERT INTO REVIEW VALUES("
					+ "REVIEW_SEQ.NEXTVAL,"
					+ "'" + dto.getReview_title() +"',"
					+ "'" + dto.getReview_context()+ "',"
					+ "SYSDATE"
					+ ")";
			int res = 0;
		
			try {
				res = occ.insertQuery(query);
				occ.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return res == 1 ? true : false;
	    }

		// 수정 하기
		public boolean update(ReviewDTO dto) {
			String query = "UPDATE REVIEW"
					+ "  SET"
					+ "		REVIEW_TITLE = '" +  dto.getReview_title() + "',"
					+ "		REVIEW_CONTEXT = '" + dto.getReview_context() + "'"
					+ "		WHERE REVIEW_ID = " + dto.getReview_id() + "";
			
			int res = 0;
			try {
				res = occ.updateQuery(query);
				occ.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return res == 1 ? true : false;
			
		}
		
		
		public boolean delete(ReviewDTO dto) {
			String query = "DELETE FROM REVIEW"
					+ " WHERE REVIEW_ID = " + dto.getReview_id() + "";
			
			int res = 0;
			try {
				res = occ.deleteQuery(query);
				occ.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return res == 1 ? true : false;
		}
		
		
		
	   public void commit(){
	    	try {
				occ.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }

	    public void rollback(){
	    	try {
				occ.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    
	    
	    public void close() {
	    	try {
				occ.connectionClose();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
}

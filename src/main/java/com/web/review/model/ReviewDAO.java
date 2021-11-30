package com.web.review.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspweb.dbconn.OracleCloudConnect;

public class ReviewDAO {
	OracleCloudConnect occ = null;
	//service에서 작업하기 위해 insert 추가
	
	public ReviewDAO() throws SQLException {
        this.occ = new OracleCloudConnect();
        this.occ.connection();
    }
	
	
	// db에서 테이블 조회
	public List<ReviewDTO> select() throws SQLException {
		// while로 가져온 값을 datas에 담기
		List<ReviewDTO> datas = new ArrayList<ReviewDTO>();
				
		// db에서 review 테이블 조회
		String query = "SELECT * FROM SEMI_REVIEW ORDER BY REVIEW_DATE DESC";
		ResultSet res = occ.sendQuery(query);
		
		
		//db에서 각각의 컬럼 값 가져오기
		while(res.next()) {
			ReviewDTO dto = new ReviewDTO();
			dto.setReview_id(res.getInt("review_id"));;
			dto.setReview_title(res.getString("review_title"));;
			dto.setReview_context(res.getString("review_context"));;
			dto.setReview_date(res.getDate("review_date"));;
			dto.setViews(res.getInt("views"));
			dto.setUsername(res.getString("username"));
			dto.setReview_fileName(res.getString("review_fileName"));
			datas.add(dto);
		}
		
		res.close();
		occ.close();
		
		return datas;
	}

	// 조회수가 가장 높은 데이터 하나만 반환
	public ReviewDTO selectTopViews() throws SQLException {
		ReviewDTO dto = new ReviewDTO();
		// db에서 review 테이블 조회
		String query = "SELECT * "
					   + "FROM"
					   + "("
					   + "	SELECT *"
					   + "	  FROM SEMI_REVIEW"
					   + "   ORDER BY VIEWS DESC, REVIEW_DATE DESC"
					   + ")"
					   + "WHERE ROWNUM <= 1";
		ResultSet res = occ.sendQuery(query);
		
		
		//db에서 각각의 컬럼 값 가져오기
		while(res.next()) {
			dto.setReview_id(res.getInt("review_id"));;
			dto.setReview_title(res.getString("review_title"));;
			dto.setReview_context(res.getString("review_context"));;
			dto.setReview_date(res.getDate("review_date"));;
			dto.setViews(res.getInt("views"));
			dto.setUsername(res.getString("username"));
			dto.setReview_fileName(res.getString("review_fileName"));
		}
		
		res.close();
		occ.close();
		
		return dto;
	}
	
	// 리뷰 상세조회를 위해(id 별)
	public ReviewDTO select(int review_id) throws SQLException {
		// while로 가져온 값을 datas에 담기
		ReviewDTO dto = new ReviewDTO();
				
		// db에서 review 테이블 조회
		String query = "SELECT * FROM SEMI_REVIEW"
				+ " WHERE REVIEW_ID = " + review_id;
		ResultSet res = occ.sendQuery(query);
		
		
		//db에서 각각의 컬럼 값 가져오기
		while(res.next()) {
			dto.setReview_id(res.getInt("review_id"));;
			dto.setReview_title(res.getString("review_title"));;
			dto.setReview_context(res.getString("review_context"));;
			dto.setReview_date(res.getDate("review_date"));;
			dto.setViews(res.getInt("views"));;
			dto.setUsername(res.getString("username"));
			dto.setReview_fileName(res.getString("review_fileName"));
		}
		res.close();
		occ.close();
		
		return dto;
	}
	
	public boolean UpdateViews(int review_id) throws SQLException {
		String query = "UPDATE SEMI_REVIEW"
				+ " SET VIEWS = VIEWS+1"
				+ " WHERE REVIEW_ID = " + review_id;
		
		int res = -1;
		
		res = occ.insertQuery(query);
		
		if (res == 1) {
			return true;
		}
		return false;
	}
	
	public boolean UpdateViews(int review_id, String username) throws SQLException {
		String query = "UPDATE SEMI_REVIEW"
				+ " SET VIEWS = VIEWS+1"
				+ " WHERE REVIEW_ID = " + review_id
				+ " AND USERNAME = '" + username + "'";
		
		int res = -1;
		
		res = occ.insertQuery(query);
		
		if (res == 1) {
			return true;
		}
		return false;
	}
	
	// 데이터 베이스 추가
	public boolean insert(ReviewDTO dto) throws SQLException {
		String query = "INSERT INTO SEMI_REVIEW VALUES("
				+ "SEMI_REVIEW_SEQ.NEXTVAL,"
				+ "'" + dto.getReview_title() +"',"
				+ "'" + dto.getReview_context()+ "',"
				+ "SYSDATE,"
				+ dto.getViews() + ","
				+ "'" + dto.getUsername() + "',"
				+ "'" + dto.getReview_fileName() + "'"
				+ ")";
		int res = occ.insertQuery(query);
		
		if(res == 1) {
			return true;
		}
		return false;
    }
	
	// review 테이블에 userid 외래키 값 수정
	
	// 리뷰 수정하기
	public boolean updateReivew(ReviewDTO dto) {
		String query = "UPDATE SEMI_REVIEW"
				+ "  SET"
				+ "    REVIEW_FILENAME = '" + dto.getReview_fileName() + "',"
				+ "    REVIEW_TITLE = '" + dto.getReview_title() + "',"
				+ "    REVIEW_CONTEXT = '" + dto.getReview_context() +"'"
				+ "  WHERE REVIEW_ID = " + dto.getReview_id();
		
		int res = 0;
		
		try {
			res = occ.updateQuery(query);
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("update 실패! - dao에서");
		}
    	return res == 1 ? true : false;
		
	}
	
	// 리뷰 삭제하기
	public boolean delete(ReviewDTO dto) {
		String query = "DELETE FROM SEMI_REVIEW"
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
	
   public void commit() throws SQLException {
    	occ.commit();
    }
    
    public void rollback() throws SQLException {
    	occ.rollback();
    }

    public void close() throws SQLException {
    	occ.connectionClose();
    }
	
	
}
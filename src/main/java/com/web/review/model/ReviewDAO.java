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
		String query = "SELECT * FROM REVIEW ORDER BY REVIEW_DATE DESC";
		ResultSet res = occ.sendQuery(query);
		
		
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
		
		return datas;
	}
	
	
	
	// 데이터 베이스 추가
	public boolean insert(ReviewDTO dto) throws SQLException {
		String query = "INSERT INTO REVIEW VALUES("
				+ "REVIEW_SEQ.NEXTVAL,"
				+ "'" + dto.getReview_title() +"',"
				+ "'" + dto.getReview_context()+ "',"
				+ "SYSDATE"
				+ ")";
		int res = occ.insertQuery(query);
		
		if(res == 1) {
			return true;
		}
		return false;
    }
	
	
	
   public void commit() throws SQLException {
    	occ.commit();
    }
    
    public void rollback() throws SQLException {
    	occ.rollback();
    }
	
	
	
}

		    
	


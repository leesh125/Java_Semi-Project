package com.web.register.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspweb.dbconn.OracleCloudConnect;


public class RegisterDAO {
		
		OracleCloudConnect occ;
		
		public RegisterDAO() {
			
			try {
				this.occ = new OracleCloudConnect();
				this.occ.connection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public RegisterDTO select(String userid) {
			String query = "SELECT * FROM JOINUSERS"
					+ " WHERE USERID = '" + userid + "'";
			RegisterDTO data = null;
			
			try {
				ResultSet res = this.occ.sendQuery(query);
				
				if(res.next()) {
					data = new RegisterDTO(
							res.getString("USERID"),
							res.getString("PASSWORD"),
							res.getString("USERNAME"),
							res.getString("EMAIL"),
							res.getString("GENDER"),
							res.getInt("height"),
							res.getInt("weight"));
				}
				res.close();
				occ.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return data;
		}

		public void close() {
			try {
				occ.connectionClose();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public boolean insert(RegisterDTO dto) {
			String query = "INSERT INTO JOINUSERS VALUES("
					+ "JOINUSERS_SEQ.NEXTVAL,"
					+ "'" + dto.getPassword() + "',"
					+ "'" + dto.getUsername() + "',"
					+ "'" + dto.getEmail() + "',"
					+ "'" + dto.getGender() + "',"
					+ "'" + dto.getHeight() + "',"
					+ "'" + dto.getWeight() + "')";
							
		
			int res = 0;
			try {
				res = occ.insertQuery(query);
				occ.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
			return res == 1? true : false;
		}

		public void commit() {
			try {
				occ.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void rollback() {
			try {
				occ.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 
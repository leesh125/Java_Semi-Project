package com.web.login.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspweb.dbconn.OracleCloudConnect;

public class LoginDAO {
	OracleCloudConnect occ;

	public LoginDAO() {
		try {
			this.occ = new OracleCloudConnect();
			this.occ.connection();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO 생성자 동작에 에러 발생");
		}
	}

	public LoginDTO select(String username) {
		String query = "SELECT * FROM SEMI_USERS"
				+ " WHERE USERNAME = '" + username + "'";
		LoginDTO data = null;
		try {
			ResultSet res = this.occ.sendQuery(query);

			if(res.next()) {
				data = new LoginDTO(
						res.getInt("USERID"),
						res.getString("PASSWORD"),
						res.getString("USERNAME"));
			}
			res.close();
			occ.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO select 메서드 동작에 에러 발생");
		}

		return data;
	}
	
	public LoginDTO select(String username, String password) {
		String query = "SELECT * FROM SEMI_USERS"
				+ " WHERE USERNAME = '" + username + "'"
				+ "   AND PASSWORD = '" + password + "'";
		LoginDTO data = null;
		try {
			ResultSet res = this.occ.sendQuery(query);

			if(res.next()) {
				data = new LoginDTO(
						res.getInt("USERID"),
						res.getString("USERNAME"),
						res.getString("PASSWORD"));
			}
			res.close();
			occ.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO select 메서드 동작에 에러 발생");
		}

		return data;
	}
	
	public void close() {
		try {
			occ.connectionClose();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO close 메서드 동작에 에러 발생");
		}
	}
	
	public void commit() {
		try {
			occ.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO commit 메서드 동작에 에러 발생");
		}
	}

	public void rollback() {
		try {
			occ.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO rollback 메서드 동작에 에러 발생");
		}
	}
}

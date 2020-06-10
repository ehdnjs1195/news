package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.news.util.DbcpBean;
import com.news.vo.UsersVO;

public class UsersDAO {

	private static UsersDAO dao = new UsersDAO();
	private UsersDAO() {}
	public static UsersDAO getInstance() {
		return dao;
	}
	
	//회원가입
	public boolean usersInsert(UsersVO users) {
		DbcpBean db = new DbcpBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = db.getConn();
			String sql = "insert into users"
					+ " (user_id,user_pwd,user_email,user_name,regdate)"
					+ " values(?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩하기
			pstmt.setString(1, users.getUser_id());
			pstmt.setString(2, users.getUser_pwd());
			pstmt.setString(3, users.getUser_email());
			pstmt.setString(4, users.getUser_name());
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(conn, pstmt);
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
}

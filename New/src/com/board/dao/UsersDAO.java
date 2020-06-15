package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.board.util.DbcpBean;
import com.board.util.Pager;
import com.board.vo.UsersVO;

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
			String sql = "insert into board_user"
					+ " (user_id,user_pwd,user_email,user_name,user_regdate)"
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
	//회원 한 명의 정보 가져오기
	public UsersVO getUser(String user_id) {
		UsersVO vo = new UsersVO();
		DbcpBean db = new DbcpBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DbcpBean().getConn();
			String sql = "SELECT * FROM board_user"
					+ "	WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩 
			pstmt.setString(1,user_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo.setUser_id(rs.getString("user_id"));
				vo.setUser_pwd(rs.getString("user_pwd"));
				vo.setUser_name(rs.getString("user_name"));
				vo.setUser_email(rs.getString("user_email"));
				vo.setUser_authority_code(rs.getString("user_authority_code"));
				vo.setUser_state_code(rs.getString("user_state_code"));
				vo.setUser_regdate(rs.getString("user_regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(conn, pstmt, rs);
			} catch (Exception e) {
			}
		}
		return vo;
	}
	
	//로그인 체크하기
	public UsersVO loginCheck(String user_id, String user_pwd) {
		UsersVO vo = null;
		DbcpBean db = new DbcpBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DbcpBean().getConn();
			String sql = "SELECT * FROM board_user"
					+ " WHERE user_id =? and user_pwd =?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩 
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pwd);			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new UsersVO();
				vo.setUser_id(rs.getString("user_id"));
				vo.setUser_authority_code(rs.getString("user_authority_code"));
				vo.setUser_email(rs.getString("user_email"));
				vo.setUser_name(rs.getString("user_name"));
				vo.setUser_regdate(rs.getString("user_regdate"));
				vo.setUser_state_code(rs.getString("user_state_code"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(conn, pstmt, rs);
			} catch (Exception e) {
			}
		}
		return vo;
	}
	
	//아이디 찾기
	public String getUserId(String user_name, String user_email) {
		DbcpBean db = new DbcpBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String user_id =null;
		try {
			conn = new DbcpBean().getConn();
			String sql = "SELECT user_id FROM board_user"
					+ " WHERE user_name = ? and user_email =?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩 
			pstmt.setString(1, user_name);
			pstmt.setString(2, user_email);			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user_id = rs.getString("user_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(conn, pstmt, rs);
			} catch (Exception e) {
			}
		}
		
		return user_id;
	}
	
	//회원 비밀번호 찾기
	public boolean getUserPwd(UsersVO vo) {
		DbcpBean db = new DbcpBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean findPwd = false;
		try {
			conn = new DbcpBean().getConn();
			String sql = "SELECT user_pwd FROM board_user"
					+ " WHERE user_id = ? AND user_name=? AND user_email=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩 
			pstmt.setString(1, vo.getUser_id());
			pstmt.setString(2, vo.getUser_name());
			pstmt.setString(3, vo.getUser_email());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				findPwd = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(conn, pstmt, rs);
			} catch (Exception e) {
			}
		}
		return findPwd;
	}
	
	//비밀번호 변경하기
	public boolean updatePwd(String user_id, String user_pwd) {
		DbcpBean db = new DbcpBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = db.getConn();
			String sql = "UPDATE board_user"
					+ " SET user_pwd = ?"
					+ " WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩하기
			pstmt.setString(1, user_pwd);
			pstmt.setString(2, user_id);
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
	//회원 목록 가져오기 (페이징)
	public List<UsersVO> getUserList(Pager pager) {
		DbcpBean db = new DbcpBean();
		List<UsersVO> userList = new ArrayList<>();
		UsersVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DbcpBean().getConn();
			String sql = "SELECT * FROM "
					+ " (SELECT result1.*, ROWNUM AS rnum"
					+ " FROM ("
					+ " SELECT *"
					+ " FROM board_user"
					+ " ORDER BY user_regdate DESC) result1)"
					+ " WHERE rnum BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩 
			
			pstmt.setInt(1, pager.getStartList());
			pstmt.setInt(2, pager.getEndList());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new UsersVO();
				vo.setUser_id(rs.getString("user_id"));
				vo.setUser_name(rs.getString("user_name"));
				vo.setUser_email(rs.getString("user_email"));
				vo.setUser_regdate(rs.getString("user_regdate"));
				vo.setUser_state_code(rs.getString("user_state_code"));
				vo.setUser_authority_code(rs.getString("user_authority_code"));
				userList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(conn, pstmt, rs);
			} catch (Exception e) {
			}
		}
		
		return userList;
	}
	
	//게시글 작성자와 아이디 비교하기
	public UsersVO getBoardWriter(String user_id) {
		DbcpBean db = new DbcpBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		UsersVO vo = new UsersVO();
		try {
			conn = new DbcpBean().getConn();
			String sql = "SELECT user_id, user_authority_code "
					+ " FROM board_user u JOIN board b"
					+ " ON u.user_id = b.board_writer"
					+ " WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩 
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo.setUser_id(rs.getString("user_id"));
				vo.setUser_authority_code(rs.getString("user_authority_code"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(conn, pstmt, rs);
			} catch (Exception e) {
			}
		}
		return vo;
	}
	

	//회원 전체 리스트를 가져오는 메소드
	public int getUserCnt() {
		DbcpBean db = new DbcpBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = new DbcpBean().getConn();
			String sql = "SELECT count(*) cnt FROM board_user";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩 

			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(conn, pstmt, rs);
			} catch (Exception e) {
			}
		}
		return count;
	}
}

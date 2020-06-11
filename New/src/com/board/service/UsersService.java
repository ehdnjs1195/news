package com.board.service;

import java.util.List;

import com.board.dao.UsersDAO;
import com.board.vo.UsersVO;

public class UsersService {

	private static UsersService service = new UsersService();
	public UsersDAO dao = UsersDAO.getInstance();
	
	private UsersService() {}
	public static UsersService getInstance() {
		return service;
	}
	//회원가입
	public void usersInsert(UsersVO users) {
		dao.usersInsert(users);
	}
	public boolean checkId(String user_id) {
		UsersVO vo = dao.getUser(user_id);
		if(vo != null) {	//id 사용불가능
			return true;
		}else {
			return false;	//id 사용가능
		}
	}
	//로그인
	public UsersVO loginCheck(String user_id, String user_pwd) {
		UsersVO vo = dao.loginCheck(user_id, user_pwd);
		if(vo != null) {	//로그인 처리	
			return vo;
		} else {
			return null;
		}
	}
	//아이디 찾기
	public String findUserId(String user_name, String user_email) {
		return dao.getUserId(user_name, user_email);
	}
	//비밀번호 찾기
	public boolean findUserPwd(UsersVO vo) {
		return dao.getUserPwd(vo);
	}
	//비밀번호 변경
	public boolean updatePwd(String user_id, String user_pwd) {
		return dao.updatePwd(user_id, user_pwd);
	}
	//회원 목록 가져오기
	public List<UsersVO> getUserList() {
		return dao.getUserList();
	}
	
}

package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.service.UsersService;
import com.board.vo.UsersVO;

public class UsersLoginController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id, pwd 받기
		String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");	
		//vo객체에 담기
		UsersVO vo = new UsersVO();
		vo.setUser_id(user_id);
		vo.setUser_pwd(user_pwd);
		
		// 아이디 확인하기
		UsersService service = UsersService.getInstance();
		vo = service.loginCheck(user_id, user_pwd);
		
		//로그인 처리하기
		HttpSession session = req.getSession();
		if(vo != null) {
			session.setAttribute("user_id", vo.getUser_id());
			session.setAttribute("user_authority", vo.getUser_authority_code());
			req.setAttribute("loginCheck", vo.getUser_id() + "님 로그인 되었습니다.");
			HttpUtil.forward(req, resp, "/users/login.jsp");
		}else {
			req.setAttribute("loginCheck", "아이디 혹은 비밀번호 정보가 틀립니다.");
			HttpUtil.forward(req, resp, "/users/login.jsp");
		}
	}
}

package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.UsersService;
import com.board.vo.UsersVO;

public class UsersFindPwdController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 추출하기
		String user_id = req.getParameter("user_id");
		String user_name = req.getParameter("user_name");
		String user_email = req.getParameter("user_email");
		UsersVO vo = new UsersVO();
		vo.setUser_id(user_id);
		vo.setUser_name(user_name);
		vo.setUser_email(user_email);
		
		if(user_id.isEmpty() || user_name.isEmpty() || user_email.isEmpty()) {
			req.setAttribute("error", "정보를 모두 입력해주세요");
			HttpUtil.forward(req, resp, "findUserPwd.jsp");
		}
		
		//비밀번호 찾기
		UsersService service = UsersService.getInstance();
		boolean isExistPwd = service.findUserPwd(vo);
		
		//페이지 이동
		if(isExistPwd) {	//true 이면 비밀번호를 찾은것 이므로 비밀번호 변경 화면으로 이동
			req.setAttribute("user_id", user_id);
			HttpUtil.forward(req, resp, "changeUserPwd.jsp");			
		}else {
			req.setAttribute("error", "비밀번호를 찾을 수 없습니다.");
			HttpUtil.forward(req, resp, "findUserPwd.jsp");
		}
	}
}

package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.UsersService;

public class UsersChangePwdController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//비밀번호 읽어오기
		String user_pwd = req.getParameter("user_pwd");
		String user_pwd2 = req.getParameter("user_pwd2");
		String user_id = req.getParameter("user_id");
		UsersService service = UsersService.getInstance();
		//일치 확인
		if(user_pwd.equals(user_pwd2)) {	//일치하면 비밀번호 변경
			boolean findPwd = service.updatePwd(user_id, user_pwd);
			if(findPwd) {
				HttpUtil.forward(req, resp, "resultChangePwd.jsp"); //변경 확인 화면으로 이동
			}
		}else {	//일치하지 않으면 불일치 표시
			req.setAttribute("error", "비밀번호가 일치하지 않습니다.");
			HttpUtil.forward(req, resp, "changeUserPwd.jsp");
		}
	}
}

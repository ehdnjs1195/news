package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.UsersService;

public class UsersFindIdController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 추출
		String user_name = req.getParameter("user_name");
		String user_email = req.getParameter("user_email");
		
		if(user_name.isEmpty() || user_email.isEmpty()) {
			req.setAttribute("error", "정보를 모두 입력해주세요");
			HttpUtil.forward(req, resp, "findUserId.jsp");
		}
		//id 찾아오기
		UsersService service = UsersService.getInstance();
		String user_id = service.findUserId(user_name, user_email);

		if(user_id != null) {	//id를 찾은경우
			req.setAttribute("user_id", user_id);
			req.setAttribute("result", true);
			HttpUtil.forward(req, resp, "resultUserId.jsp");
		} else {
			req.setAttribute("result", false);
			HttpUtil.forward(req, resp, "resultUserId.jsp");
		}
		
	}

}

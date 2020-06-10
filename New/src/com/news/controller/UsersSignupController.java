package com.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.service.UsersService;
import com.news.vo.UsersVO;

public class UsersSignupController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 추출
		String id=req.getParameter("user_id");
		String pwd = req.getParameter("user_pwd");
		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		//유효성 체크
		if(id.isEmpty() || pwd.isEmpty() || name.isEmpty() || email.isEmpty()) {
			req.setAttribute("error", "모든 항목을 빠짐없이 입력해 주세요.");
			HttpUtil.forward(req, resp, "/users/signupForm.jsp");
			return;
		}
		
		//VO 바인딩
		UsersVO users = new UsersVO();
		users.setUser_id(id);
		users.setUser_pwd(pwd);
		users.setUser_name(name);
		users.setUser_email(email);
		
		//Service 객체의 메소드 호출
		UsersService service = UsersService.getInstance();
		service.usersInsert(users);
		
		//Output View 페이지로 이동
		req.setAttribute("id", id);
		HttpUtil.forward(req, resp, "/users/signup.jsp");
	}

	
}

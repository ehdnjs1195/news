package com.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.UsersService;

public class UsersIdCheckController implements Controller{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id = req.getParameter("user_id");
		System.out.println(user_id);

		UsersService service = UsersService.getInstance();
		boolean isExistId = service.checkId(user_id);
		Map<String, Boolean> map = new HashMap<>();
		map.put("isExistId", isExistId);
		req.setAttribute("isExistId", isExistId);
		HttpUtil.forward(req, resp, "/users/signupForm.jsp");
	}

}

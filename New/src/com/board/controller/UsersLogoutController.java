package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersLogoutController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그아웃 처리하기
		req.getSession().invalidate();
		
		//홈으로 리다이렉트 시키기
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}
}

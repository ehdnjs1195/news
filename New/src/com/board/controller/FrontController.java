package com.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		charset = sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/users/signup.do", new UsersSignupController());
		list.put("/users/update.do", new UsersUpdateController());
		list.put("/users/list.do", new UsersListController());	
		list.put("/users/checkId.do", new UsersIdCheckController());
		list.put("/users/login.do", new UsersLoginController());
		list.put("/users/findUserId.do", new UsersFindIdController());
		list.put("/users/findUserPwd.do", new UsersFindPwdController());
		list.put("/users/changeUserPwd.do", new UsersChangePwdController());
		list.put("/users/userList.do", new UsersGetListController());
		list.put("/users/logout.do", new UsersLogoutController());
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = list.get(path);
		subController.execute(req,resp);
	}
	
}

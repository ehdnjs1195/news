package com.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.UsersService;
import com.board.vo.UsersVO;

public class UsersGetListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//회원 전체 목록 가져오기
		List<UsersVO> userList = new ArrayList<>();
		UsersService service = UsersService.getInstance();
		userList = service.getUserList();
		
		//회원 목록 화면으로 이동
		req.setAttribute("userList", userList);
		HttpUtil.forward(req, resp, "/users/userList.jsp");
	}

}

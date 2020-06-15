package com.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.UsersService;
import com.board.util.Pager;
import com.board.vo.UsersVO;

public class UsersGetListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 페이징 파라미터 추출 ( default 값으로 1 )
		int page = req.getParameter("page") == null ?  1 : Integer.parseInt(req.getParameter("page"));
		int range = req.getParameter("range") == null ?  1 : Integer.parseInt(req.getParameter("range"));
		int listSize = req.getParameter("listSize") == null? 10 : Integer.parseInt(req.getParameter("listSize"));
		// 전체 게시글 개수
		UsersService service = UsersService.getInstance();
		int listCnt = service.getUserCnt();
		// 페이징 객체 생성
		Pager pager = new Pager();
		pager.pageInfo(listSize, page, range, listCnt);
		// 페이징 객체 등록
		req.setAttribute("pager", pager);
		req.setAttribute("userList", service.getUserList(pager));


		// 회원 목록 화면으로 이동
		HttpUtil.forward(req, resp, "/users/userList.jsp");
	}

}

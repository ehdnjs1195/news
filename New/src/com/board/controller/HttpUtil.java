package com.board.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//처리결과 페이지로 이동시키는 클래스
public class HttpUtil {

	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) {
		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
		} catch(Exception e) {
			System.out.println("forward 오류: "+ e);
		}
	}
}

package com.news.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//처리결과 페이지로 이동시키는 클래스
public class HttpUtil {

	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} catch(Exception e) {
			System.out.println("forward 오류: "+ e);
		}
	}
}

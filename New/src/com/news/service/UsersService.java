package com.news.service;

import com.news.dao.UsersDAO;
import com.news.vo.UsersVO;

public class UsersService {

	private static UsersService service = new UsersService();
	public UsersDAO dao = UsersDAO.getInstance();
	
	private UsersService() {}
	public static UsersService getInstance() {
		return service;
	}
	
	public void usersInsert(UsersVO users) {
		dao.usersInsert(users);
	}
}

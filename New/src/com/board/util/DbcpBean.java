package com.board.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbcpBean {
	//필드
	private Connection conn;
	//생성자
	public DbcpBean() {
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
	
			//Connection pool 에서 Connection 객체 하나 가져오기
			conn = ds.getConnection();
			System.out.println("Connection 얻어오기 성공!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Connection 객체를 리턴해주는 메소드
	public Connection getConn() {
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				System.out.println("ResultSet.close() 오류발생: " + e);
			}
		}
		close(conn, ps);
	}
	
	public void close(Connection conn, PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
				conn.close();
			} catch(Exception e) {
				System.out.println("PreparedStatement.close() 오류발생: " +e);
			}
		}
	}
}

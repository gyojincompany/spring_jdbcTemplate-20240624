package com.gyojincompany.board.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gyojincompany.board.util.Constant;

public class BoardDao {
	
	// 멤버변수(멤버객체)
	DataSource dataSource;
	JdbcTemplate template;
	
	public BoardDao() {
		
		this.template = Constant.template;
		
	}
	
	
}

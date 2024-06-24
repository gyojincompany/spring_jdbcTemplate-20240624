package com.gyojincompany.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.board.command.BCommand;
import com.gyojincompany.board.command.BWriteCommand;
import com.gyojincompany.board.util.Constant;

@Controller
public class BoardController {
	
	BCommand command = null;
	
	private JdbcTemplate template;	
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping(value = "/write")
	public String write() {
		return "write_form";
	}
	
	@RequestMapping(value = "/writeOk")
	public String write(HttpServletRequest request, Model model) {
		
		// model에 request 싣기
		model.addAttribute("request", request);
		
		// command 호출
		command = new BWriteCommand();
		command.execute(model);		
		
		return "list";
	}
	
}

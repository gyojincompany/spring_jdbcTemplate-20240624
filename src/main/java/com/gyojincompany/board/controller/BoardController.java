package com.gyojincompany.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.board.command.BCommand;
import com.gyojincompany.board.command.BContentViewCommand;
import com.gyojincompany.board.command.BDeleteCommand;
import com.gyojincompany.board.command.BListCommand;
import com.gyojincompany.board.command.BModifyCommand;
import com.gyojincompany.board.command.BWriteCommand;
import com.gyojincompany.board.util.Constant;

@Controller
public class BoardController {
	
	BCommand command = null;
	
	private JdbcTemplate template;	
	
	@Autowired
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
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping(value = "/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentViewCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentViewCommand();
		command.execute(model);		
		
		return "modify_form";
	}
	
	@RequestMapping(value = "/modifyOk")
	public String modifyOk(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BModifyCommand();
		command.execute(model);		
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BDeleteCommand();
		command.execute(model);		
		
		return "redirect:list";
	}
	
	
	
	
	
	
}

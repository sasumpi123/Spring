package com.mvc.update.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.model.biz.JdbcBiz;
import com.mvc.update.model.dto.JdbcDto;

@Controller
public class JdbcController {

	@Autowired
	private JdbcBiz biz;

	@RequestMapping("list.do")
	public String selectList(Model model) {
		List<JdbcDto> list = biz.selectList();
		model.addAttribute("list", list);
		return "jdbclist";
	}
	
	@RequestMapping("insertform.do")
	public String insertForm() {
		return "insertForm";
	}

	@RequestMapping("insert.do")
	public String insert(Model model, JdbcDto dto) {
		int res = biz.insert(dto);
		if(res>0) {
			
			return "redirect:list.do";
		}else {
			return "redirect:insertform.do";
		}
	}
}

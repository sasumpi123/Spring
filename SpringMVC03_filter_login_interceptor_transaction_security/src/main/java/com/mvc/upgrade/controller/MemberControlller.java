package com.mvc.upgrade.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberControlller {
	
	@Autowired
	private MemberBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(MemberControlller.class);
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("LOGIN FORM");
		return "mvclogin";
	}
	// ResponseBody사용하면 viewResolver 거치지 않음 바로 ajax로 전달
	@RequestMapping(value = "/ajaxlogin.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MemberDto dto){
		/*
		 * @ResponseBody : java 객체를 response 객체에 binding
		 * @RequestBody : request 객체에 담겨져 넘어오는 데이터를 java 객체에 binding
		 * jackson이 자바의 map 객체를 json 형식으로 바꿔줌
		 */
		
		logger.info("AJAX LOGIN");
		
		MemberDto res = biz.login(dto);
		boolean check = false;
		if(res!=null) {
			session.setAttribute("login", res);
			check = true; 	
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		

		return map;
	}
	
	@RequestMapping("/registform.do")
	public String registForm() {
		return "registform";
	}
	@RequestMapping(value = "ajaxidchk.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxIdchk(String memberid) {
		logger.info("AJAX IDCHK");
		
		MemberDto res = biz.idchk(memberid);
		boolean check = false;
		
		if(res!=null) {
			check = true; 
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	@RequestMapping(value = "regist.do")
	public String regist(Model model, String memberid, String memberpw, String membername) {
		logger.info("REGIST");
		
		
		MemberDto dto = new MemberDto(0,memberid,memberpw,membername);
		int res  = biz.regist(dto);
		
		if(res>0) {
			System.out.println("회원가입 ㅊㅊ");
			model.addAttribute("msg","회원가입 성공하였습니다.");
			model.addAttribute("url","loginform.do");
			return "alert";
		}else {
			model.addAttribute("msg","회원가입 실패하였습니다.");
			model.addAttribute("url","registform.do");
			return "alert";
		}
		
	}
	
	
	
	@RequestMapping(value="logout.do")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("msg","로그아웃 되었습니다.");
		model.addAttribute("url","index.html");
		return "alert";
		
	}

	
}

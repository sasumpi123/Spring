package com.mvc.upgrade.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;
import com.mvc.upgrade.model.dto.MemberDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private BoardBiz biz;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/list.do")
	public String selectList(Model model) {
		logger.info("SELECT LIST");

		model.addAttribute("list", biz.selectList());

		return "mvclist";
	}

	@RequestMapping(value = "/insert.do")
	public String insert() {
		logger.info("Go InsertForm");

		return "insertform";
	}

	@RequestMapping(value = "/insertres.do")
	public String insertRes(HttpSession session, Model model, String mytitle, String mycontent) {
		MemberDto memberDto = (MemberDto) session.getAttribute("login");
		BoardDto boardDto = new BoardDto(0, memberDto.getMemberid(), mytitle, mycontent, null, 0);
		int res = 0;
		res = biz.insert(boardDto);
		if (res > 0) {
			return "redirect:list.do";
		} else {
			return "insertform";
		}
	}

	@RequestMapping(value = "/detail.do")
	public String detail(Model model, int myno, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		logger.info("SELECT ONE");

		/*
		 * 쿠기 사용해서 조회수 중복으로 올라가는거 방지
		 */

		Cookie[] cookies = request.getCookies();
		Cookie viewCookie = null;
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				// Cookie의 name이 cookie + reviewNo와 일치하는 쿠키를 viewCookie에 넣어줌
				if (cookies[i].getName().equals("cookie" + myno)) {
					System.out.println("처음 쿠키가 생성한 뒤 들어옴.");
					viewCookie = cookies[i];
				}
			}
		}
		
		
		/*
		 * 
		 */
		
		int res = biz.viewCount(myno);
		if (res > 0) {
			model.addAttribute("boardDto", biz.selectOne(myno));
			return "detail";
		} else {
			model.addAttribute("msg", "error");
			model.addAttribute("url", "list.do");
			return "alert";
		}

	}

	@RequestMapping(value = "/update.do")
	public String update(Model model, int myno) {
		logger.info("Go UpdateForm");

		model.addAttribute("boardDto", biz.selectOne(myno));

		return "updateform";
	}

	@RequestMapping(value = "/updateres.do")
	public String updateRes(Model model, int myno, String mytitle, String mycontent) {
		logger.info("UPDATE");
		BoardDto dto = new BoardDto();
		dto.setMytitle(mytitle);
		dto.setMycontent(mycontent);
		dto.setMyno(myno);
		System.out.println(dto.getMytitle());
		System.out.println(dto.getMyname());
		System.out.println(dto.getMyno());
		int res = biz.update(dto);
		if (res > 0) {
			return "redirect:detail.do?myno=" + myno;
		} else {
			return "updateform";
		}
	}

	@RequestMapping(value = "/delete.do")
	public String delete(Model model, int myno) {
		logger.info("DELETE");

		int res = 0;
		res = biz.delete(myno);
		if (res > 0) {
			return "redirect:list.do";
		} else {
			return "detail";
		}
	}

	@RequestMapping("/test.do")
	public String test() {
		logger.info("TRANSACTION");
		biz.test();

		return "redirect:list.do";
	}

}

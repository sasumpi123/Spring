package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.biz.BoardBizImpl;
import com.mvc.upgrade.model.dto.BoardDto;

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
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/list.do")
	public String selectList(Model model){
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
	public String insertRes(Model model, String myname, String mytitle, String mycontent) {
		
		BoardDto dto = new BoardDto(0,myname,mytitle,mycontent,null);
		int res = 0;
		res = biz.insert(dto);
		if(res>0){
			return "redirect:list.do";
		}else {
			return "insertform";
		}
	}
	@RequestMapping(value = "/detail.do")
	public String detail(Model model, int myno) {
		logger.info("SELECT ONE");
		model.addAttribute("boardDto",biz.selectOne(myno));
		
		
		return "detail";
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
		if(res>0){
			return "redirect:detail.do?myno="+myno;
		}else {
			return "updateform";
		}
	}
	
	@RequestMapping(value = "/delete.do")
	public String delete(Model model, int myno) {
		logger.info("DELETE");
		
		int res = 0;
		res = biz.delete(myno);
		if(res>0){
			return "redirect:list.do";
		}else {
			return "detail";
		}
	}
	
	
	
}

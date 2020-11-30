package com.MemberBoard1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MemberBoard1.service.BoardService;

@Controller
public class BoardController {
	
	private ModelAndView mav;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/boardList")
	public ModelAndView boardList() {
		System.out.println("/boardList");
		mav = boardService.boardList();
		return mav;
	}
	
	@RequestMapping(value="/boardView")
	public ModelAndView boardView(int bno) {
		System.out.println("/boardView");
		int result = boardService.hitUpdate(bno);
		mav = boardService.boardView(bno);
		return mav;
	}
}

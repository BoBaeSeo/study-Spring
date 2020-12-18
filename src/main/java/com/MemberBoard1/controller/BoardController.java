package com.MemberBoard1.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard1.dto.BoardDTO;
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
	
	@RequestMapping(value="/boardListPaging")
	public ModelAndView boardListPaging(@RequestParam(value="page", defaultValue="1") int page) {
		System.out.println("/boardListPaging");
		System.out.println("page::" + page);
		mav = boardService.boardListPaging(page);
		return mav;
	}
	
	@RequestMapping(value="/boardWriteForm")
	public String boardWriteForm() {
		System.out.println("/boardWriteForm");
		return "board/boardWriteForm";
	}
	
	@RequestMapping(value="/boardWrite")
	public ModelAndView boardWrite(BoardDTO dto, RedirectAttributes ra) {
		System.out.println("/boardWrite");
		mav = boardService.boardWrite(dto, ra);
		return mav;
	}
	
	@RequestMapping(value="/boardView")
	public ModelAndView boardView(int bno) {
		System.out.println("/boardView");
		mav = boardService.boardView(bno);
		return mav;
	}
	
	@RequestMapping(value="/boardModify")
	public ModelAndView boardModify(int bno) {
		System.out.println("/boardModify");
		mav = boardService.boardModify(bno);
		return mav;
	}
	
	@RequestMapping(value="/boaardModifyProcess")
 	public ModelAndView boaardModifyProcess(BoardDTO dto) {
		System.out.println("/boaardModifyProcess");
		mav = boardService.boaardModifyProcess(dto);
		return mav;
	}
	
	@RequestMapping(value="/searchList")
	public ModelAndView searchList(@RequestParam String searchType, String searchValue ) {
		System.out.println("/searchList");
		mav = boardService.searchList(searchType, searchValue);
		return mav;
	}
	
	@RequestMapping(value="/boardDelete")
	public ModelAndView boardDelete(@RequestParam int bno, RedirectAttributes ra) {
		System.out.println("/boardDelete");
		mav = boardService.boardDelete(bno, ra);
		return mav;
	}
	
	@RequestMapping(value="/boardWriteFileForm")
	public String boardWriteFileForm() {
		return "board/boardWriteFileForm";
	}
	
	@RequestMapping(value="/boardWriteFile")
	public ModelAndView boardWriteFile(BoardDTO dto, RedirectAttributes ra) throws IllegalStateException, IOException{
		System.out.println("/boardWriteFile");
		System.out.println(dto);
		mav = boardService.boardWriteFile(dto, ra);
		return mav;
	}
	
	@RequestMapping(value="/boardListMember")
	public ModelAndView boardListMember(String bwriter) {
		System.out.println("/boardListMember");
		mav = boardService.boardListMember(bwriter);
		return mav;
	}
}

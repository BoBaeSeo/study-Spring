package com.MemberBoard1.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard1.dto.BoardDTO;
import com.MemberBoard1.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	private ModelAndView mav;
	
	public ModelAndView boardList() {
		mav = new ModelAndView();
		
		ArrayList<BoardDTO> boardList = boardMapper.boardList();
		System.out.println(boardList);
		System.out.println("boardList2::"+boardMapper.boardList2());
		
		mav.addObject("boardList", boardList);
		mav.setViewName("board/boardList");
		return mav;
	}

	public int hitUpdate(int bno) {
		int result = boardMapper.hitUpdate(bno);
		return result;
	}

	public ModelAndView boardView(int bno) {
		mav = new ModelAndView();
		BoardDTO board = boardMapper.boardView(bno);
		
		mav.addObject("board", board);
		mav.setViewName("board/boardView");
		return mav;
	}

	public ModelAndView boardWrite(BoardDTO dto, RedirectAttributes ra) {
		mav = new ModelAndView();
		int bno = boardMapper.getBno() + 1;
		dto.setBno(bno);
		int result = boardMapper.boardWrite(dto);
		System.out.println("result:" + result);
		ra.addFlashAttribute("bno", bno);
		mav.setViewName("redirect:/boardList");
		return mav;
	}


	
}

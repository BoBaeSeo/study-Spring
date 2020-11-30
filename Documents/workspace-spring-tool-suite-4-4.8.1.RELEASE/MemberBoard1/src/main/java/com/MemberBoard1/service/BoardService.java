package com.MemberBoard1.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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


	
}

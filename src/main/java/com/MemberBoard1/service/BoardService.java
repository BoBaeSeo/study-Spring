package com.MemberBoard1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard1.dto.BoardDTO;
import com.MemberBoard1.dto.CommentsDTO;
import com.MemberBoard1.mapper.BoardMapper;
import com.MemberBoard1.mapper.CommentMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper boardMapper;
	@Autowired
	CommentMapper commentMapper;
	
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

	public ModelAndView boardView(int bno) {
		mav = new ModelAndView();
		int result = boardMapper.hitUpdate(bno);
		System.out.println("viewResult:" + result);
		BoardDTO board = boardMapper.boardView(bno);
		ArrayList<CommentsDTO> commentList = commentMapper.getCommentList(bno);
		mav.addObject("commentList", commentList);
		mav.addObject("board", board);
		mav.setViewName("board/boardView");
		return mav;
	}

	public ModelAndView boardWrite(BoardDTO dto, RedirectAttributes ra) {
		mav = new ModelAndView();
		int bno = boardMapper.getBno() + 1;
		dto.setBno(bno);
		int result = boardMapper.boardWrite(dto);
		System.out.println("writeResult:" + result);
		ra.addFlashAttribute("modalBno", bno);
		mav.setViewName("redirect:/boardList");
		return mav;
	}

	public ModelAndView searchList(String searchType, String searchValue) {
		mav = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType",searchType);
		map.put("searchValue",searchValue);

		ArrayList<BoardDTO> searchList = boardMapper.searchList(map);
		mav.addObject("boardList",searchList);
		mav.setViewName("board/boardList");
		return mav;
	}

	// search를 하는 2번째 방법
	/*
	 * public ModelAndView boardSearch(String searchType, String keyWord) { mav =
	 * new ModelAndView(); ArrayList<BoardDTO> boardList = null;
	 * if(searchType.equals("searchBtitle")) { boardList =
	 * boardMapper.search1(keyWord); }else if(searchType.equals("searchBwriter")) {
	 * boardList = boardMapper.search2(keyWord); } mav.addObject("boardList",
	 * boardList); mav.setViewName("board/boardList"); return mav; }
	 */
	
	//search를 하는 3번째 방법
	/*
	 * public ModelAndView boardSearch(String searchType, String keyWord) { mav =
	 * new ModelAndView(); ArrayList<BoardDTO> boardList = null; Map<String, String>
	 * map = new HashMap<String, String>(); map.put("searchType",searchType);
	 * map.put("searchValue",keyWord);
	 * 
	 * boardList = boardMapper.boardSearch(map);
	 * mav.addObject("boardList",boardList); mav.setViewName("board/boardList");
	 * return mav; }
	 */
	
	public ModelAndView boardModify(int bno) {
		mav = new ModelAndView();
		BoardDTO board = boardMapper.boardView(bno);
		
		mav.addObject("board", board);
		mav.setViewName("board/boardModify");
		return mav;
	}

	public ModelAndView boaardModifyProcess(BoardDTO dto) {
		mav = new ModelAndView();
		int result = boardMapper.boardModifyProcess(dto);
		System.out.println("modifyResult:" + result);
		mav.setViewName("redirect:/boardView?bno="+dto.getBno());
		return mav;
	}

	public ModelAndView boardDelete(int bno, RedirectAttributes ra) {
		mav = new ModelAndView();
		int result = boardMapper.boardDelete(bno);
		System.out.println("deleteResult:" + result);
		ra.addFlashAttribute("modalBno", bno);
		ra.addFlashAttribute("deleteCheck", "del");
		mav.setViewName("redirect:/boardList");
		return mav;
	}
	


	
}

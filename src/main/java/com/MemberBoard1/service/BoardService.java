package com.MemberBoard1.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard1.dto.BoardDTO;
import com.MemberBoard1.dto.CommentsDTO;
import com.MemberBoard1.dto.PageDTO;
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
		for(int i=0; i<boardList.size(); i++	) {
			boardList.get(i).setCommentCnt(commentMapper.commentSelect(boardList.get(i).getBno()));			
		}
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
		
		//bno에 해당하는 bfilename select
		String bfilename = boardMapper.getBfilename(bno);
		String savePath = "C:\\Users\\seeth\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\MemberBoard1\\src\\main\\webapp\\resources\\fileUpload\\";
		File file = new File(savePath+bfilename);
		file.delete();
		
		int cdelResult = commentMapper.allCommentDelete(bno);
		int result = boardMapper.boardDelete(bno);
		System.out.println("deleteResult:" + result);
		ra.addFlashAttribute("modalBno", bno);
		ra.addFlashAttribute("deleteCheck", "del");
		mav.setViewName("redirect:/boardList");
		return mav;
	}

	public ModelAndView boardWriteFile(BoardDTO dto, RedirectAttributes ra) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		MultipartFile bfile = dto.getBfile();
		String fileName = uuid.toString().substring(1, 8)+"_"+bfile.getOriginalFilename();
		System.out.println("fileNaem::"+fileName);
		
		String savePath = "C:\\Users\\seeth\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\MemberBoard1\\src\\main\\webapp\\resources\\fileUpload\\";
		if(!bfile.isEmpty()) {
			bfile.transferTo(new File(savePath+fileName));
		}
		dto.setBfilename(fileName);
		int bno = boardMapper.getBno() + 1;
		dto.setBno(bno);
		
		int writeResult = boardMapper.boardWriteFile(dto);
		System.out.println(writeResult);
		ra.addFlashAttribute("modalBno", bno);
		mav.setViewName("redirect:/boardListPaging");
		return mav;
	}

	public ModelAndView boardListPaging(int page) {
		mav = new ModelAndView();
		
		int pageLimit = 5; // 한 페이지에 보여줄 글의 갯수
		int pageNumLimit = 3; // 한 페이지에 보여줄 페이지 번호
		
		int startRow = (page - 1) * pageLimit + 1;
		int endRow = page * pageLimit;
		
		PageDTO pageDTO = new PageDTO();
		pageDTO.setStartrow(startRow);
		pageDTO.setEndrow(endRow);
		
		ArrayList<BoardDTO> boardList = boardMapper.boardListPage(pageDTO);
		
		int boardListCnt = boardMapper.getBoardListCnt();
		int maxPage = (int)(Math.ceil((double)boardListCnt/pageLimit));
		int startPage = ((int)(Math.ceil((double)page/pageNumLimit)) -1) * pageNumLimit + 1;
		int endPage = startPage + pageNumLimit -1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		pageDTO.setPage(page);
		pageDTO.setStartpage(startPage);
		pageDTO.setEndpage(endPage);
		pageDTO.setMaxpage(maxPage);

		for(int i = 0; i < boardList.size(); i++) {
			int cbno = boardList.get(i).getBno();
			int commentCnt = commentMapper.commentSelect(cbno);
			boardList.get(i).setCommentCnt(commentCnt);
		}
		
		mav.addObject("boardList", boardList);
		mav.addObject("pageDTO", pageDTO);
		mav.setViewName("board/boardListPaging");
		return mav;
	}
	


	
}

package com.MemberBoard1.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard1.dto.BoardDTO;
import com.MemberBoard1.dto.MemberDTO;
import com.MemberBoard1.dto.PageDTO;
import com.MemberBoard1.mapper.BoardMapper;
import com.MemberBoard1.mapper.CommentMapper;
import com.MemberBoard1.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;
	
	public String checkMid(String checkId) {
		String result = null;
		String id = memberMapper.checkMid(checkId);
		if(id == null) {
			result = "OK";
		}
		return result;
	}

	public ModelAndView memberJoin(MemberDTO memberDTO, RedirectAttributes ra) {
		mav = new ModelAndView();
		String memail = memberDTO.getEmailid() + "@" + memberDTO.getMemaildomain();
		memberDTO.setMemail(memail);
		String maddress = memberDTO.getMpostcode() + memberDTO.getMaddr() + memberDTO.getMdetailAddress() + memberDTO.getMaddrefer();
		memberDTO.setMaddress(maddress);
		int insertResult = memberMapper.memberJoin(memberDTO);
		System.out.println("insertResult::"+insertResult);
		if(insertResult > 0) {
			ra.addFlashAttribute("msg", memberDTO.getMid()+"님 가입되었습니다.");
		}
		mav.setViewName("redirect:/memberLoginForm");
		return mav;
	}

	public ModelAndView memberLogin(MemberDTO memberDTO) {
		mav = new ModelAndView();
		String mid = memberMapper.memberLogin(memberDTO);
		session.setAttribute("loginId", mid);
		mav.setViewName("redirect:/");
		return mav;
	}

	public ModelAndView memberView(String mid) {
		mav = new ModelAndView();
		MemberDTO memberDTO = memberMapper.memberView(mid);
		mav.addObject("memberDTO", memberDTO);
		mav.setViewName("member/memberView");
		return mav;
	}

	public String modifyMphoneProcess(MemberDTO dto) {
		int updateResult = memberMapper.modifyMphoneProcess(dto);
		System.out.println(updateResult);
		String result = "NO";
		if(updateResult > 0) {
			result ="OK";
		} 
		return result;
	}

	public String modifyMemailProcess(MemberDTO dto) {
		int updateResult = memberMapper.modifyMemailProcess(dto);
		System.out.println(updateResult);
		String result = "NO";
		if(updateResult > 0) {
			result ="OK";
		} 
		return result;
	}

	public ModelAndView updateBprofile(MemberDTO dto) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile mprofile = dto.getMprofile();
		String savePath = "C:\\Users\\seeth\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\MemberBoard1\\src\\main\\webapp\\resources\\img\\";
		String mprofileName = dto.getMid()+".jpg";
		if(!mprofile.isEmpty()) {
			mprofile.transferTo(new File(savePath+mprofileName));
		} else {
			File file = new File(savePath+mprofileName);
			file.delete();
		}
		dto.setMprofilename(mprofileName);
		int updateResult = memberMapper.updateBprofile(dto);
		System.out.println(updateResult);
		mav.setViewName("redirect:/memberView?mid="+dto.getMid());
		return mav;
	}

	public String getProfile(String mid) {
		mav = new ModelAndView();
		String profileName = memberMapper.getProfile(mid);
		return profileName;
	}

	public ModelAndView memberList(int page) {
		mav = new ModelAndView();
		int pageLimit = 5;
		int pageNumLimit = 3;
		
		int startRow = (page - 1) * pageLimit + 1;
		int endRow = page * pageLimit;
		
		PageDTO pageDTO = new PageDTO();
		pageDTO.setStartrow(startRow);
		pageDTO.setEndrow(endRow);
		
		ArrayList<MemberDTO> memberList = memberMapper.memberListPage(pageDTO);
		
		int memberListCnt = memberMapper.getMemberListCnt();
		int maxPage = (int)(Math.ceil((double)memberListCnt/pageLimit));
		int startPage = ((int)(Math.ceil((double)page/pageNumLimit)) -1) * pageNumLimit + 1;
		int endPage = startPage + pageNumLimit -1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		pageDTO.setPage(page);
		pageDTO.setStartpage(startPage);
		pageDTO.setEndpage(endPage);
		pageDTO.setMaxpage(maxPage);

		mav.addObject("memberList", memberList);
		mav.addObject("pageDTO", pageDTO);
		mav.setViewName("member/memberList");
		return mav;
	}

	public ModelAndView memberDelete(String mid, RedirectAttributes ra) {
		mav = new ModelAndView();
		int deleteBoardResult = boardMapper.memberBoardDelete(mid);
		System.out.println("deleteBoardResult:" + deleteBoardResult);
		int deleteCommentResult = commentMapper.memberCommentDelete(mid);
		System.out.println("deleteCommetResult:" + deleteCommentResult);
		String savePath = "C:\\Users\\seeth\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\MemberBoard1\\src\\main\\webapp\\resources\\img\\";
		String mfileName = memberMapper.getProfile(mid);
		File file = new File(savePath+mfileName);
		file.delete();
		int deleteResult = memberMapper.memberDelete(mid);
		System.out.println("deleteResult:" + deleteResult);
		ra.addFlashAttribute("delMember", mid+" 회원이 삭제되었습니다.");
		session.invalidate();
		mav.setViewName("redirect:/");
		return mav;
	}

	public ArrayList<BoardDTO> memberBoardList(String mid) {
		ArrayList<BoardDTO> boardList = boardMapper.memberBoardList(mid);
		return boardList;
	}

}

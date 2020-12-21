package com.MemberBoard1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard1.dto.BoardDTO;
import com.MemberBoard1.dto.MemberDTO;
import com.MemberBoard1.dto.MessageDTO;
import com.MemberBoard1.service.MemberService;

@Controller
public class MemberController {

	private ModelAndView mav;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping(value="/memberJoinForm")
	public String memberJoinForm() {
		return "member/memberJoinForm";
	}
	
	@RequestMapping(value="/checkMid")
	public @ResponseBody String checkMid(@RequestParam String checkId) {
		String result = memberService.checkMid(checkId);
		return result;
	}
	
	@RequestMapping(value="/memberJoin")
	public ModelAndView memberJoin(MemberDTO memberDTO, RedirectAttributes ra) {
		mav = memberService.memberJoin(memberDTO, ra);
		return mav;
	}
	
	@RequestMapping(value="/memberLoginForm")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
	
	@RequestMapping(value="/memberLogin")
	public ModelAndView memberLogin(MemberDTO memberDTO) {
		System.out.println("/memberLogin");
		mav = memberService.memberLogin(memberDTO);
		return mav;
	}
	
	@RequestMapping(value="/memberLogout")
	public String memberLogout() {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/memberView")
	public ModelAndView memberView(String mid) {
		mav = memberService.memberView(mid);
		return mav;
	}
	
	@RequestMapping(value="/modifyMphoneProcess")
	public @ResponseBody String modifyMphoneProcess(MemberDTO dto) {
		System.out.println("/modifyMphoneProcess");
		String result = memberService.modifyMphoneProcess(dto);
		return result;
	}
	
	@RequestMapping(value="/modifyMemailProcess")
	public @ResponseBody String modifyMemailProcess(MemberDTO dto) {
		System.out.println("/modifyMemailProcess");
		String result = memberService.modifyMemailProcess(dto);
		return result;
	}
	
	@RequestMapping(value="/updateBprofile")
	public ModelAndView updateBprofile(MemberDTO dto) throws IllegalStateException, IOException {
		System.out.println("/updateBprofile");
		mav = memberService.updateBprofile(dto);
		return mav;
	}
	
	@RequestMapping(value="/getProfile", produces="application/text; charset=UTF-8")
	public @ResponseBody String getProfile(String mid) {
		System.out.println("/getProfile");
		String profileName = memberService.getProfile(mid);
		return profileName;
	}
	
	@RequestMapping(value="/memberList")
	public ModelAndView memberList(@RequestParam(value="page", defaultValue="1") int page) {
		System.out.println("/memberList");
		mav = memberService.memberList(page);
		return mav;
	}
	
	@RequestMapping(value="/memberDelete")
	public ModelAndView memberDelete(String mid, RedirectAttributes ra) {
		System.out.println("/memberDelete");
		mav = memberService.memberDelete(mid, ra);
		return mav;
	}
	
	@RequestMapping(value="/memberBoardList")
	public @ResponseBody ArrayList<BoardDTO> memberBoardList(String mid){
		System.out.println("/memberBoardList");
		ArrayList<BoardDTO> boardList = memberService.memberBoardList(mid);
		return boardList;
	}
	
	@RequestMapping(value="/sendMsg", produces="application/text; charset=UTF-8")
	public @ResponseBody String sendMsg(MessageDTO dto) {
		System.out.println("/sendMsg");
		String sendResult = memberService.sendMsg(dto);
		return sendResult;
	}
}
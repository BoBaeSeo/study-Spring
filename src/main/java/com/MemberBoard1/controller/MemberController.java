package com.MemberBoard1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard1.dto.MemberDTO;
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
	public ModelAndView memberView() {
		mav = memberService.memberView();
		return mav;
	}
	
	@RequestMapping(value="/modifyMphoneProcess")
	public @ResponseBody String modifyMphoneProcess(String newMphone) {
		System.out.println("/modifyMphoneProcess");
		String mphone = memberService.modifyMphoneProcess(newMphone);
		return mphone;
	}
	
	@RequestMapping(value="/modifyMemailProcess")
	public @ResponseBody String modifyMemailProcess(String newMemail) {
		System.out.println("/modifyMemailProcess");
		String Memail = memberService.modifyMemailProcess(newMemail);
		return Memail;
	}
}
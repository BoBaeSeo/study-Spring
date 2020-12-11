package com.MemberBoard1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.MemberBoard1.dto.MemberDTO;
import com.MemberBoard1.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	ModelAndView mav;
	
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
	public ModelAndView memberJoin(MemberDTO memberDTO) {
		mav = memberService.memberJoin(memberDTO);
		return mav;
		
	}
}
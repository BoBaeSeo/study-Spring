package com.MemberBoard1.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard1.dto.MemberDTO;
import com.MemberBoard1.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
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

	public ModelAndView memberView() {
		mav = new ModelAndView();
		String mid = (String) session.getAttribute("loginId");
		MemberDTO memberDTO = memberMapper.memberView(mid);
		mav.addObject("memberDTO", memberDTO);
		mav.setViewName("member/memberView");
		return mav;
	}

	public String modifyMphoneProcess(String newMphone) {
		String mid = (String) session.getAttribute("loginId");
		MemberDTO dto = new MemberDTO();
		dto.setMid(mid);
		dto.setMphone(newMphone);
		int updateResult = memberMapper.modifyMphoneProcess(dto);
		System.out.println(updateResult);
		return newMphone;
	}

	public String modifyMemailProcess(String newMemail) {
		String mid = (String) session.getAttribute("loginId");
		MemberDTO dto = new MemberDTO();
		dto.setMid(mid);
		dto.setMemail(newMemail);
		int updateResult = memberMapper.modifyMemailProcess(dto);
		System.out.println(updateResult);
		return newMemail;
	}

}

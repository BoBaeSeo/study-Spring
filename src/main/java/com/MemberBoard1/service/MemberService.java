package com.MemberBoard1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.MemberBoard1.dto.MemberDTO;
import com.MemberBoard1.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	public String checkMid(String checkId) {
		String result = null;
		String id = memberMapper.checkMid(checkId);
		if(id == null) {
			result = "OK";
		}
		return result;
	}

	public ModelAndView memberJoin(MemberDTO memberDTO) {
		ModelAndView mav = new ModelAndView();
		String memail = memberDTO.getEmailid() + "@" + memberDTO.getMemaildomain();
		memberDTO.setMemail(memail);
		String maddress = memberDTO.getMpostcode() + memberDTO.getMaddr() + memberDTO.getMdetailAddress() + memberDTO.getMaddrefer();
		memberDTO.setMaddress(maddress);
		int insertResult = memberMapper.memberJoin(memberDTO);
		System.out.println(insertResult);
		mav.setViewName("redirect:/");
		return mav;
	}

}

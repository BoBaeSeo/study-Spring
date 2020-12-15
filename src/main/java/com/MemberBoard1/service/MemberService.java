package com.MemberBoard1.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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
		String mprofileName = dto.getMid()+".jpg";
		String savePath = "C:\\Users\\seeth\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\MemberBoard1\\src\\main\\webapp\\resources\\img\\";
		mprofile.transferTo(new File(savePath+mprofileName));
		dto.setMprofilename(mprofileName);
		int updateResult = memberMapper.updateBprofile(dto);
		System.out.println(updateResult);
		mav.setViewName("redirect:/memberView");
		return mav;
	}

}

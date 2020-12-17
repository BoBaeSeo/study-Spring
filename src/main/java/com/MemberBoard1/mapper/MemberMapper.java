package com.MemberBoard1.mapper;

import java.util.ArrayList;

import com.MemberBoard1.dto.BoardDTO;
import com.MemberBoard1.dto.MemberDTO;
import com.MemberBoard1.dto.PageDTO;

public interface MemberMapper {

	String checkMid(String checkId);

	int memberJoin(MemberDTO memberDTO);

	String memberLogin(MemberDTO memberDTO);

	MemberDTO memberView(String mid);

	int modifyMphoneProcess(MemberDTO dto);

	int modifyMemailProcess(MemberDTO dto);

	int updateBprofile(MemberDTO dto);

	String getProfile(String mid);

	ArrayList<MemberDTO> memberListPage(PageDTO pageDTO);

	int getMemberListCnt();

	int memberDelete(String mid);

}

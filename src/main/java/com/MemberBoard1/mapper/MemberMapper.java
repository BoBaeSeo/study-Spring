package com.MemberBoard1.mapper;

import com.MemberBoard1.dto.MemberDTO;

public interface MemberMapper {

	String checkMid(String checkId);

	int memberJoin(MemberDTO memberDTO);

	String memberLogin(MemberDTO memberDTO);

	MemberDTO memberView(String mid);

	int modifyMphoneProcess(MemberDTO dto);

	int modifyMemailProcess(MemberDTO dto);

	int updateBprofile(MemberDTO dto);

}

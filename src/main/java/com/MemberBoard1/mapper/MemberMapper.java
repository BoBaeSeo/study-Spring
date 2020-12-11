package com.MemberBoard1.mapper;

import com.MemberBoard1.dto.MemberDTO;

public interface MemberMapper {

	String checkMid(String checkId);

	int memberJoin(MemberDTO memberDTO);

}

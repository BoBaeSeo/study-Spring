package com.MemberBoard1.mapper;

import java.util.ArrayList;

import com.MemberBoard1.dto.MessageDTO;

public interface MessageMapper {

	int sendMsg(MessageDTO dto);

	ArrayList<MessageDTO> getMsgList(String loginId);

	int getMsgCode();

	int updateMsgCheck(int msg_code);

	MessageDTO showMsgDetail(int msg_code);
}

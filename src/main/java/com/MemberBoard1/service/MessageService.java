package com.MemberBoard1.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemberBoard1.dto.MessageDTO;
import com.MemberBoard1.mapper.MessageMapper;

@Service
public class MessageService {

	@Autowired
	MessageMapper messageMapper;
	
	public String sendMsg(MessageDTO dto) {
		dto.setMsg_code(messageMapper.getMsgCode()+1);
		int insertResult = messageMapper.sendMsg(dto);
		String sendResult = "메세지 전송에 실패하였습니다.";
		if(insertResult>0) {
			sendResult = "메세지가 전송되었습니다.";
		}
		return sendResult;
	}

	public ArrayList<MessageDTO> getMsgList(String loginId) {
		ArrayList<MessageDTO> msgList = messageMapper.getMsgList(loginId);
		return msgList;
	}

	public MessageDTO showMsgDetail(int msg_code) {
		int updateResult = messageMapper.updateMsgCheck(msg_code);
		System.out.println(updateResult);
		MessageDTO msgDetail = messageMapper.showMsgDetail(msg_code);
		return msgDetail;
	}
}

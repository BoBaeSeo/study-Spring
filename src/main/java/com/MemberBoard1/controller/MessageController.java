package com.MemberBoard1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MemberBoard1.dto.MessageDTO;
import com.MemberBoard1.service.MessageService;

@Controller
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@RequestMapping(value="/sendMsg", produces="application/text; charset=UTF-8")
	public @ResponseBody String sendMsg(MessageDTO dto) {
		System.out.println("/sendMsg");
		String sendResult = messageService.sendMsg(dto);
		return sendResult;
	}
	
	@RequestMapping(value="/getMsgList")
	public @ResponseBody ArrayList<MessageDTO> getMsgList(String loginId){
		System.out.println("/getMsgList");
		ArrayList<MessageDTO> msgList = messageService.getMsgList(loginId);
		return msgList;
	}
	
	@RequestMapping(value="/showMsgDetail")
	public @ResponseBody MessageDTO showMsgDetail(int msg_code) {
		MessageDTO msgDetail = messageService.showMsgDetail(msg_code);
		return msgDetail;
	}
}

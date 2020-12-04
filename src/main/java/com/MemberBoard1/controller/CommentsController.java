package com.MemberBoard1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MemberBoard1.dto.CommentsDTO;
import com.MemberBoard1.service.CommentsService;

@Controller
public class CommentsController {

	@Autowired
	private CommentsService commentService;
	
	@RequestMapping(value="/commentWrite")
	public @ResponseBody ArrayList<CommentsDTO> commentsList(CommentsDTO comment){
		System.out.println("/commentWrite");
		ArrayList<CommentsDTO> commentList = commentService.commentWrite(comment);
		System.out.println(commentList);
		return commentList;
	}
}

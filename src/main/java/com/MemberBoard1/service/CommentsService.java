package com.MemberBoard1.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemberBoard1.dto.CommentsDTO;
import com.MemberBoard1.mapper.CommentMapper;

@Service
public class CommentsService {

	@Autowired
	private CommentMapper commentMapper;
	
	public ArrayList<CommentsDTO> commentWrite(CommentsDTO comment) {
		int nextCno = commentMapper.getMaxCno() + 1;
		comment.setCno(nextCno);
		int writeResult = commentMapper.commentWrite(comment);
		System.out.println("writeResult: " + writeResult);
		ArrayList<CommentsDTO> commentList = commentMapper.getCommentList(comment.getCbno());
		return commentList;
	}

}
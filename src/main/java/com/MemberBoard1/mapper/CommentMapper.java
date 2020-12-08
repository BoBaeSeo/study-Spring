package com.MemberBoard1.mapper;

import java.util.ArrayList;

import com.MemberBoard1.dto.CommentsDTO;

public interface CommentMapper {

	int getMaxCno();

	int commentWrite(CommentsDTO comment);

	ArrayList<CommentsDTO> getCommentList(int cbno);

	int commentDelete(int cno);

	int allCommentDelete(int bno);

}

package com.MemberBoard1.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.MemberBoard1.dto.BoardDTO;

public interface BoardMapper {

	@Select("SELECT * FROM BOARD")
	public ArrayList<BoardDTO> boardList();
	
	public ArrayList<BoardDTO> boardList2();

	public int hitUpdate(int bno);

	public BoardDTO boardView(int bno);

	public int boardWrite(BoardDTO dto);

	public int getBno();


}

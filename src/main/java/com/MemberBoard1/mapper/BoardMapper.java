package com.MemberBoard1.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.MemberBoard1.dto.BoardDTO;
import com.MemberBoard1.dto.CommentsDTO;
import com.MemberBoard1.dto.PageDTO;

public interface BoardMapper {

	@Select("SELECT * FROM BOARD")
	public ArrayList<BoardDTO> boardList();
	
	public ArrayList<BoardDTO> boardList2();

	public int hitUpdate(int bno);

	public BoardDTO boardView(int bno);

	public int boardWrite(BoardDTO dto);

	public int getBno();

	public ArrayList<BoardDTO> searchList(Map<String, String> map);

	public int boardModifyProcess(BoardDTO dto);

	public int boardDelete(int bno);

	public int boardWriteFile(BoardDTO dto);

	public String getBfilename(int bno);

	public ArrayList<BoardDTO> boardListPage(PageDTO pageDTO);

	public int getBoardListCnt();

	public int getbnoMid(String mid);

	public int memberBoardDelete(String mid);


	/* public ArrayList<BoardDTO> boardSearch(Map<String, String> map); */

}

package com.MemberBoard1.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.MemberBoard1.dto.BoardDTO;

public interface BoardMapper {

	@Select("SELECT * FROM BOARD")
	public ArrayList<BoardDTO> boardList();

	@Update("UPDATE BOARD SET BHIT=BHIT+1 WHERE BNO=#{bno}")
	public int hitUpdate(int bno);

	@Select("SELECT * FROM BOARD WHERE BNO=#{bno}")
	public BoardDTO boardView(int bno);


}

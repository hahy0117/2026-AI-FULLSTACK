package com.the703.dao;

import java.util.HashMap;
import java.util.List;

import com.the703.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public int insert(BoardDto dto);

	public int update(BoardDto dto);

	public int delete(int bno);

	public List<BoardDto> selectAll();

	public BoardDto select(int bno);
	
	public BoardDto datail(int bno);
	
	public int updateHit(int bno);
	
	public List<BoardDto> select10(HashMap<String,Integer> map);
	
	public int selectCnt();

}

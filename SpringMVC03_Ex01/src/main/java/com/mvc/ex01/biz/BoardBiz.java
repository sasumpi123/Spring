package com.mvc.ex01.biz;

import java.util.List;




import com.mvc.ex01.dto.BoardDto;

public interface BoardBiz {
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int myno);
	public int update(BoardDto dto);
	public int insert(BoardDto dto);
	public int delete(int myno);

}

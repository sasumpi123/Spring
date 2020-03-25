package com.mvc.ex01.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.ex01.dao.BoardDao;
import com.mvc.ex01.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz {

	@Autowired
	private BoardDao dao;

	@Override
	public List<BoardDto> selectList() {

		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int myno) {

		return dao.selectOne(myno);
	}

	@Override
	public int update(BoardDto dto) {

		return dao.update(dto);
	}

	@Override
	public int insert(BoardDto dto) {

		return dao.insert(dto);
	}

	@Override
	public int delete(int myno) {

		return dao.delete(myno);
	}

}

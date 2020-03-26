package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardDto> selectList() {

		List<BoardDto> list = new ArrayList<BoardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[ERROR] : select list");
		}
		
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		BoardDto dto = null;
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] : select one");
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			System.out.println("[ERROR] : insert");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		int res = 0;
		System.out.println("update dao 안 title"+dto.getMytitle());
		System.out.println("update dao 안 name"+dto.getMyname());
		System.out.println("update dao 안 myno"+dto.getMyno());
		try {
			res = sqlSession.update(NAMESPACE+"update",dto);
		} catch (Exception e) {
			System.out.println("[ERROR] : update");
			e.printStackTrace();
		}
		System.out.println("update dao안 res :"+res);
		return res;
		
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		try {
			res = sqlSession.delete(NAMESPACE+"delete",myno);
		} catch (Exception e) {
			System.out.println("[ERROR] : delete");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public String test() {
		
		return null;
	}

	@Override
	public int viewCount(int myno) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"viewCount",myno);
		} catch (Exception e) {
			System.out.println("[ERROR] : viewCount");
			e.printStackTrace();
		}
		
		return res;
	}

}

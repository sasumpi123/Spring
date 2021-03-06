package com.mvc.upgrade.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberDto login(MemberDto dto) {
		MemberDto loginDto = null;
		try {
			loginDto = sqlSession.selectOne(NAMESPACE + "login", dto);
		} catch (Exception e) {
			System.out.println("[ERROR] : Login");
			e.printStackTrace();
		}
		
		
		return loginDto;
	}

	@Override
	public MemberDto idchk(String memberid) {
		MemberDto idchkDto = null;
		try {
			idchkDto = sqlSession.selectOne(NAMESPACE + "idchk", memberid);
		} catch (Exception e) {
			System.out.println("[ERROR] : idchk");
			e.printStackTrace();
		}
		return idchkDto;
	}

	@Override
	public int regist(MemberDto dto) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE + "regist", dto);
		} catch (Exception e) {
			System.out.println("[ERROR] : regist");
			e.printStackTrace();
		}
		
		return res;
	}

}

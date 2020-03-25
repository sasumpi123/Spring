package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.MemberDto;

public interface MemberDao {
	String NAMESPACE = "mymember.";
	
	public MemberDto login(MemberDto dto);
	 
}

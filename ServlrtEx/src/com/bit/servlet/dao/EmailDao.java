package com.bit.servlet.dao;

import java.util.List;

//추상 메서드의 선언
public interface EmailDao {

	public List<EmailVo> getList();
	public int insert(EmailVo vo);
	public int update(EmailVo vo );
	public int delete(Long no);
}

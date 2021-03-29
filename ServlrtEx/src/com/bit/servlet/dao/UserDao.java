package com.bit.servlet.dao;

public interface UserDao {

		public int insert(UserVo vo);
		public UserVo getUserByEmailAndPassword(String email,String password);
}


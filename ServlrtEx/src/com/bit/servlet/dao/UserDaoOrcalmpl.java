package com.bit.servlet.dao;

import java.sql.*;
public class UserDaoOrcalmpl implements UserDao {

	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl="jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl,"C##gjtjdgh","1234");
			 
			
		}catch(ClassNotFoundException e) {
			System.err.println("드라이버 불러오기 실패");
		}finally {
		
		}
		return conn;
	}
	
	@Override
	public int insert(UserVo vo) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		int insertCount =0;
		try {
			conn=getConnection();
			String sql =" insert into users (no,name,password,email,gender) values(seq_users_pk.NEXTVAL, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getGender());
			
			insertCount = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return insertCount;
	}

	@Override
	public UserVo getUserByEmailAndPassword(String email, String password) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		UserVo vo =null;
		
		try {
			conn = getConnection();
			String sql="select no,name,password,email,gender,created_at from users where email =? and password =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			//만약에 레코드가 있다면
			if(rs.next()) {
			Long no =rs.getLong(1);
			String name=rs.getString(2);
			String pwd=rs.getString(3);
			String eml=rs.getString(4);
			String gender=rs.getString(5);
			Date createdAt = rs.getDate(6);
				
			vo = new UserVo(no,name,pwd,eml,gender,createdAt);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}

}

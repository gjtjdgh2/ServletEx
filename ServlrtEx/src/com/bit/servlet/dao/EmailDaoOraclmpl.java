package com.bit.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailDaoOraclmpl implements EmailDao {

	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl="jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl,"C##gjtjdgh","1234");
			 
			System.out.println("드라이버 로드 성공");
		}catch(ClassNotFoundException e) {
			System.err.println("드라이버 불러오기 실패");
		}finally {
		
		}
		return conn;
	}
	
	@Override
	public List<EmailVo> getList() {
		List<EmailVo> list = new ArrayList<>();
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
		conn=getConnection();
		stmt=conn.createStatement();
		String sql = "select no,first_name,last_name,email,create_at from emaillist order by create_at desc";
		
		rs= stmt.executeQuery(sql);
		
		while(rs.next()) {
			Long no =rs.getLong(1);
			String firstName = rs.getNString(2);
			String lastName = rs.getNString(3);
			String email= rs.getNString(4);
			Date createAt=rs.getDate(5); //java.util.Date
			
			EmailVo vo = new EmailVo(no,firstName,lastName,email,createAt);
			list.add(vo);
		}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		
		return list;
	}

	@Override
	public int insert(EmailVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long no) {
		// TODO Auto-generated method stub
		return 0;
	}

}

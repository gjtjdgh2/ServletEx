package com.bit.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			
			EmailVo vo = new EmailVo(no,lastName,firstName,email,createAt);
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
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO emaillist" +
					"(no, last_name, first_name, email) " +
					"VALUES(seq_emaillist_pk.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getEmail());
			
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertedCount;
	}
	
	@Override
	public int delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM emaillist " +
					"WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			
			//	쿼리 수행
			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return deletedCount;
	}

	
	@Override
	public int update(EmailVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updateCouny = 0;
		
		try {
			conn = getConnection();
			String sql = "update emaillist set last_name=?, first_name=?, email=? where email=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getNewemail());
			pstmt.setString(4, vo.getEmail());
			
			updateCouny =pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		
		
		return updateCouny;
	}
	

}

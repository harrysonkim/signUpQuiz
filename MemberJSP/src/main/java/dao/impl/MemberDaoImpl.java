package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtill.JDBCTemplate;
import dao.face.MemberDao;
import dto.Member;

public class MemberDaoImpl implements MemberDao{

	@Override
	public Member find_Sq(Connection conn) {

		String sql = "SELECT member_sq.NEXTVAL FROM DUAL";
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		Member member = null;
		
		try {
			
			member = new Member();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				member.setUserNo( rs.getInt("nextval"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("MemberDaoImple의 반환하는 userNo" + member);
		return member; 
	}
	
	@Override
	public int signUp(Connection conn, Member member) {

		
		String sql = "";
		sql += "INSERT INTO member";
		sql += " VALUES ( ?, ?, ?, ? )";
		
		PreparedStatement ps = null;
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, member.getUserNo() );
			ps.setString(2, member.getUserName() );
			ps.setString(3, member.getUserNickName() );
			ps.setString(4, member.getUserEmail() );
			
			result = ps.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("insert할 때 member" + member);
		return result;
	}

	@Override
	public Member selectUser(Connection conn, Member idx) {
		
		String sql = "";
		sql += "SELECT * FROM member";
		sql += " WHERE userNo = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Member result = null;
		
		try {
			
			result = new Member();
			
			System.out.println("prepared에 셋팅하는 idx" + idx);
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx.getUserNo() );
			rs = ps.executeQuery();

			while (rs.next()) {
				result.setUserNo( rs.getInt("userno"));
				result.setUserName( rs.getString("userid"));
				result.setUserNickName( rs.getString("nick"));
				result.setUserEmail( rs.getString("email"));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("select후에 member" + result);
		return result;
		
	}
}

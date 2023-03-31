package service.impl;

import java.sql.Connection;

import DBUtill.JDBCTemplate;
import dao.face.MemberDao;
import dao.impl.MemberDaoImpl;
import dto.Member;
import service.face.MemberService;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public Member signUp(Member member) {

		Connection conn = DBUtill.JDBCTemplate.getConnection();
		
		Member idx = memberDao.find_Sq(conn);
		System.out.println("MemberServiceImpl의 idx" + idx);
		member.setUserNo( idx.getUserNo());
		memberDao.signUp(conn, member);
		JDBCTemplate.commit(conn);
		Member result = memberDao.selectUser(conn, idx);
		
		
		return result;
	}

}

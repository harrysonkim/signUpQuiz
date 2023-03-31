package dao.face;

import java.sql.Connection;

import dto.Member;

public interface MemberDao {

	public Member find_Sq(Connection conn);

	public int signUp(Connection conn, Member member);

	public Member selectUser(Connection conn, Member member);


}

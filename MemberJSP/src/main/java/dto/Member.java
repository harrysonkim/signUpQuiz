package dto;

public class Member {

	private int userNo;
	private String userName;
	private String userNickName;
	private String userEmail;

	public Member() {
	}

	public Member(int userNo, String userName, String userNickName, String userEmail) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userNickName = userNickName;
		this.userEmail = userEmail;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userName=" + userName + ", userNickName=" + userNickName + ", userEmail="
				+ userEmail + "]";
	}

}

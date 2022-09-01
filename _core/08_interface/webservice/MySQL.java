package webservice;

public class MySQL implements DataBase {
	private Member[] members;
	
	public MySQL() {}
	
	public MySQL(int num) {
		this.members = new Member[num];
	}
	
	public Member[] getMembers() {
		return members;
	}

	public void setMembers(Member[] members) {
		this.members = members;
	}

	@Override
	public boolean insert(Member member) {
		System.out.println("MySQL > 회원정보를 입력 " + (member.getEmail().length() > 2 ? "성공" : "실패"));
		return member.getEmail().length() > 2 ? true : false;
	}

	@Override
	public void select() {
		System.out.println("데이터베이스에서 회원 정보를 조회하였습니다");
	}
	

	@Override
	public void update() {
		System.out.println("데이터베이스에서 회원 정보를 수정하였습니다");

	}

	@Override
	public void delete() {
		System.out.println("데이터베이스에서 회원 정보를 삭제하였습니다");

	}

}

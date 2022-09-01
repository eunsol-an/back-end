package webservice;

public class WebService implements Service {
	
	private MySQL dbms;
	private Member[] members;
	
	public WebService() {}
	
	public WebService(int db) {
		dbms = db > 1 ? new MySQL() : new MySQL(10);
	}
	
	public DataBase getDbms() {
		return dbms;
	}

	public Member[] getMembers() {
		return members;
	}

	public void setMembers(Member[] members) {
		this.members = members;
	}

	@Override
	public void register(Member member, int cnt) {
		System.out.println("회원가입 서비스 요청");
		System.out.println("회원가입" + (dbms.insert(member) ? "완료" : "실패"));
	}

	@Override
	public void login() {
		System.out.println("회원로그인 서비스 요청");
		dbms.select();
		System.out.println("회원로그인 서비스 완료");

	}

	@Override
	public void edit() {
		System.out.println("회원정보 수정 서비스 요청");
		dbms.update();
		System.out.println("회원정보 수정 서비스 완료");
	}

	@Override
	public void resign() {
		System.out.println("회원 탈퇴 서비스 요청");
		dbms.delete();
		System.out.println("회원 탈퇴 서비스 완료");
	}

}

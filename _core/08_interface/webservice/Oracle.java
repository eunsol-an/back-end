package webservice;

public class Oracle implements DataBase {

	@Override
	public boolean insert(Member member) {
		System.out.println("Oracle > 회원정보를 입력 " + (member.getEmail().length() > 2 ? "성공" : "실패"));
		return member.getEmail().length() > 2 ? true : false;
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}

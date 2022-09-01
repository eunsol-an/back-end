package webservice;

import java.util.Scanner;

public class OpenService {

	public static void main(String[] args) {
		// 1. 데이터베이스에 10개의 Member 객체가 담길 수 있다
		// 2. Member 객체는 email(중복되지 않음), pwd, nickname, grade(숫자) 속성
		// 3. 각 데이터베이스의 메서드는 WebService의 요청에 따라 멤버객체를 저장, 조회, 수정, 삭제 한다
		// 4. 각 서비스의 결과는 요청 => 처리 => 완료보고의 메세지를 띄운다
		// 5. 프로그램이 종료가 될때까지 메뉴는 계속해서 아래의 메세지를 실행
		//		1. 데이터베이스 선택
		//		1.회원가입, 2.로그인, 3.회원수정, 4.회원탈퇴
		// 6. 프로그램이 종료 될 때까지 저장한 정보는 사라지면 안됨
		
		Scanner sc = new Scanner(System.in);
		WebService svc = new WebService();
		Member[] members = new Member[10];
		boolean flag = true;
		String email, pwd, nickname;
		int grade = 0, cnt = 0;
		
		while (flag) {
			System.out.println("데이터 베이스 선택 >");
			System.out.println("1.MySQL / 2.Oracle");
			int db = sc.nextInt();
			svc = new WebService();
			
			System.out.println("메뉴 선택 >");
			System.out.println("1.회원가입 / 2.로그인 / 3.회원수정 / 4.회원탈퇴");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				if (members.length < 11) {
					
					boolean flagEmail = true;
					System.out.println("이메일 입력 >");
					email = sc.next();
					
					for (int i = 0; i < members.length; i++) {
						if (members[i] != null) {
							if (email.equals(members[i].getEmail())) {
								System.out.println("중복된 이메일입니다");
								flagEmail = false;
								break;
							} else {
								System.out.println("비밀번호 입력 >");
								pwd = sc.next();
								System.out.println("닉네임 입력 >");
								nickname = sc.next();
								Member member = new Member(email, pwd, nickname, grade);
								members[cnt] = member;
								svc.register(member, cnt);
								cnt++;
							}
						}
					}
					if (flagEmail) {
						System.out.println("비밀번호 입력 >");
						pwd = sc.next();
						System.out.println("닉네임 입력 >");
						nickname = sc.next();
						Member member = new Member(email, pwd, nickname, grade);
						members[cnt] = member;
						svc.register(member, cnt);
						cnt++;
					}
				}
				break;
			case 2:
				System.out.println("이메일 입력 >");
				email = sc.next();
				System.out.println("비밀번호 입력 >");
				pwd = sc.next();
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null) {
						if (email.equals(members[i].getEmail()) && pwd.equals(members[i].getPwd())) {
							System.out.println("로그인 완료");
							System.out.println(members[i].getNickname() + "님 안녕하세요!");
						} else {
							System.out.println("해당하는 정보가 없습니다");
						}
					}
				}
				break;

			default:
				System.out.println("이용해주셔서 감사합니다");
				flag = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}

package webservice;

import java.util.Scanner;

public class WebApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		svc.register();
//		svc.login();
		// 이 곳에 웹서비스에 사용할 데이터베이스를 선택하는 메뉴를 만들고
		// 데이터베이스의 선택에 따라 MySQL, Oracle이 연결되어 작동하는 구조
		// DataBase의 인터페이스에 정의된 insert 메서드의 return type을
		// boolean으로 변경 후 register("아이디값[3자이상]")로 전달되면 정상작동 후
		// true 리턴, 아니면 false 리턴을 하여 웹애플리케이션이 작동하도록 만들기
		
		System.out.println("\n데이터베이스의 종류를 선택하세요 >");
		System.out.println("1.MySQL / 2.Oracle");
		int db = sc.nextInt();
		
		Service svc = new WebService(db);
		System.out.println("아이디를 입력하세요(3자이상) >");
		String id = sc.next();
//		svc.register(id);
	}

}
